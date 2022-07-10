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

    public double convertToPreferredCurrency( CurrencyType preferredCurrency ) {
        return value * (preferredCurrency.baseValue/currencyType.baseValue);
    }
    public Currency plus(Currency moneyToBeConverted){
        return new Currency(value+moneyToBeConverted.convertToPreferredCurrency(currencyType),currencyType);
    }
    public Currency minus(Currency moneyToBeConverted){
        return new Currency(value-moneyToBeConverted.convertToPreferredCurrency(currencyType),currencyType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency that = (Currency) o;
        return this.convertToPreferredCurrency(CurrencyType.rupee)==that.convertToPreferredCurrency(CurrencyType.rupee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
