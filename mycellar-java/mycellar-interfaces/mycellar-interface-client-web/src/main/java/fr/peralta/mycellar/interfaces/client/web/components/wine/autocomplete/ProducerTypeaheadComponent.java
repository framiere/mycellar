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

import org.apache.wicket.spring.injection.annot.SpringBean;

import fr.peralta.mycellar.domain.wine.Producer;
import fr.peralta.mycellar.interfaces.client.web.components.shared.autocomplete.AbstractTypeaheadComponent;
import fr.peralta.mycellar.interfaces.facades.wine.WineServiceFacade;

/**
 * @author speralta
 */
public class ProducerTypeaheadComponent extends AbstractTypeaheadComponent<Producer> {

    private static final long serialVersionUID = 201107252130L;

    @SpringBean
    private WineServiceFacade wineServiceFacade;

    /**
     * @param id
     */
    public ProducerTypeaheadComponent(String id) {
        super(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producer> getChoices(String term) {
        return wineServiceFacade.getProducersLike(term);
    }
}