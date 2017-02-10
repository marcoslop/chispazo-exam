package com.tulotero.games.chispazo;

import com.tulotero.games.beans.ScrutinyPrize;
import com.tulotero.games.chispazo.beans.ChispazoDraw;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class ChispazoDrawService {

    /**
     * Mocked draws for this exercise
     */
    private static final List<ChispazoDraw> DRAWS = asList(
            ChispazoDraw.finished(
                    1L,
                    new DateTime().minusDays(2).toDate(),
                    asList(5, 10, 15, 20, 25),
                    asList(
                            new ScrutinyPrize(5, 1000000D),
                            new ScrutinyPrize(4, 100000D),
                            new ScrutinyPrize(3, 1000D),
                            new ScrutinyPrize(2, 10D),
                            new ScrutinyPrize(1, 1D)
                    )
            ),
            ChispazoDraw.finished(
                    2L,
                    new DateTime().minusDays(1).toDate(),
                    asList(5, 10, 15, 20, 25),
                    asList(
                            new ScrutinyPrize(5, 1000000D),
                            new ScrutinyPrize(4, 100000D),
                            new ScrutinyPrize(3, 1000D),
                            new ScrutinyPrize(2, 10D),
                            new ScrutinyPrize(1, 1D)
                    )
            ),
            ChispazoDraw.opened(3L, new DateTime().plusDays(1).toDate()),
            ChispazoDraw.opened(4L, new DateTime().plusDays(2).toDate()),
            ChispazoDraw.opened(5L, new DateTime().plusDays(2).toDate())
    );


    public Optional<ChispazoDraw> getDraw(long drawId){
        //For this example project, we always create a mock Draw
        return DRAWS.stream()
                .filter(draw -> draw.getDrawId() == drawId)
                .findAny();
    }

}
