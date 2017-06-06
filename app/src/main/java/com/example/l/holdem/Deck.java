package com.example.l.holdem;

/**
 * Created by L on 2017-06-06.
 */

import java.util.Arrays;

public class Deck {
    public int[][] deck = new int[4][15]; //0 : Spade 1 : Diamond 2 : Heart 3 : Clover

    public boolean determine(int x, int y) {
        if(deck[x][y] == 1) {
            return false;
        } else {
            return true;
        }
    }

    public void use(int x, int y) {
        deck[x][y]++;
    }

    public void clear() {
        Arrays.fill(deck, 0);
    }
}