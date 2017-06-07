package com.example.l.holdem;

/**
 * Created by L on 2017-06-07.
 */

public class Num {
    private String[] num = new String[15];

    public Num() {
        num[0] = "0";
        num[1] = "0";
        num[2] = "2";
        num[3] = "3";
        num[4] = "4";
        num[5] = "5";
        num[6] = "6";
        num[7] = "7";
        num[8] = "8";
        num[9] = "9";
        num[10] = "10";
        num[11] = "J";
        num[12] = "Q";
        num[13] = "K";
        num[14] = "A";
    }

    public String getNum(String num) {
        int tmp = Integer.parseInt(num);

        return this.num[tmp];
    }
}
