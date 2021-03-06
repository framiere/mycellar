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

import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import fr.peralta.mycellar.domain.shared.repository.FilterEnum;
import fr.peralta.mycellar.domain.shared.repository.SearchForm;
import fr.peralta.mycellar.domain.wine.Country;
import fr.peralta.mycellar.interfaces.client.web.components.shared.autocomplete.ComplexIdentifiedEntityTypeahead;
import fr.peralta.mycellar.interfaces.client.web.components.shared.form.ObjectForm;
import fr.peralta.mycellar.interfaces.client.web.components.wine.form.CountryForm;
import fr.peralta.mycellar.interfaces.facades.wine.WineServiceFacade;

/**
 * @author speralta
 */
public class CountryComplexTypeahead extends ComplexIdentifiedEntityTypeahead<Country> {

    private static final long serialVersionUID = 201107252130L;

    @SpringBean
    private WineServiceFacade wineServiceFacade;

    /**
     * @param id
     * @param label
     * @param searchFormModel
     * @param filters
     */
    public CountryComplexTypeahead(String id, IModel<String> label,
            IModel<SearchForm> searchFormModel, FilterEnum... filters) {
        super(id, label, searchFormModel, filters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> getChoices(String term) {
        return wineServiceFacade.getCountriesLike(term, getSearchFormModel().getObject(),
                getFilters());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ObjectForm<Country> createForm(String id, IModel<SearchForm> searchFormModel) {
        return new CountryForm(id, searchFormModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Country createObject() {
        return new Country();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FilterEnum getFilterToReplace() {
        return FilterEnum.COUNTRY;
    }
}
