package com.tulotero.games.beans;

import lombok.Value;

import java.util.List;

@Value
public class PrizeInfo {

    double prize;
    List<Integer> numbersAchieved;

}
