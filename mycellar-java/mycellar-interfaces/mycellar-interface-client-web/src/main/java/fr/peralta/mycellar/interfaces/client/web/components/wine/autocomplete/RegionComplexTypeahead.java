/*
 * Copyright 2011, MyCellar
 *
 * This file is part of MyCellar.
 *
 * MyCellar is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyCellar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MyCellar. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.peralta.mycellar.interfaces.client.web.components.wine.autocomplete;

import java.util.List;

import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import fr.peralta.mycellar.domain.shared.repository.FilterEnum;
import fr.peralta.mycellar.domain.shared.repository.SearchForm;
import fr.peralta.mycellar.domain.wine.Country;
import fr.peralta.mycellar.domain.wine.Region;
import fr.peralta.mycellar.interfaces.client.web.components.shared.Action;
import fr.peralta.mycellar.interfaces.client.web.components.shared.AjaxTool;
import fr.peralta.mycellar.interfaces.client.web.components.shared.autocomplete.ComplexIdentifiedEntityTypeahead;
import fr.peralta.mycellar.interfaces.client.web.components.shared.form.ObjectForm;
import fr.peralta.mycellar.interfaces.client.web.components.wine.form.RegionForm;
import fr.peralta.mycellar.interfaces.client.web.shared.FilterEnumHelper;
import fr.peralta.mycellar.interfaces.facades.wine.WineServiceFacade;

/**
 * @author speralta
 */
public class RegionComplexTypeahead extends ComplexIdentifiedEntityTypeahead<Region> {

    private static final long serialVersionUID = 201107252130L;

    private static final String COUNTRY_COMPONENT_ID = "country";

    @SpringBean
    private WineServiceFacade wineServiceFacade;

    private final CountryComplexTypeahead countryComplexTypeahead;

    /**
     * @param id
     * @param label
     * @param searchFormModel
     * @param filters
     */
    public RegionComplexTypeahead(String id, IModel<String> label,
            IModel<SearchForm> searchFormModel, FilterEnum... filters) {
        super(id, label, searchFormModel, filters);
        add(countryComplexTypeahead = new CountryComplexTypeahead(COUNTRY_COMPONENT_ID,
                new StringResourceModel("country", this, null), searchFormModel,
                FilterEnumHelper.removeFilter(filters, FilterEnum.REGION)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setOtherComponentsVisibilityAllowed(boolean allowed) {
        countryComplexTypeahead.setVisibilityAllowed(allowed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Region> getChoices(String term) {
        return wineServiceFacade.getRegionsLike(term, getSearchFormModel().getObject(),
                getFilters());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isReadyToSelect() {
        return countryComplexTypeahead.isValued();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onInitialize() {
        super.onInitialize();
        if (isValuedAtStart()) {
            getSearchFormModel().getObject().replaceSet(FilterEnum.REGION, getModelObject());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ObjectForm<Region> createForm(String id, IModel<SearchForm> searchFormModel) {
        return new RegionForm(id, searchFormModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Region createObject() {
        Region region = new Region();
        region.setCountry(countryComplexTypeahead.getModelObject());
        return region;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onModelChanged(IEvent<?> event) {
        getSearchFormModel().getObject().replaceSet(FilterEnum.COUNTRY,
                countryComplexTypeahead.getModelObject());
        if (!countryComplexTypeahead.isValued()) {
            markAsNonValued();
            send(this, Broadcast.EXACT, Action.CANCEL);
        } else {
            Country country = countryComplexTypeahead.getModelObject();
            if ((country != null) && (country.getId() == null)) {
                setDefaultModelObject(createObject());
                send(this, Broadcast.EXACT, Action.ADD);
            }
        }
        AjaxTool.ajaxReRender(this);
        event.stop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FilterEnum getFilterToReplace() {
        return FilterEnum.REGION;
    }
}
