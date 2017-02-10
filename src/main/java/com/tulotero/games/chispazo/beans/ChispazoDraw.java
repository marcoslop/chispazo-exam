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

    private ChispazoDraw(
            Long drawId,
            Date date,
            List<Integer> winningNumbers,
            List<ScrutinyPrize> prizes
    ){
        this.drawId = drawId;
        this.date = date;
        this.winningNumbers = winningNumbers;
        this.prizes = prizes;
    }

    public static ChispazoDraw finished(
            Long drawId,
            Date date,
            List<Integer> winningNumbers,
            List<ScrutinyPrize> prizes
    ){
        return new ChispazoDraw(drawId, date, winningNumbers, prizes);
    }

    public static ChispazoDraw opened(
            Long drawId,
            Date date
    ){
        return new ChispazoDraw(drawId, date, null, null);
    }

    public boolean isFinished(){
        return winningNumbers!=null;
    }

    public boolean isOpened(){
        return date.after(new Date());
    }

}
