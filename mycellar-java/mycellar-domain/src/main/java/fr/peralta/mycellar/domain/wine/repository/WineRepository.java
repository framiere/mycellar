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
package fr.peralta.mycellar.domain.wine.repository;

import java.util.List;
import java.util.Map;

import fr.peralta.mycellar.domain.wine.Appellation;
import fr.peralta.mycellar.domain.wine.Country;
import fr.peralta.mycellar.domain.wine.Format;
import fr.peralta.mycellar.domain.wine.Producer;
import fr.peralta.mycellar.domain.wine.Region;
import fr.peralta.mycellar.domain.wine.Wine;
import fr.peralta.mycellar.domain.wine.WineColorEnum;
import fr.peralta.mycellar.domain.wine.WineTypeEnum;

/**
 * @author speralta
 */
public interface WineRepository {

    /**
     * @param searchForm
     * @return
     */
    long countWines(WineSearchForm searchForm);

    /**
     * @param searchForm
     * @param orders
     * @param first
     * @param count
     * @return
     */
    List<Wine> getWines(WineSearchForm searchForm, WineOrder orders, int first, int count);

    /**
     * @param searchForm
     * @param countryCountEnum
     * @return
     */
    Map<Country, Long> getCountries(CountrySearchForm searchForm, CountryCountEnum countryCountEnum);

    /**
     * @param searchForm
     * @param regionCountEnum
     * @return
     */
    Map<Region, Long> getRegions(RegionSearchForm searchForm, RegionCountEnum regionCountEnum);

    /**
     * @param searchForm
     * @param appellationCountEnum
     * @return
     */
    Map<Appellation, Long> getAppellations(AppellationSearchForm searchForm,
            AppellationCountEnum appellationCountEnum);

    /**
     * @param term
     * @return
     */
    List<Producer> getAllProducersLike(String term);

    /**
     * @param producers
     * @return
     */
    Map<WineTypeEnum, Long> getAllTypesFromProducersWithCounts(Producer... producers);

    /**
     * @param types
     * @param producers
     * @return
     */
    Map<WineColorEnum, Long> getAllColorsFromTypesAndProducersWithCounts(WineTypeEnum[] types,
            Producer... producers);

    /**
     * @return
     */
    Map<Format, Long> getAllFormatWithCounts();

}
