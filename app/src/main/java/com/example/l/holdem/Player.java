package com.example.l.holdem;

/**
 * Created by L on 2017-06-06.
 */

import java.util.ArrayList;

public class Player extends Rule{
    public String name;
    public ArrayList<Tuple> card;
    private int money = 1000000;
    public double score;
    public Deck deck;
    Num num = new Num();

    public Player(String name, Deck deck) {
        super(deck);
        this.name = name;
        card = new ArrayList<Tuple>(8);
        this.deck = deck;
    }

    public void draw() {
        Tuple tmp;

        tmp = this.deal(this.deck);
        card.add(tmp);
        tmp = this.deal(this.deck);
        card.add(tmp);
        this.print(this.card);
    }

    public int bet(int tmp) {
        if(tmp > money) {
            int temp = money;
            this.money -= money;
            return temp;
        } else {
            this.money -= tmp;
            return tmp;
        }
    }

    public void clear() {
        card.clear();
    }

    public void print(ArrayList<Tuple> card) {
        System.out.print(this.name + ": ");
        for(Tuple tmp : card) {
            System.out.print(tmp.getX() + ", " + tmp.getY() + " | ");
        }
        System.out.println();
    }

    public void sum(ArrayList<Tuple> card, ArrayList<Tuple> board) {
        for(Tuple tmp : board) {
            card.add(tmp);
        }

        this.print(this.card);
    }

    public double determineHands(String[] hand) {
        if(hand[0] == null) {
            return 0;
        }
        switch(hand[0]) {
            case "Royal Straight Flush":
                switch(hand[1]) {
                    case "0":
                        System.out.println("Spade" + " " + hand[0]);
                        score = 940;
                        return score;
                    case "1":
                        System.out.println("Daimond" + " " + hand[0]);
                        score = 930;
                        return score;
                    case "2":
                        System.out.println("Heart" + " " + hand[0]);
                        score = 920;
                        return score;
                    case "3":
                        System.out.println("Clover" + " " + hand[0]);
                        score = 910;
                        return score;
                }
                break;
            case "Straight Flush":
                switch(hand[1]) {
                    case "0":
                        System.out.println("Spade" + " " + num.getNum(hand[2]) + " " + hand[0]);
                        score = 840 + Integer.valueOf(hand[2]);
                        return score;
                    case "1":
                        System.out.println("Daimond" + " " + num.getNum(hand[2]) + " " + hand[0]);
                        score = 830 + Integer.valueOf(hand[2]);
                        return score;
                    case "2":
                        System.out.println("Heart" + " " + num.getNum(hand[2]) + " " + hand[0]);
                        score = 820 + Integer.valueOf(hand[2]);
                        return score;
                    case "3":
                        System.out.println("Clover" + " " + num.getNum(hand[2]) + " " + hand[0]);
                        score = 810 + Integer.valueOf(hand[2]);
                        return score;
                }
                break;
            case "Four Card":
                System.out.println(num.getNum(hand[1]) + " " + hand[0]);
                score = 700 + Integer.valueOf(hand[1]);
                return score;
            case "Full House":
                System.out.println(num.getNum(hand[1]) + " " + num.getNum(hand[2]) + " " + hand[0]);
                score = 600 + Integer.valueOf(hand[1]) + (0.1 * Integer.valueOf(hand[2]));
                return score;
            case "Flush":
                switch(hand[1]) {
                    case "0":
                        System.out.println("Spade" + " " + hand[0]);
                        score = 530;
                        return score;
                    case "1":
                        System.out.println("Daimond" + " " + hand[0]);
                        score = 520;
                        return score;
                    case "2":
                        System.out.println("Heart" + " " + hand[0]);
                        score = 510;
                        return score;
                    case "3":
                        System.out.println("Clover" + " " + hand[0]);
                        score = 500;
                        return score;
                }
                break;
            case "Straight":
                System.out.println(num.getNum(hand[1]) + " " + hand[0]);
                score = 400 + Integer.valueOf(hand[1]);
                return score;
            case "Triple":
                System.out.println(num.getNum(hand[1]) + " " + hand[0]);
                score = 300 + Integer.valueOf(hand[1]);
                return score;
            case "Two Pair":
                System.out.println(num.getNum(hand[1]) + " " + num.getNum(hand[2]) + " " + hand[0]);
                score = 200 + Integer.valueOf(hand[1]) + Integer.valueOf(hand[2]);
                return score;
            case "One Pair":
                System.out.println(num.getNum(hand[1]) + " " + hand[0]);
                score = 100 + Integer.valueOf(hand[1]);
                return score;
            default:
                System.out.println(num.getNum(hand[0]) + " " + num.getNum(hand[1]) + " " + num.getNum(hand[2]));
                score = Integer.valueOf(hand[0]) + (0.01 * Integer.valueOf(hand[1])) + (0.001 * Integer.valueOf(hand[2]));
                System.out.println("No Pair");
                return score;
        }
        return 0;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int tmp) {
        this.money = tmp;
    }
}