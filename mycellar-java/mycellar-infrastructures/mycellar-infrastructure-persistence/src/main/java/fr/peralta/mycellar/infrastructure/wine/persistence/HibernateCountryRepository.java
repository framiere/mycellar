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
package fr.peralta.mycellar.infrastructure.wine.persistence;

import java.util.List;
import java.util.Map;

import fr.peralta.mycellar.domain.wine.Country;
import fr.peralta.mycellar.domain.wine.CountryRepository;

/**
 * @author speralta
 */
public class HibernateCountryRepository implements CountryRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Country, Integer> getAllWithCounts() {
        // TODO Auto-generated method stub
        return null;
    }

}