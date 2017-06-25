package com.example.l.holdem;

/**
 * Created by L on 2017-06-02.
 */

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Rule{
    public ArrayList<Tuple> board = new ArrayList<Tuple>(6);
    public Random random = new Random();
    public Deck deck;
    public int gameMoney = 0;

    public Rule(Deck deck) {
        this.deck = deck;
    }

    public Tuple deal(Deck deck) {
        boolean check;
        int x, y;

        do {
            x = random.nextInt(4);
            y = random.nextInt(13) + 2;
            check = deck.determine(x, y);
        } while(check == false);
        deck.use(x, y);
        Tuple t = new Tuple(x, y);

        return t;
    }

    public void flop() {
        Tuple tmp;

        for(int i = 0; i < 3; i++) {
            tmp = this.deal(this.deck);
            board.add(tmp);
        }
    }

    public void turn() {
        Tuple tmp;

        tmp = this.deal(this.deck);
        board.add(tmp);
    }

    public void river() {
        Tuple tmp;

        tmp = this.deal(this.deck);
        board.add(tmp);
    }

    public void doBet(int tmp) {
        gameMoney += tmp;
    }

    public void clear() {
        board.clear();
        deck.clear();
        gameMoney = 0;
    }

    public String[] hands(ArrayList<Tuple> card) {
        String[][] hand = new String[10][3];

        hand[0] = isRoyalStraightFlush(card);
        hand[1] = isStraighFlush(card);
        hand[2] = isFourCard(card);
        hand[3] = isFullHouse(card);
        hand[4] = isFlush(card);
        hand[5] = isStraight(card);
        hand[6] = isTriple(card);
        hand[7] = isTwoPair(card);
        hand[8] = isOnePair(card);
        hand[9] = isTop(card);

        for(String[] tmp : hand) {
            if(tmp[0] != null) return tmp;
        }
        return hand[9];
    }

    public String[] isRoyalStraightFlush(ArrayList<Tuple> card) {
        int[][] c = new int[4][15];
        int x, y;
        String[] result = new String[2];

        for(Tuple tmp : card) {
            x = tmp.getX();
            y = tmp.getY();
            c[x][y]++;
        }

        for(int i = 0; i < 4; i++) {
            if(c[i][10] == 1 && c[i][11] == 1 && c[i][12] == 1 && c[i][13] == 1 && c[i][14] == 1) {
                result[0] = "Royal Straight Flush";
                result[1] = Integer.toString(i);
            }
        }
        return result;
    }

    public String[] isStraighFlush(ArrayList<Tuple> card) {
        int[][] c = new int[4][15];
        int x, y;
        String[] result = new String[3];

        for(Tuple tmp : card) {
            x = tmp.getX();
            y = tmp.getY();
            c[x][y]++;
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 10; j++) {
                if(c[i][j] == 1 && c[i][j + 1] == 1 && c[i][j + 2] == 1 && c[i][j + 3] == 1 && c[i][j + 4] == 1) {
                    result[0] = "Straight Flush";
                    result[1] = Integer.toString(i);
                    result[2] = Integer.toString(j + 4);
                } else if(c[i][2] == 1 && c[i][3] == 1 && c[i][4] == 1 && c[i][5] == 1 && c[i][14] == 1) {
                    result[0] = "Straight Flush";
                    result[1] = Integer.toString(i);
                    result[2] = Integer.toString(5);
                }
            }
        }
        return result;
    }

    public String[] isFourCard(ArrayList<Tuple> card) {
        int[] c = new int[15];
        int y;
        String[] result = new String[2];

        for(Tuple tmp : card) {
            y = tmp.getY();
            c[y]++;
        }

        for(int i = 1; i <= 14; i++) {
            if(c[i] == 4) {
                result[0] = "Four Card";
                result[1] = Integer.toString(i);
            }
        }
        return result;
    }

    public String[] isFullHouse(ArrayList<Tuple> card) {
        int[] c = new int[15];
        int y;
        String[] result = new String[3];

        for(Tuple tmp : card) {
            y = tmp.getY();
            c[y]++;
        }

        for(int i = 1; i <= 14; i++) {
            for(int j = 1; j <= 14; j++) {
                if(c[i] == 3 && c[j] == 2) {
                    result[0] = "Full House";
                    result[1] = Integer.toString(i);
                    result[2] = Integer.toString(j);
                }
            }
        }
        return result;
    }

    public String[] isFlush(ArrayList<Tuple> card) {
        int[] c = new int[4];
        int x;
        String[] result = new String[2];

        for(Tuple tmp : card) {
            x = tmp.getX();
            c[x]++;
        }

        for(int i = 0; i < 4; i++) {
            if(c[i] >= 5) {
                result[0] = "Flush";
                result[1] = Integer.toString(i);
            }
        }
        return result;
    }

    public String[] isStraight(ArrayList<Tuple> card) {
        int[] c = new int[15];
        int y;
        String[] result = new String[2];

        for(Tuple tmp : card) {
            y = tmp.getY();
            c[y]++;
        }

        for(int i = 1; i <= 10; i++) {
            if(c[i] == 1 && c[i + 1] == 1 && c[i + 2] == 1 && c[i + 3] == 1 && c[i + 4] == 1) {
                result[0] = "Straight";
                result[1] = Integer.toString(i + 4);
            } else if(c[2] == 1 && c[3] == 1 && c[4] == 1 && c[5] == 1 && c[14] == 1) {
                result[0] = "Straight";
                result[1] = Integer.toString(5);
            }
        }
        return result;
    }

    public String[] isTriple(ArrayList<Tuple> card) {
        int[] c = new int[15];
        int y;
        String[] result = new String[2];

        for(Tuple tmp : card) {
            y = tmp.getY();
            c[y]++;
        }

        for(int i = 1; i <= 14; i++) {
            if(c[i] == 3) {
                result[0] = "Triple";
                result[1] = Integer.toString(i);
            }
        }
        return result;
    }

    public String[] isTwoPair(ArrayList<Tuple> card) {
        int[] c = new int[15];
        int y;
        String[] result = new String[3];

        for(Tuple tmp : card) {
            y = tmp.getY();
            c[y]++;
        }

        for(int i = 1; i <= 14; i++) {
            for(int j = 1; j <= 14; j++) {
                if(c[i] == 2 && c[j] == 2 && i != j) {
                    result[0] = "Two Pair";
                    result[1] = Integer.toString(i);
                    result[2] = Integer.toString(j);
                }
            }
        }
        return result;
    }

    public String[] isOnePair(ArrayList<Tuple> card) {
        int[] c = new int[15];
        int y;
        String[] result = new String[2];

        for(Tuple tmp : card) {
            y = tmp.getY();
            c[y]++;
        }

        for(int i = 1; i <= 14; i++) {
            if(c[i] == 2) {
                result[0] = "One Pair";
                result[1] = Integer.toString(i);
            }
        }
        return result;
    }

    public String[] isTop(ArrayList<Tuple> card) {
        int[] c = new int[15];
        int y, count = 0;
        String[] result = new String[3];

        for(Tuple tmp : card) {
            y = tmp.getY();
            c[y]++;
        }

        for(int i = 14; i > 1; i--) {
            if(c[i] > 0) {
                result[count] = Integer.toString(i);
                count++;
            }
            if(count == 3) break;
        }
        return result;
    }
}