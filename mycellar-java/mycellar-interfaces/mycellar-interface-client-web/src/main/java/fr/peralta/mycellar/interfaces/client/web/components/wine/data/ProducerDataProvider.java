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
package fr.peralta.mycellar.interfaces.client.web.components.wine.data;

import java.util.Iterator;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import fr.peralta.mycellar.domain.shared.repository.OrderWayEnum;
import fr.peralta.mycellar.domain.shared.repository.SearchForm;
import fr.peralta.mycellar.domain.wine.Producer;
import fr.peralta.mycellar.domain.wine.repository.ProducerOrder;
import fr.peralta.mycellar.domain.wine.repository.ProducerOrderEnum;
import fr.peralta.mycellar.interfaces.client.web.components.shared.data.MultipleSortableDataProvider;
import fr.peralta.mycellar.interfaces.facades.wine.WineServiceFacade;

/**
 * @author speralta
 */
public class ProducerDataProvider extends
        MultipleSortableDataProvider<Producer, ProducerOrderEnum, ProducerOrder> {

    private static final long serialVersionUID = 201109192010L;

    @SpringBean
    private WineServiceFacade wineServiceFacade;

    private final IModel<SearchForm> searchFormModel;

    /**
     * @param searchFormModel
     */
    public ProducerDataProvider(IModel<SearchForm> searchFormModel) {
        super(new ProducerOrder().add(ProducerOrderEnum.NAME, OrderWayEnum.ASC));
        Injector.get().inject(this);
        this.searchFormModel = searchFormModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void detach() {
        searchFormModel.detach();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<? extends Producer> iterator(long first, long count) {
        return wineServiceFacade.getProducers(searchFormModel.getObject(), getState().getOrders(),
                first, count).iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long size() {
        return wineServiceFacade.countProducers(searchFormModel.getObject());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IModel<Producer> model(Producer object) {
        return new Model<Producer>(object);
    }

}
