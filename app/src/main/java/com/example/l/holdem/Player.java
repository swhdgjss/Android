package com.example.l.holdem;

/**
 * Created by L on 2017-06-06.
 */

import java.util.ArrayList;

public class Player extends Rule{
    public String name;
    public ArrayList<Tuple> card;
    Rule rule = new Rule();

    public Player(String name) {
        this.name = name;
        card = new ArrayList<Tuple>(8);
    }

    public void get() {
        Tuple tmp;

        tmp = this.deal();
        card.add(tmp);
        tmp = this.deal();
        card.add(tmp);
        this.print(this.card);
    }

    public void clear() {
        card.clear();
    }

    public void print(ArrayList<Tuple> card) {
        System.out.print("My card : ");
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

    public void determineHands(String[] hand) {
        if(hand[0] == null) {
            return;
        }
        switch(hand[0]) {
            case "Royal Straight Flush":
                switch(hand[1]) {
                    case "0":
                        System.out.println("Spade" + " " + hand[0]);
                        break;
                    case "1":
                        System.out.println("Daimond" + " " + hand[0]);
                        break;
                    case "2":
                        System.out.println("Heart" + " " + hand[0]);
                        break;
                    case "3":
                        System.out.println("Clover" + " " + hand[0]);
                        break;
                }
                break;
            case "Straight Flush":
                switch(hand[1]) {
                    case "0":
                        System.out.println("Spade" + " " + hand[2] + " " + hand[0]);
                        break;
                    case "1":
                        System.out.println("Daimond" + " " + hand[2] + " " + hand[0]);
                        break;
                    case "2":
                        System.out.println("Heart" + " " + hand[2] + " " + hand[0]);
                        break;
                    case "3":
                        System.out.println("Clover" + " " + hand[2] + " " + hand[0]);
                        break;
                }
                break;
            case "Four Card":
                System.out.println(hand[1] + " " + hand[0]);
                break;
            case "Full House":
                System.out.println(hand[1] + " " + hand[2] + " " + hand[0]);
                break;
            case "Flush":
                switch(hand[1]) {
                    case "0":
                        System.out.println("Spade" + " " + hand[0]);
                        break;
                    case "1":
                        System.out.println("Daimond" + " " + hand[0]);
                        break;
                    case "2":
                        System.out.println("Heart" + " " + hand[0]);
                        break;
                    case "3":
                        System.out.println("Clover" + " " + hand[0]);
                        break;
                }
                break;
            case "Straight":
                System.out.println(hand[1] + " " + hand[0]);
                break;
            case "Triple":
                System.out.println(hand[1] + " " + hand[0]);
                break;
            case "Two Pair":
                System.out.println(hand[1] + " " + hand[2] + " " + hand[0]);
                break;
            case "One Pair":
                System.out.println(hand[1] + " " + hand[0]);
                break;
            default:
                System.out.println("No Pair");
        }
    }
}