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
package fr.peralta.mycellar.domain.stock;

import java.io.Serializable;

/**
 * @author speralta
 */
public class DrinkBottle implements Serializable {

    private static final long serialVersionUID = 201109282231L;

    private Bottle bottle;
    private Integer quantity;

    /**
     * @return the bottle
     */
    public Bottle getBottle() {
        return bottle;
    }

    /**
     * @param bottle
     *            the bottle to set
     */
    public void setBottle(Bottle bottle) {
        this.bottle = bottle;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
