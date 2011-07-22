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
package fr.peralta.mycellar.interfaces.client.web.components.wine.cloud;

import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import fr.peralta.mycellar.domain.wine.Format;
import fr.peralta.mycellar.interfaces.client.web.components.shared.cloud.ComplexTagCloud;
import fr.peralta.mycellar.interfaces.client.web.components.wine.edit.FormatEditPanel;

/**
 * @author speralta
 */
public class FormatComplexTagCloud extends ComplexTagCloud<Format> {

    private static final long serialVersionUID = 201011071626L;

    /**
     * @param id
     * @param label
     * @param objects
     * @param parentToReRender
     */
    public FormatComplexTagCloud(String id, IModel<?> label, Map<Format, Integer> objects,
            Class<? extends Component> parentToReRender) {
        super(id, label, objects, parentToReRender);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Component createComponentForCreation(String id) {
        return new FormatEditPanel(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Format createObject() {
        return new Format();
    }

}