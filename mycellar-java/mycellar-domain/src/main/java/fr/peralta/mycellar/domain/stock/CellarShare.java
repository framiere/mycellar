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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.validator.constraints.Email;

import fr.peralta.mycellar.domain.shared.IdentifiedEntity;

/**
 * @author speralta
 */
@Entity
@Table(name = "CELLAR_SHARE", uniqueConstraints = @UniqueConstraint(columnNames = { "EMAIL",
        "CELLAR" }))
@SequenceGenerator(name = "CELLAR_SHARE_ID_GENERATOR", allocationSize = 1)
public class CellarShare extends IdentifiedEntity {

    private static final long serialVersionUID = 201201231020L;

    @Id
    @GeneratedValue(generator = "CELLAR_SHARE_ID_GENERATOR")
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "ACCESS_RIGHT", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AccessRightEnum accessRight;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "CELLAR", nullable = false)
    private Cellar cellar;

    /**
     * @return the id
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the accessRight
     */
    public AccessRightEnum getAccessRight() {
        return accessRight;
    }

    /**
     * @param accessRight
     *            the accessRight to set
     */
    public void setAccessRight(AccessRightEnum accessRight) {
        this.accessRight = accessRight;
    }

    /**
     * @return the cellar
     */
    public Cellar getCellar() {
        return cellar;
    }

    /**
     * @param cellar
     *            the cellar to set
     */
    public void setCellar(Cellar cellar) {
        this.cellar = cellar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean dataEquals(IdentifiedEntity other) {
        CellarShare cellarShare = (CellarShare) other;
        return ObjectUtils.equals(getEmail(), cellarShare.getEmail())
                && ObjectUtils.equals(getAccessRight(), cellarShare.getAccessRight())
                && ObjectUtils.equals(getCellar(), cellarShare.getCellar());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object[] getHashCodeData() {
        return new Object[] { getCellar(), getEmail(), getAccessRight() };
    }

}
