package com.tulotero.games.chispazo.prizes;

import com.tulotero.games.chispazo.ChispazoDrawStore;

import javax.inject.Inject;

public class ChispazoPrizeService {

    @Inject
    ChispazoDrawStore store;

    @Inject
    ChispazoPrizeCalculator prizeCalculator;

    public PrizeCalculationDrawInfo calculatePrizesForDraw(Long drawId) {
        //TODO: get Draw from store and check if it is in a correct state so that prizes can be launched.

        //TODO: get bets from our Bet Store assigned to this draw.

        //TODO: For each bet .....
        // Create a ChispazoPrizeCheck
        // Invoke to prizeCalculator and get prize
        // Update prize in store
        // Obtain user assigned to this bet and send him a push notification with the result

        //TODO: Collect all prizes and create a PrizeCalculationDrawInfo to be returned.
        return null;
    }
}
