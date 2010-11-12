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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.ObjectUtils;

import fr.peralta.mycellar.domain.shared.IdentifiedEntity;

/**
 * @author bperalta
 * 
 */
@Entity
@Table(name = "CELLAR")
@SequenceGenerator(name = "CELLAR_ID_GENERATOR", allocationSize = 1)
public class Cellar extends IdentifiedEntity<Cellar> {

    private static final long serialVersionUID = 201011111734L;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "USER", nullable = false)
    private User user;

    @Id
    @GeneratedValue(generator = "CELLAR_ID_GENERATOR")
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    /**
     * @param name
     * @param capacity
     */
    public Cellar(String name, User user) {
        this.name = name;
        this.user = user;
    }

    /**
     * Needed by Hibernate
     */
    Cellar() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean dataEquals(Cellar other) {
        return ObjectUtils.equals(getName(), other.getName())
                && ObjectUtils.equals(getUser(), other.getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object[] getHashCodeData() {
        return new Object[] { getName(), getUser() };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

}