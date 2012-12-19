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
package fr.mycellar.interfaces.web.descriptors.menu.pedia;

import org.springframework.stereotype.Component;

import fr.mycellar.interfaces.web.descriptors.menu.shared.IMenuDescriptor;
import fr.mycellar.interfaces.web.descriptors.shared.AbstractDescriptor;

/**
 * @author speralta
 */
@Component
public class PediaPageDescriptor extends AbstractDescriptor implements IMenuDescriptor {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRoute() {
        return "/pedia";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitleKey() {
        return "vinopedia";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getParentKey() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWeight() {
        return 8000;
    }

}
