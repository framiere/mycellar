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
package fr.peralta.mycellar.interfaces.facades.admin;

import java.util.List;

import fr.peralta.mycellar.domain.admin.Configuration;
import fr.peralta.mycellar.domain.admin.repository.ConfigurationOrder;
import fr.peralta.mycellar.domain.shared.exception.BusinessException;

/**
 * @author speralta
 */
public interface AdministrationServiceFacade {

    /**
     * @return
     */
    long countConfigurations();

    /**
     * @param configurationId
     * @return
     */
    Configuration getConfigurationById(Integer configurationId);

    /**
     * @param orders
     * @param first
     * @param count
     * @return
     */
    List<Configuration> getConfigurations(ConfigurationOrder orders, long first, long count);

    /**
     * @param configuration
     * @throws BusinessException
     */
    void saveConfiguration(Configuration configuration) throws BusinessException;

    /**
     * @param configuration
     * @throws BusinessException
     */
    void deleteConfiguration(Configuration configuration) throws BusinessException;

}
