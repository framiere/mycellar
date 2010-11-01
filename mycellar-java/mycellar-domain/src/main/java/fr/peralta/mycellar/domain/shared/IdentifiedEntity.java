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
package fr.peralta.mycellar.domain.shared;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;

/**
 * @author speralta
 */
@MappedSuperclass
public abstract class IdentifiedEntity<E extends IdentifiedEntity<E>>
        implements Serializable {

    private static final long serialVersionUID = 201010311742L;

    @Version
    private int version;

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    public abstract Integer getId();

    /**
     * Utility method for <code>hashCode()</code> methods.
     * 
     * @param values
     *            the values to use in calculation
     * @return the hash code value
     */
    protected int calculateHashCode(final Object... values) {
        HashCodeBuilder builder = new HashCodeBuilder();
        for (Object value : values) {
            builder.append(value);
        }
        return builder.toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return calculateHashCode(getHashCodeData());
    }

    /**
     * Get the data used to calculate hash code; use getters not fields in case
     * the instance is a proxy.
     * 
     * @return the data
     */
    protected abstract Object[] getHashCodeData();

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public final boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        // looks into the target class of a proxy if necessary
        if (other == null
                || !Hibernate.getClass(other).equals(Hibernate.getClass(this))) {
            return false;
        }

        // if pks are both set, compare
        if (getId() != null) {
            Integer otherId = ((IdentifiedEntity<?>) other).getId();
            if (otherId != null) {
                return getId().equals(otherId);
            }
        }

        return dataEquals((E) other);
    }

    /**
     * Compare data only; null, class, and pk have been checked.
     * 
     * @param other
     *            the other instance
     * @return <code>true</code> if equal
     */
    protected abstract boolean dataEquals(E other);

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(id:" + getId() + ")";
    }

}
