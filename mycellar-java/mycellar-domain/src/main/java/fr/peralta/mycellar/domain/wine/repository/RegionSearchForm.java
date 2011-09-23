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
package fr.peralta.mycellar.domain.wine.repository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import fr.peralta.mycellar.domain.stock.Cellar;
import fr.peralta.mycellar.domain.user.User;
import fr.peralta.mycellar.domain.wine.Country;

/**
 * @author speralta
 */
public class RegionSearchForm implements Serializable {

    private static final long serialVersionUID = 201109211730L;

    private final User user;
    private final Set<Cellar> cellars = new HashSet<Cellar>();
    private final Set<Country> countries = new HashSet<Country>();

    /**
     * Default constructor.
     */
    public RegionSearchForm() {
        user = null;
    }

    /**
     * @param user
     */
    public RegionSearchForm(User user) {
        this.user = user;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the cellars
     */
    public Set<Cellar> getCellars() {
        return cellars;
    }

    /**
     * @return the countries
     */
    public Set<Country> getCountries() {
        return countries;
    }

}
