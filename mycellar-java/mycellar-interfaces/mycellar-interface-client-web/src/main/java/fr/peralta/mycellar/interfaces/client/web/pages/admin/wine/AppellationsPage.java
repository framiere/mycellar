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
package fr.peralta.mycellar.interfaces.client.web.pages.admin.wine;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import fr.peralta.mycellar.domain.shared.repository.SearchForm;
import fr.peralta.mycellar.domain.wine.Appellation;
import fr.peralta.mycellar.domain.wine.repository.AppellationOrder;
import fr.peralta.mycellar.domain.wine.repository.AppellationOrderEnum;
import fr.peralta.mycellar.interfaces.client.web.components.shared.SearchFormModel;
import fr.peralta.mycellar.interfaces.client.web.components.shared.data.MultipleSortableDataProvider;
import fr.peralta.mycellar.interfaces.client.web.components.wine.data.AppellationDataProvider;
import fr.peralta.mycellar.interfaces.client.web.pages.admin.AbstractEditPage;
import fr.peralta.mycellar.interfaces.client.web.pages.admin.AbstractListPage;

/**
 * @author speralta
 */
public class AppellationsPage extends
        AbstractListPage<Appellation, AppellationOrderEnum, AppellationOrder> {

    private static final long serialVersionUID = 201203262250L;

    /**
     * @param parameters
     */
    public AppellationsPage(PageParameters parameters) {
        super(parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected MultipleSortableDataProvider<Appellation, AppellationOrderEnum, AppellationOrder> getDataProvider() {
        return new AppellationDataProvider(new SearchFormModel(new SearchForm()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<IColumn<Appellation>> getColumns() {
        List<IColumn<Appellation>> columns = new ArrayList<IColumn<Appellation>>();
        columns.add(new PropertyColumn<Appellation>(new ResourceModel("country"),
                AppellationOrderEnum.COUNTRY_NAME.name(), "region.country.name"));
        columns.add(new PropertyColumn<Appellation>(new ResourceModel("region"),
                AppellationOrderEnum.REGION_NAME.name(), "region.name"));
        columns.add(new PropertyColumn<Appellation>(new ResourceModel("name"),
                AppellationOrderEnum.NAME.name(), "name"));
        return columns;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected PageParameters getEditPageParameters(Appellation object) {
        if (object == null) {
            return AppellationPage.getPageParametersForCreation();
        } else {
            return AppellationPage.getPageParameters(object);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<? extends AbstractEditPage<Appellation>> getEditPageClass() {
        return AppellationPage.class;
    }

}