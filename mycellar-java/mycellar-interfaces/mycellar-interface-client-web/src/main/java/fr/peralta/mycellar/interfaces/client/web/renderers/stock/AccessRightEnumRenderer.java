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
package fr.peralta.mycellar.interfaces.client.web.renderers.stock;

import org.apache.wicket.WicketRuntimeException;
import org.springframework.stereotype.Service;

import fr.peralta.mycellar.domain.stock.AccessRightEnum;
import fr.peralta.mycellar.interfaces.client.web.renderers.shared.AbstractRenderer;

/**
 * @author speralta
 */
@Service
public class AccessRightEnumRenderer extends AbstractRenderer<AccessRightEnum> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLabel(AccessRightEnum object) {
        if (object == null) {
            return NULL_OBJECT;
        }
        switch (object) {
        case MODIFY:
            return "Modification";
        case READ:
            return "Lecture seule";
        default:
            throw new WicketRuntimeException("Unknown access right '" + object + "'.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<AccessRightEnum> getRenderedClass() {
        return AccessRightEnum.class;
    }

}