package com.tw;

import org.junit.jupiter.api.Test;

import static com.tw.Currency.dollar;
import static com.tw.Currency.rupee;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class CurrencyTest {
    @Test
    void shouldCheckEqualityWhenSeventyFourRupeesEightyFivePaisaAreComparedWithOneDollar() {
        Currency seventyFourRupeesEightyFivePaisa = rupee(74.85);
        Currency oneDollar = dollar(1);

        assertThat(seventyFourRupeesEightyFivePaisa, is(equalTo(oneDollar)));
    }

}
