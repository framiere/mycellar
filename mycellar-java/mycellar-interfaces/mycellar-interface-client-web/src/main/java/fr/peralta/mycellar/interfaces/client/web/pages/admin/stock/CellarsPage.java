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
package fr.peralta.mycellar.interfaces.client.web.pages.admin.stock;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import fr.peralta.mycellar.domain.shared.exception.BusinessException;
import fr.peralta.mycellar.domain.shared.repository.SearchForm;
import fr.peralta.mycellar.domain.stock.Cellar;
import fr.peralta.mycellar.domain.stock.repository.CellarOrder;
import fr.peralta.mycellar.domain.stock.repository.CellarOrderEnum;
import fr.peralta.mycellar.interfaces.client.web.components.shared.SearchFormModel;
import fr.peralta.mycellar.interfaces.client.web.components.shared.data.MultipleSortableDataProvider;
import fr.peralta.mycellar.interfaces.client.web.components.stock.data.CellarDataProvider;
import fr.peralta.mycellar.interfaces.client.web.pages.admin.AbstractEditPage;
import fr.peralta.mycellar.interfaces.client.web.pages.admin.AbstractListPage;
import fr.peralta.mycellar.interfaces.facades.stock.StockServiceFacade;

/**
 * @author speralta
 */
public class CellarsPage extends AbstractListPage<Cellar, CellarOrderEnum, CellarOrder> {

    private static final long serialVersionUID = 201203262250L;

    @SpringBean
    private StockServiceFacade stockServiceFacade;

    /**
     * @param parameters
     */
    public CellarsPage(PageParameters parameters) {
        super(parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected MultipleSortableDataProvider<Cellar, CellarOrderEnum, CellarOrder> getDataProvider() {
        return new CellarDataProvider(new SearchFormModel(new SearchForm()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<IColumn<Cellar, CellarOrderEnum>> getColumns() {
        List<IColumn<Cellar, CellarOrderEnum>> columns = new ArrayList<IColumn<Cellar, CellarOrderEnum>>();
        columns.add(new PropertyColumn<Cellar, CellarOrderEnum>(new ResourceModel("owner.email"),
                CellarOrderEnum.OWNER_EMAIL, "owner.email"));
        columns.add(new PropertyColumn<Cellar, CellarOrderEnum>(
                new ResourceModel("owner.lastname"), CellarOrderEnum.OWNER_LASTNAME,
                "owner.lastname"));
        columns.add(new PropertyColumn<Cellar, CellarOrderEnum>(
                new ResourceModel("owner.firstname"), CellarOrderEnum.OWNER_FIRSTNAME,
                "owner.firstname"));
        columns.add(new PropertyColumn<Cellar, CellarOrderEnum>(new ResourceModel("name"),
                CellarOrderEnum.NAME, "name"));
        return columns;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected PageParameters getEditPageParameters(Cellar object) {
        if (object == null) {
            return CellarPage.getPageParametersForCreation();
        } else {
            return CellarPage.getPageParameters(object);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<? extends AbstractEditPage<Cellar>> getEditPageClass() {
        return CellarPage.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deleteObject(Cellar object) throws BusinessException {
        stockServiceFacade.deleteCellar(object);
    }

}
