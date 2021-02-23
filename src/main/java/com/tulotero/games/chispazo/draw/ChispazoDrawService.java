package com.tulotero.games.chispazo.draw;

import com.tulotero.games.chispazo.beans.ChispazoDraw;

import javax.inject.Inject;
import java.util.Optional;

public class ChispazoDrawService {

    @Inject
    ChispazoDrawStore store;

    public Optional<ChispazoDraw> getDraw(long drawId){
        return store.getDraws().stream()
                .filter(draw -> draw.getDrawId() == drawId)
                .findAny();
    }

}
