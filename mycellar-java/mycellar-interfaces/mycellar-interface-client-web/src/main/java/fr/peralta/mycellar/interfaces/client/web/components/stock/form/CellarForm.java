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
package fr.peralta.mycellar.interfaces.client.web.components.stock.form;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import fr.peralta.mycellar.domain.shared.repository.SearchForm;
import fr.peralta.mycellar.domain.stock.Cellar;
import fr.peralta.mycellar.interfaces.client.web.components.shared.form.ObjectForm;
import fr.peralta.mycellar.interfaces.client.web.components.stock.edit.CellarEditPanel;

/**
 * @author speralta
 */
public class CellarForm extends ObjectForm<Cellar> {

    private static final long serialVersionUID = 201205101327L;

    /**
     * @param id
     * @param searchFormModel
     * @param newObject
     */
    public CellarForm(String id, IModel<SearchForm> searchFormModel, Cellar newObject) {
        super(id, searchFormModel, newObject);
    }

    /**
     * @param id
     * @param searchFormModel
     */
    public CellarForm(String id, IModel<SearchForm> searchFormModel) {
        super(id, searchFormModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Component createEditPanel(String id, IModel<SearchForm> searchFormModel) {
        return new CellarEditPanel(id);
    }

}
