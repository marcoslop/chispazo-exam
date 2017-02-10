package com.tulotero.games.chispazo;

import com.tulotero.games.beans.PrizeInfo;
import com.tulotero.games.beans.ScrutinyPrize;
import com.tulotero.games.chispazo.beans.ChispazoBet;
import com.tulotero.games.chispazo.beans.ChispazoDraw;
import com.tulotero.games.chispazo.beans.ChispazoPrizeCheck;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChispazoPrizeCalculatorTest {

    ChispazoPrizeCalculator prizeCalculator;

    @Before
    public void setUp() throws Exception {
        prizeCalculator = new ChispazoPrizeCalculator();
    }

    @Test
    public void testShouldReturn0IfNoNumberIsAchieved() throws Exception {
        ChispazoDraw drawResult = givenDrawResult();
        ChispazoBet bet = new ChispazoBet(asList(6,7,8,9,10));

        PrizeInfo prizeInfo = prizeCalculator.calculatePrize(new ChispazoPrizeCheck(bet, drawResult));

        assertThat(prizeInfo.getNumbersAchieved(), is(Collections.emptyList()));
        assertThat(prizeInfo.getPrize(), is(0D));
    }

    @Test
    public void testShouldReturn1If1NumberIsAchieved() throws Exception {
        ChispazoDraw drawResult = givenDrawResult();
        ChispazoBet bet = new ChispazoBet(asList(1,7,8,9,10));

        PrizeInfo prizeInfo = prizeCalculator.calculatePrize(new ChispazoPrizeCheck(bet, drawResult));

        assertThat(prizeInfo.getNumbersAchieved(), is(asList(1)));
        assertThat(prizeInfo.getPrize(), is(1D));
    }

    @Test
    public void testShouldReturn2If2NumberIsAchieved() throws Exception {
        ChispazoDraw drawResult = givenDrawResult();
        ChispazoBet bet = new ChispazoBet(asList(1,2,8,9,10));

        PrizeInfo prizeInfo = prizeCalculator.calculatePrize(new ChispazoPrizeCheck(bet, drawResult));

        assertThat(prizeInfo.getNumbersAchieved(), is(asList(1,2)));
        assertThat(prizeInfo.getPrize(), is(10D));
    }

    @Test
    public void testShouldReturn3If3NumberIsAchieved() throws Exception {
        ChispazoDraw drawResult = givenDrawResult();
        ChispazoBet bet = new ChispazoBet(asList(1,2,3,9,10));

        PrizeInfo prizeInfo = prizeCalculator.calculatePrize(new ChispazoPrizeCheck(bet, drawResult));

        assertThat(prizeInfo.getNumbersAchieved(), is(asList(1,2,3)));
        assertThat(prizeInfo.getPrize(), is(1000D));
    }

    @Test
    public void testShouldReturn4If4NumberIsAchieved() throws Exception {
        ChispazoDraw drawResult = givenDrawResult();
        ChispazoBet bet = new ChispazoBet(asList(1,2,3,4,10));

        PrizeInfo prizeInfo = prizeCalculator.calculatePrize(new ChispazoPrizeCheck(bet, drawResult));

        assertThat(prizeInfo.getNumbersAchieved(), is(asList(1,2,3,4)));
        assertThat(prizeInfo.getPrize(), is(100000D));
    }

    @Test
    public void testShouldReturn5If5NumberIsAchieved() throws Exception {
        ChispazoDraw drawResult = givenDrawResult();
        ChispazoBet bet = new ChispazoBet(asList(1,2,3,4,5));

        PrizeInfo prizeInfo = prizeCalculator.calculatePrize(new ChispazoPrizeCheck(bet, drawResult));

        assertThat(prizeInfo.getNumbersAchieved(), is(asList(1,2,3,4,5)));
        assertThat(prizeInfo.getPrize(), is(1000000D));
    }

    private ChispazoDraw givenDrawResult(){
        return ChispazoDraw.finished(
                1L,
                new DateTime().minusDays(1).toDate(),
                asList(1, 2, 3, 4, 5),
                asList(
                        new ScrutinyPrize(5, 1000000D),
                        new ScrutinyPrize(4, 100000D),
                        new ScrutinyPrize(3, 1000D),
                        new ScrutinyPrize(2, 10D),
                        new ScrutinyPrize(1, 1D)
                )
        );
    }

}