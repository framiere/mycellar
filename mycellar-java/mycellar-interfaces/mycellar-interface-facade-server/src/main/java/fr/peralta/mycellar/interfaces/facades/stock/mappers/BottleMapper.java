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
package fr.peralta.mycellar.interfaces.facades.stock.mappers;

import fr.peralta.mycellar.domain.stock.Bottle;
import fr.peralta.mycellar.interfaces.facades.shared.mappers.AbstractMapper;

/**
 * @author speralta
 */
public class BottleMapper extends
        AbstractMapper<fr.peralta.mycellar.interfaces.facades.stock.dto.Bottle, Bottle> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Bottle map(fr.peralta.mycellar.interfaces.facades.stock.dto.Bottle from) {
        // FIXME when bottle dto will be complete
        return new Bottle(null, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<fr.peralta.mycellar.interfaces.facades.stock.dto.Bottle> getFromClass() {
        return fr.peralta.mycellar.interfaces.facades.stock.dto.Bottle.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<Bottle> getToClass() {
        return Bottle.class;
    }

}
