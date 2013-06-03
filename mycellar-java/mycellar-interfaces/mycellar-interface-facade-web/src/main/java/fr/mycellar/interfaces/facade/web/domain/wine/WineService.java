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
package fr.mycellar.interfaces.facade.web.domain.wine;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.peralta.mycellar.domain.shared.repository.SearchForm;
import fr.peralta.mycellar.domain.wine.Wine;
import fr.peralta.mycellar.domain.wine.repository.WineOrder;
import fr.peralta.mycellar.interfaces.facades.wine.WineServiceFacade;

/**
 * @author speralta
 */
@Service
@Path("/domain/wine/wines")
public class WineService {

    private WineServiceFacade wineServiceFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("count")
    public long countWines() {
        return wineServiceFacade.countWines(new SearchForm());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public List<Wine> getWines(@QueryParam("first") long first, @QueryParam("count") long count) {
        WineOrder orders = new WineOrder();
        return wineServiceFacade.getWines(new SearchForm(), orders, first, count);
    }

    /**
     * @param wineServiceFacade
     *            the wineServiceFacade to set
     */
    @Autowired
    public void setWineServiceFacade(WineServiceFacade wineServiceFacade) {
        this.wineServiceFacade = wineServiceFacade;
    }

}
