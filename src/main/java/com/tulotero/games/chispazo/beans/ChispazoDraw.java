package com.tulotero.games.chispazo.beans;


import com.tulotero.games.beans.ScrutinyPrize;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class ChispazoDraw {

    long drawId;
    Date date;
    List<Integer> winningNumbers;
    List<ScrutinyPrize> prizes;

}
