package com.tulotero.games.chispazo;

import com.tulotero.games.beans.ScrutinyPrize;
import com.tulotero.games.chispazo.beans.ChispazoDraw;

import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * NO NEED TO TOUCH ANYTHING IN THIS CLASS
 */
public class ChispazoDrawService {

    public Optional<ChispazoDraw> getDraw(Long drawId){
        //For this example project, we always create a mock Draw
        return Optional.of(new ChispazoDraw(
                drawId,
                asList(5, 10, 15, 20, 25),
                asList(
                    new ScrutinyPrize(5, 1000000D),
                    new ScrutinyPrize(4, 100000D),
                    new ScrutinyPrize(3, 1000D),
                    new ScrutinyPrize(2, 10D),
                    new ScrutinyPrize(1, 1D)
                )
        ));
    }

}
