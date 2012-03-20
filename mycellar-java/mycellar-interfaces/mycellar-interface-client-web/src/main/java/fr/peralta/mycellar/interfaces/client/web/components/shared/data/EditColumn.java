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
package fr.peralta.mycellar.interfaces.client.web.components.shared.data;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IStyledColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * @author speralta
 */
public class EditColumn<T> implements IStyledColumn<T> {

    private static final long serialVersionUID = 201201251241L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void populateItem(Item<ICellPopulator<T>> cellItem, String componentId,
            IModel<T> rowModel) {
        cellItem.add(new EditRemovePanel(componentId, rowModel));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCssClass() {
        return "ca";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void detach() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Component getHeader(String componentId) {
        return new AddPanel(componentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSortProperty() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSortable() {
        return false;
    }

}