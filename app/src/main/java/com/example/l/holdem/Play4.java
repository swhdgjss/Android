package com.example.l.holdem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Play4 extends AppCompatActivity {

    ImageView card1, card2, card3, card4, card5, card6, card7, card8,
            board1, board2, board3, board4, board5;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play4);

        Intent intent = getIntent();
        textView = (TextView) findViewById(R.id.textView4);
        card1 = (ImageView) findViewById(R.id.card1);
        card2 = (ImageView) findViewById(R.id.card2);
        card3 = (ImageView) findViewById(R.id.card3);
        card4 = (ImageView) findViewById(R.id.card4);
        card5 = (ImageView) findViewById(R.id.card5);
        card6 = (ImageView) findViewById(R.id.card6);
        card7 = (ImageView) findViewById(R.id.card7);
        card8 = (ImageView) findViewById(R.id.card8);
        board1 = (ImageView)findViewById(R.id.board1);
        board2 = (ImageView)findViewById(R.id.board2);
        board3 = (ImageView)findViewById(R.id.board3);
        board4 = (ImageView)findViewById(R.id.board4);
        board5 = (ImageView)findViewById(R.id.board5);
        Deck deck = new Deck();
        Rule rule = new Rule(deck);
        Player[] player = new Player[4];
        String[] hand = new String[4];

        String name = intent.getStringExtra("name");
        player[0] = new Player(name, deck);
        player[1] = new Player("computer1", deck);
        player[2] = new Player("computer2", deck);
        player[3] = new Player("computer3", deck);

        textView.setText(player[0].name);
        for(Player tmp: player) {
            tmp.draw();
        }

        open(player[0].card.get(0), card1);
        open(player[0].card.get(1), card2);

        rule.flopOpen();
        open(rule.board.get(0), board1);
        open(rule.board.get(1), board2);
        open(rule.board.get(2), board3);
        rule.turnOpen();
        open(rule.board.get(3), board4);
        rule.riverOpen();
        open(rule.board.get(4), board5);

        for(Player tmp: player) {
            tmp.sum(tmp.card, rule.board);
            double ss = tmp.determineHands(tmp.hands(tmp.card));
            System.out.println(ss);
        }

        for(Player tmp: player) {
            tmp.clear();
        }
        rule.clear();
    }

    public void open(Tuple card, ImageView imageView) {
        switch (card.getX()) {
            case 0:
                switch (card.getY()) {
                    case 2:
                        imageView.setImageResource(R.drawable.spade2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.spade3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.spade4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.spade5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.spade6);
                        break;
                    case 7:
                        imageView.setImageResource(R.drawable.spade7);
                        break;
                    case 8:
                        imageView.setImageResource(R.drawable.spade8);
                        break;
                    case 9:
                        imageView.setImageResource(R.drawable.spade9);
                        break;
                    case 10:
                        imageView.setImageResource(R.drawable.spade10);
                        break;
                    case 11:
                        imageView.setImageResource(R.drawable.spadej);
                        break;
                    case 12:
                        imageView.setImageResource(R.drawable.spadeq);
                        break;
                    case 13:
                        imageView.setImageResource(R.drawable.spadek);
                        break;
                    case 14:
                        imageView.setImageResource(R.drawable.spadea);
                        break;
                }
                break;
            case 1:
                switch (card.getY()) {
                    case 2:
                        imageView.setImageResource(R.drawable.diamond2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.diamond3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.diamond4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.diamond5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.diamond6);
                        break;
                    case 7:
                        imageView.setImageResource(R.drawable.diamond7);
                        break;
                    case 8:
                        imageView.setImageResource(R.drawable.diamond8);
                        break;
                    case 9:
                        imageView.setImageResource(R.drawable.diamond9);
                        break;
                    case 10:
                        imageView.setImageResource(R.drawable.diamond10);
                        break;
                    case 11:
                        imageView.setImageResource(R.drawable.diamondj);
                        break;
                    case 12:
                        imageView.setImageResource(R.drawable.diamondq);
                        break;
                    case 13:
                        imageView.setImageResource(R.drawable.diamondk);
                        break;
                    case 14:
                        imageView.setImageResource(R.drawable.diamonda);
                        break;
                }
                break;
            case 2:
                switch (card.getY()) {
                    case 2:
                        imageView.setImageResource(R.drawable.heart2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.heart3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.heart4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.heart5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.heart6);
                        break;
                    case 7:
                        imageView.setImageResource(R.drawable.heart7);
                        break;
                    case 8:
                        imageView.setImageResource(R.drawable.heart8);
                        break;
                    case 9:
                        imageView.setImageResource(R.drawable.heart9);
                        break;
                    case 10:
                        imageView.setImageResource(R.drawable.heart10);
                        break;
                    case 11:
                        imageView.setImageResource(R.drawable.heartj);
                        break;
                    case 12:
                        imageView.setImageResource(R.drawable.heartq);
                        break;
                    case 13:
                        imageView.setImageResource(R.drawable.heartk);
                        break;
                    case 14:
                        imageView.setImageResource(R.drawable.hearta);
                        break;
                }
                break;
            case 3:
                switch (card.getY()) {
                    case 2:
                        imageView.setImageResource(R.drawable.clover2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.clover3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.clover4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.clover5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.clover6);
                        break;
                    case 7:
                        imageView.setImageResource(R.drawable.clover7);
                        break;
                    case 8:
                        imageView.setImageResource(R.drawable.clover8);
                        break;
                    case 9:
                        imageView.setImageResource(R.drawable.clover9);
                        break;
                    case 10:
                        imageView.setImageResource(R.drawable.clover10);
                        break;
                    case 11:
                        imageView.setImageResource(R.drawable.cloverj);
                        break;
                    case 12:
                        imageView.setImageResource(R.drawable.cloverq);
                        break;
                    case 13:
                        imageView.setImageResource(R.drawable.cloverk);
                        break;
                    case 14:
                        imageView.setImageResource(R.drawable.clovera);
                        break;
                }
                break;
        }
    }
}
