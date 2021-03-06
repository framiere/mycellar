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
package fr.peralta.mycellar.application.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.peralta.mycellar.application.shared.AbstractEntityService;
import fr.peralta.mycellar.application.stock.BottleService;
import fr.peralta.mycellar.domain.shared.exception.BusinessError;
import fr.peralta.mycellar.domain.shared.exception.BusinessException;
import fr.peralta.mycellar.domain.stock.Bottle;
import fr.peralta.mycellar.domain.stock.repository.BottleOrder;
import fr.peralta.mycellar.domain.stock.repository.BottleOrderEnum;
import fr.peralta.mycellar.domain.stock.repository.BottleRepository;
import fr.peralta.mycellar.domain.wine.Format;
import fr.peralta.mycellar.domain.wine.Wine;

/**
 * @author speralta
 */
@Service
public class BottleServiceImpl extends
        AbstractEntityService<Bottle, BottleOrderEnum, BottleOrder, BottleRepository> implements
        BottleService {

    private BottleRepository bottleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(Bottle entity) throws BusinessException {
        Bottle existing = find(entity.getWine(), entity.getFormat());
        if ((existing != null)
                && ((entity.getId() == null) || !existing.getId().equals(entity.getId()))) {
            throw new BusinessException(BusinessError.BOTTLE_00001);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bottle find(Wine wine, Format format) {
        return bottleRepository.find(wine, format);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BottleRepository getRepository() {
        return bottleRepository;
    }

    /**
     * @param bottleRepository
     *            the bottleRepository to set
     */
    @Autowired
    public void setBottleRepository(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

}
