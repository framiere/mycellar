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
package fr.peralta.mycellar.infrastructure.shared.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import fr.peralta.mycellar.domain.shared.repository.Range;

/**
 * Type safe {@link Range}s for commons types
 */
public class Ranges {
    public static class RangeInteger<E> extends Range<E, Integer> {
        private static final long serialVersionUID = 1L;

        public RangeInteger(SingularAttribute<E, Integer> field) {
            super(field);
        }

        public static <E> RangeInteger<E> newRangeInteger(SingularAttribute<E, Integer> field) {
            return new RangeInteger<E>(field);
        }
    }

    public static class RangeBigInteger<E> extends Range<E, BigInteger> {
        private static final long serialVersionUID = 1L;

        public RangeBigInteger(SingularAttribute<E, BigInteger> field) {
            super(field);
        }

        public static <E> RangeBigInteger<E> newRangeBigInteger(
                SingularAttribute<E, BigInteger> field) {
            return new RangeBigInteger<E>(field);
        }
    }

    public static class RangeLong<E> extends Range<E, Long> {
        private static final long serialVersionUID = 1L;

        public RangeLong(SingularAttribute<E, Long> field) {
            super(field);
        }

        public static <E> RangeLong<E> newRangeLong(SingularAttribute<E, Long> field) {
            return new RangeLong<E>(field);
        }
    }

    public static class RangeDouble<E> extends Range<E, Double> {
        private static final long serialVersionUID = 1L;

        public RangeDouble(SingularAttribute<E, Double> field) {
            super(field);
        }

        public static <E> RangeDouble<E> newRangeDouble(SingularAttribute<E, Double> field) {
            return new RangeDouble<E>(field);
        }
    }

    public static class RangeFloat<E> extends Range<E, Float> {
        private static final long serialVersionUID = 1L;

        public RangeFloat(SingularAttribute<E, Float> field) {
            super(field);
        }

        public static <E> RangeFloat<E> newRangeFloat(SingularAttribute<E, Float> field) {
            return new RangeFloat<E>(field);
        }
    }

    public static class RangeBigDecimal<E> extends Range<E, BigDecimal> {
        private static final long serialVersionUID = 1L;

        public RangeBigDecimal(SingularAttribute<E, BigDecimal> field) {
            super(field);
        }

        public static <E> RangeBigDecimal<E> newRangeBigDecimal(
                SingularAttribute<E, BigDecimal> field) {
            return new RangeBigDecimal<E>(field);
        }
    }

    public static class RangeDate<E> extends Range<E, Date> {
        private static final long serialVersionUID = 1L;

        public RangeDate(SingularAttribute<E, Date> field) {
            super(field);
        }

        public static <T> RangeDate<T> newRangeDate(SingularAttribute<T, Date> field) {
            return new RangeDate<T>(field);
        }
    }

    public static class RangeLocalDate<E> extends Range<E, LocalDate> {
        private static final long serialVersionUID = 1L;

        public RangeLocalDate(SingularAttribute<E, LocalDate> field) {
            super(field);
        }

        public static <E> RangeLocalDate<E> newRangeLocalDate(SingularAttribute<E, LocalDate> field) {
            return new RangeLocalDate<E>(field);
        }
    }

    public static class RangeLocalDateTime<E> extends Range<E, LocalDateTime> {
        private static final long serialVersionUID = 1L;

        public RangeLocalDateTime(SingularAttribute<E, LocalDateTime> field) {
            super(field);
        }

        public static <E> RangeLocalDateTime<E> newRangeLocalDateTime(
                SingularAttribute<E, LocalDateTime> field) {
            return new RangeLocalDateTime<E>(field);
        }
    }
}