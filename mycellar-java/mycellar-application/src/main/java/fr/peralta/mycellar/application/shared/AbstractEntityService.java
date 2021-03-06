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
import fr.peralta.mycellar.domain.shared.repository.AbstractEntityOrder;
import fr.peralta.mycellar.domain.shared.repository.EntityRepository;

/**
 * @author speralta
 */
public abstract class AbstractEntityService<E extends IdentifiedEntity, OE, O extends AbstractEntityOrder<OE, O>, R extends EntityRepository<E, OE, O>>
        extends AbstractSimpleService<E, R> implements EntityService<E, OE, O> {

    /**
     * {@inheritDoc}
     */
    @Override
    public final long count() {
        return getRepository().count();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<E> getAll(O orders, long first, long count) {
        return getRepository().getAll(orders, first, count);
    }

}
