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
package fr.peralta.mycellar.interfaces.facades.stock;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.peralta.mycellar.application.stock.BottleService;
import fr.peralta.mycellar.application.stock.CellarService;
import fr.peralta.mycellar.application.stock.CellarShareService;
import fr.peralta.mycellar.application.stock.MovementService;
import fr.peralta.mycellar.application.stock.StockService;
import fr.peralta.mycellar.domain.shared.exception.BusinessException;
import fr.peralta.mycellar.domain.shared.repository.CountEnum;
import fr.peralta.mycellar.domain.shared.repository.FilterEnum;
import fr.peralta.mycellar.domain.shared.repository.SearchForm;
import fr.peralta.mycellar.domain.stock.Arrival;
import fr.peralta.mycellar.domain.stock.Bottle;
import fr.peralta.mycellar.domain.stock.Cellar;
import fr.peralta.mycellar.domain.stock.CellarShare;
import fr.peralta.mycellar.domain.stock.Drink;
import fr.peralta.mycellar.domain.stock.Movement;
import fr.peralta.mycellar.domain.stock.Stock;
import fr.peralta.mycellar.domain.stock.repository.CellarOrder;
import fr.peralta.mycellar.domain.stock.repository.CellarShareOrder;
import fr.peralta.mycellar.domain.stock.repository.MovementOrder;
import fr.peralta.mycellar.domain.stock.repository.StockOrder;
import fr.peralta.mycellar.domain.wine.Format;
import fr.peralta.mycellar.domain.wine.Wine;

/**
 * @author speralta
 */
@Service
public class StockServiceFacadeImpl implements StockServiceFacade {

    private BottleService bottleService;

    private CellarService cellarService;

    private CellarShareService cellarShareService;

    private MovementService movementService;

    private StockService stockService;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void arrival(Arrival arrival) {
        stockService.stock(arrival);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public long countCellars(SearchForm searchForm) {
        return cellarService.count(searchForm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public long countCellarShares(SearchForm searchForm) {
        return cellarShareService.count(searchForm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public long countMovements(SearchForm searchForm) {
        return movementService.count(searchForm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public long countStocks(SearchForm searchForm) {
        return stockService.countStocks(searchForm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteCellar(Cellar cellar) throws BusinessException {
        cellarService.delete(cellar);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteCellarShare(CellarShare cellarShare) throws BusinessException {
        cellarShareService.delete(cellarShare);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void drink(Drink drink) {
        stockService.drink(drink);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Bottle findBottle(Wine wine, Format format) {
        return bottleService.find(wine, format);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Cellar getCellarById(Integer cellarId) {
        return cellarService.getById(cellarId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CellarShare getCellarShareById(Integer cellarShareId) {
        return cellarShareService.getById(cellarShareId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cellar> getCellars(SearchForm searchForm, CellarOrder order, long first, long count) {
        return cellarService.getAll(searchForm, order, first, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Map<Cellar, Long> getCellars(SearchForm searchForm, CountEnum count,
            FilterEnum... filters) {
        return cellarService.getAll(searchForm, count, filters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CellarShare> getCellarShares(SearchForm searchForm, CellarShareOrder order,
            long first, long count) {
        return cellarShareService.getAll(searchForm, order, first, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Movement> getMovements(SearchForm searchForm, MovementOrder orders, long first,
            long count) {
        return movementService.getAll(searchForm, orders, first, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Stock> getStocks(SearchForm searchForm, StockOrder orders, long first, long count) {
        return stockService.getStocks(searchForm, orders, first, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveCellar(Cellar cellar) throws BusinessException {
        cellarService.save(cellar);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveCellarShare(CellarShare cellarShare) throws BusinessException {
        cellarShareService.save(cellarShare);
    }

    /**
     * @param bottleService
     *            the bottleService to set
     */
    @Autowired
    public void setBottleService(BottleService bottleService) {
        this.bottleService = bottleService;
    }

    /**
     * @param cellarService
     *            the cellarService to set
     */
    @Autowired
    public void setCellarService(CellarService cellarService) {
        this.cellarService = cellarService;
    }

    /**
     * @param cellarShareService
     *            the cellarShareService to set
     */
    @Autowired
    public void setCellarShareService(CellarShareService cellarShareService) {
        this.cellarShareService = cellarShareService;
    }

    /**
     * @param movementService
     *            the movementService to set
     */
    @Autowired
    public void setMovementService(MovementService movementService) {
        this.movementService = movementService;
    }

    /**
     * @param stockService
     *            the stockService to set
     */
    @Autowired
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

}
