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
package fr.peralta.mycellar.interfaces.client.web.components.shared.cloud;

import java.util.List;

import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * @author speralta
 */
class TagDataModel<E> extends AbstractReadOnlyModel<List<TagData<E>>> {

    private static final long serialVersionUID = 201205091616L;

    private final TagDataProvider<E> provider;

    /**
     * @param provider
     */
    public TagDataModel(TagDataProvider<E> provider) {
        this.provider = provider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TagData<E>> getObject() {
        return provider.getList();
    }

}
