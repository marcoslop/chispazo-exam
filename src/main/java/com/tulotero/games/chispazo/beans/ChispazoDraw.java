package com.tulotero.games.chispazo.beans;


import com.tulotero.games.beans.ScrutinyPrize;
import lombok.Value;

import java.util.List;

@Value
public class ChispazoDraw {

    long drawId;
    List<Integer> winningNumbers;
    List<ScrutinyPrize> prizes;

}
