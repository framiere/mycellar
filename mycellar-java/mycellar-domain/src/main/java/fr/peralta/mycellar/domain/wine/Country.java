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
package fr.peralta.mycellar.domain.wine;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import fr.peralta.mycellar.domain.position.Map;
import fr.peralta.mycellar.domain.shared.IdentifiedEntity;
import fr.peralta.mycellar.domain.shared.NamedEntity;

/**
 * @author speralta
 */
@Entity
@Table(name = "COUNTRY")
@AttributeOverride(name = "name", column = @Column(name = "NAME", nullable = false, unique = true))
@SequenceGenerator(name = "COUNTRY_ID_GENERATOR", allocationSize = 1)
public class Country extends NamedEntity {

    private static final long serialVersionUID = 201111181451L;

    @Column(name = "DESCRIPTION")
    private String description;

    @Id
    @GeneratedValue(generator = "COUNTRY_ID_GENERATOR")
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Embedded
    private Map map;

    @OneToMany(mappedBy = "country")
    private final Set<Region> regions = new HashSet<Region>();

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the id
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @return the map
     */
    public Map getMap() {
        return map;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param map
     *            the map to set
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean dataEquals(IdentifiedEntity other) {
        Country country = (Country) other;
        return ObjectUtils.equals(getName(), country.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object[] getHashCodeData() {
        return new Object[] { getName() };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ToStringBuilder toStringBuilder() {
        return super.toStringBuilder().append("description", description).append("map", map);
    }

}
