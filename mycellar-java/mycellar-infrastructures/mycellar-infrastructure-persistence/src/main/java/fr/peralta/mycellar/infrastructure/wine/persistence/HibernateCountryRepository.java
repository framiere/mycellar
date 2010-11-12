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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.peralta.mycellar.domain.wine.Country;
import fr.peralta.mycellar.domain.wine.CountryRepository;

/**
 * @author speralta
 */
public class HibernateCountryRepository implements CountryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> getAll() {
        CriteriaQuery<Country> query = entityManager.getCriteriaBuilder()
                .createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        return entityManager.createQuery(query.select(root)).getResultList();
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
