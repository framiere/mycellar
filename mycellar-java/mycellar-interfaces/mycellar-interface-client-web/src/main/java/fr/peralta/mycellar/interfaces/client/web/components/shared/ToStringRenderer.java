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
package fr.peralta.mycellar.interfaces.client.web.components.shared;

import java.io.Serializable;

import org.apache.wicket.extensions.markup.html.form.select.IOptionRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author speralta
 */
public class ToStringRenderer<T extends Serializable> implements IOptionRenderer<T> {
    private static final long serialVersionUID = 201205231119L;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayValue(T object) {
        return object.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IModel<T> getModel(T value) {
        return new Model<T>(value);
    }
}