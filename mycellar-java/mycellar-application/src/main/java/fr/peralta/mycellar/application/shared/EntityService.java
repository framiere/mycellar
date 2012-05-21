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
package fr.peralta.mycellar.application.shared;

import java.util.List;

import fr.peralta.mycellar.domain.shared.IdentifiedEntity;
import fr.peralta.mycellar.domain.shared.exception.BusinessException;
import fr.peralta.mycellar.domain.shared.repository.AbstractEntityOrder;

/**
 * @author speralta
 */
public interface EntityService<E extends IdentifiedEntity, OE, O extends AbstractEntityOrder<OE, O>> {
    /**
     * @param entity
     */
    void delete(E entity);

    /**
     * @param id
     * @return
     */
    E getById(Integer id);

    /**
     * @param entity
     */
    void save(E entity) throws BusinessException;

    /**
     * @param entity
     * @throws BusinessException
     */
    void validate(E entity) throws BusinessException;

    /**
     * @return
     */
    long count();

    /**
     * @param orders
     * @param first
     * @param count
     * @return
     */
    List<E> getAll(O orders, int first, int count);
}
