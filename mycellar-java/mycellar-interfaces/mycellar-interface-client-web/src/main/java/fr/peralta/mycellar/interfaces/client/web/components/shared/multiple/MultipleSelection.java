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
package fr.peralta.mycellar.interfaces.client.web.components.shared.multiple;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.basic.Label;

import fr.peralta.mycellar.interfaces.client.web.components.shared.Action;

/**
 * @author speralta
 */
class MultipleSelection<O> extends AjaxLink<MultipleData<O>> {

    private static final long serialVersionUID = 201108161929L;

    /**
     * @param id
     */
    public MultipleSelection(String id) {
        super(id);
        add(new Label("label"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(AjaxRequestTarget target) {
        send(getParent(), Broadcast.BUBBLE, Action.SELECT);
    }
}
