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
package fr.peralta.mycellar.application.wine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.peralta.mycellar.application.shared.AbstractEntitySearchFormService;
import fr.peralta.mycellar.application.wine.AppellationService;
import fr.peralta.mycellar.domain.shared.exception.BusinessError;
import fr.peralta.mycellar.domain.shared.exception.BusinessException;
import fr.peralta.mycellar.domain.wine.Appellation;
import fr.peralta.mycellar.domain.wine.repository.AppellationOrder;
import fr.peralta.mycellar.domain.wine.repository.AppellationOrderEnum;
import fr.peralta.mycellar.domain.wine.repository.AppellationRepository;

/**
 * @author speralta
 */
@Service
public class AppellationServiceImpl
        extends
        AbstractEntitySearchFormService<Appellation, AppellationOrderEnum, AppellationOrder, AppellationRepository>
        implements AppellationService {

    private AppellationRepository appellationRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(Appellation entity) throws BusinessException {
        if ((entity.getId() != null)
                && (appellationRepository.findAppellation(entity.getRegion(),
                        entity.getName()) != null)) {
            throw new BusinessException(BusinessError.APPELLATION_00001);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AppellationRepository getRepository() {
        return appellationRepository;
    }

    /**
     * @param appellationRepository
     *            the appellationRepository to set
     */
    @Autowired
    public void setAppellationRepository(AppellationRepository appellationRepository) {
        this.appellationRepository = appellationRepository;
    }

}
