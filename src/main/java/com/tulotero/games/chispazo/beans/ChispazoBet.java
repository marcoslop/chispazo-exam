package com.tulotero.games.chispazo.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ChispazoBet {

    List<Integer> numbers;

    public ChispazoBet(List<Integer> numbers){
        setNumbers(numbers);
    }

    public void setNumbers(List<Integer> numbers){
        //TODO: Validate numbers according ChispazoBetTest
        this.numbers = numbers;
    }

}
