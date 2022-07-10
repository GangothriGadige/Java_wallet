package com.tw;

import java.util.Objects;

public class Currency {
    private final double value;
    private final CurrencyType currencyType;


    public Currency(double value, CurrencyType currencyType) {
        this.value = value;
        this.currencyType = currencyType;
    }

    private static class CurrencyType {
        double baseValue;

        public CurrencyType(double baseValue) {
            this.baseValue = baseValue;
        }

        final static CurrencyType rupee = new CurrencyType(74.85);
        final static CurrencyType dollar = new CurrencyType(1);

    }

    public static Currency rupee(double value) {
        return new Currency(value, CurrencyType.rupee);
    }

    public static Currency dollar(double value) {
        return new Currency(value, CurrencyType.dollar);
    }

    public double convertToRupees() {
        return value * (CurrencyType.rupee.baseValue / currencyType.baseValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency that = (Currency) o;
        return this.convertToRupees() == that.convertToRupees();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
