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
package fr.peralta.mycellar.interfaces.client.web.descriptors.menu;

import org.springframework.stereotype.Component;

import fr.peralta.mycellar.interfaces.client.web.descriptors.menu.shared.IMenuDescriptor;
import fr.peralta.mycellar.interfaces.client.web.descriptors.shared.AbstractDescriptor;
import fr.peralta.mycellar.interfaces.client.web.pages.HomePage;

/**
 * @author speralta
 */
@Component
public class HomePageDescriptor extends AbstractDescriptor implements IMenuDescriptor<HomePage> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<HomePage> getMenuableClass() {
        return HomePage.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitleKey() {
        return "home";
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
        return 1000;
    }

}
