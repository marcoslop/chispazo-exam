package com.tulotero.games.chispazo;

import com.tulotero.games.beans.ScrutinyPrize;
import com.tulotero.games.chispazo.beans.ChispazoDraw;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class ChispazoDrawService {

    private static final List<ChispazoDraw> FIXED_DRAWS = asList(
            new ChispazoDraw(
                    1L,
                    asList(5, 10, 15, 20, 25),
                    asList(
                            new ScrutinyPrize(5, 1000000D),
                            new ScrutinyPrize(4, 100000D),
                            new ScrutinyPrize(3, 1000D),
                            new ScrutinyPrize(2, 10D),
                            new ScrutinyPrize(1, 1D)
                    )
            ),
            new ChispazoDraw(
                    2L,
                    asList(5, 10, 15, 20, 25),
                    asList(
                            new ScrutinyPrize(5, 1000000D),
                            new ScrutinyPrize(4, 100000D),
                            new ScrutinyPrize(3, 1000D),
                            new ScrutinyPrize(2, 10D),
                            new ScrutinyPrize(1, 1D)
                    )
            )
    );


    public Optional<ChispazoDraw> getDraw(long drawId){
        //For this example project, we always create a mock Draw
        return FIXED_DRAWS.stream()
                .filter(draw -> draw.getDrawId() == drawId)
                .findAny();
    }

}
