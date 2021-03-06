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
package fr.peralta.mycellar.interfaces.client.web.components.shared.nav;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author speralta
 */
public class NavHeaderDescriptor implements NavDescriptor {

    private static final long serialVersionUID = 201011122248L;

    private final SortedMap<Integer, NavPageDescriptor> pages = new TreeMap<Integer, NavPageDescriptor>();

    private final String headerKey;

    /**
     * @param headerKey
     */
    public NavHeaderDescriptor(String headerKey) {
        this.headerKey = headerKey;
    }

    /**
     * @return the headerKey
     */
    public String getHeaderKey() {
        return headerKey;
    }

    /**
     * @return the pages
     */
    public List<NavPageDescriptor> getPages() {
        return new ArrayList<NavPageDescriptor>(pages.values());
    }

    /**
     * @param key
     * @param value
     * @return
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public NavHeaderDescriptor addPage(Integer key, NavPageDescriptor value) {
        Integer finalKey = key;
        while (pages.get(finalKey) != null) {
            finalKey++;
        }
        pages.put(finalKey, value);
        return this;
    }

}
