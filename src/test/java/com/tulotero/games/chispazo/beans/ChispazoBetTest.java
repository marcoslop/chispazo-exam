package com.tulotero.games.chispazo.beans;

import org.junit.Test;

import static java.util.Arrays.asList;

public class ChispazoBetTest {

    @Test
    public void testShouldCreateOkIfBetWith5Numbers() throws Exception {
        new ChispazoBet(asList(1,2,3,4,28));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIf4Numbers() throws Exception {
        new ChispazoBet(asList(1,2,3,4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIf6Numbers() throws Exception {
        new ChispazoBet(asList(1,2,3,4,5,6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfNumberIsRepeated() throws Exception {
        new ChispazoBet(asList(1,2,3,4,4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfNumberIsBiggerThan28() throws Exception {
        new ChispazoBet(asList(1,2,3,4,29));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfNumberIsLessThan1() throws Exception {
        new ChispazoBet(asList(0,2,3,4,28));
    }
}