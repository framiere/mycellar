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
package fr.peralta.mycellar.application.stock;

import org.joda.time.LocalDate;

import fr.peralta.mycellar.application.shared.EntitySearchFormService;
import fr.peralta.mycellar.domain.stock.Bottle;
import fr.peralta.mycellar.domain.stock.Cellar;
import fr.peralta.mycellar.domain.stock.Movement;
import fr.peralta.mycellar.domain.stock.repository.MovementOrder;
import fr.peralta.mycellar.domain.stock.repository.MovementOrderEnum;

/**
 * @author speralta
 */
public interface MovementService extends EntitySearchFormService<Movement, MovementOrderEnum, MovementOrder> {

    /**
     * @param cellar
     * @param bottle
     * @param quantity
     * @param date
     * @param charges
     * @param price
     * @param source
     */
    void createInput(Cellar cellar, Bottle bottle, Integer quantity, LocalDate date, float charges,
            float price, String source);

    /**
     * @param cellar
     * @param bottle
     * @param quantity
     * @param date
     * @param destination
     * @param price
     */
    void createOutput(Cellar cellar, Bottle bottle, Integer quantity, LocalDate date,
            String destination, float price);

}
