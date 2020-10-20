package com.wfy.java.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/19 15:44
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

import java.util.Arrays;

public class StringExercise {
    public static void main(String[] args) {
        int[] scores = new int[]{89, 50, 90, 99, 83};
        Score s = new Score(scores);
        Score s1 = new Score(scores.clone());  // 实例化时直接拷贝一份数据，后续scores再做修改不会影响s
        s.printScores(); // [89, 50, 90, 99, 83]
        s1.printScores(); // [89, 50, 90, 99, 83]
        scores[1] = 61;
        s.printScores(); // [89, 61, 90, 99, 83] // s[1]被修改了
        s1.printScores(); // [89, 50, 90, 99, 83]
    }
}

class Score {
    private int[] scores;

    public Score(int[] scores) {
        this.scores = scores;
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
