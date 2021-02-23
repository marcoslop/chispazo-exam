package com.tulotero.games.chispazo.draw;

import com.tulotero.games.common.beans.ScrutinyPrize;
import com.tulotero.games.chispazo.beans.ChispazoDraw;
import org.joda.time.DateTime;

import java.util.List;

import static java.util.Arrays.asList;

public class ChispazoDrawStore {

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
            ChispazoDraw.opened(5L, new DateTime().plusDays(3).toDate())
    );

    public List<ChispazoDraw> getDraws() {
        return DRAWS;
    }

}
