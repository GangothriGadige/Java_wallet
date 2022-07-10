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
    @Test
    void shouldReturnResultantMoneyWhenFiveRupeesIsAddedToFiveDollars(){
        Currency currentMoney=rupee(5);
        Currency addedMoney=dollar(5);
        Currency totalMoney=rupee(379.25);

        assertThat(currentMoney.plus(addedMoney), is(equalTo(totalMoney)));
    }
    @Test
    void shouldReturnOneHundredTwentyFourEightyFivePaisaWhenFiftyRupeesAndOneDollarAreAdded(){
        Currency fiftyRupees=rupee(50);
        Currency OneDollar=dollar(1);
        Currency emptyWallet=rupee(0);
        Currency OneHundredTwentyFourEightyFivePaisa=rupee(124.85);

        assertThat(fiftyRupees.plus(OneDollar.plus(emptyWallet)), is(equalTo(OneHundredTwentyFourEightyFivePaisa)));

    }

}
