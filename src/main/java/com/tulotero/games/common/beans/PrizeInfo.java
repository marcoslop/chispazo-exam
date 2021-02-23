package com.tulotero.games.common.beans;

import lombok.Value;

import java.util.List;

@Value
public class PrizeInfo {

    double prize;
    List<Integer> numbersAchieved;

}
