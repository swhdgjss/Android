package com.example.l.holdem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Play4 extends AppCompatActivity {

    ImageView card1, card2, card3, card4, card5, card6, card7, card8,
            board1, board2, board3, board4, board5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play4);

        Intent intent = new Intent();
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
        Rule rule = new Rule();
        Player[] player = new Player[4];
        String[] hand = new String[4];

        String name = (String) intent.getSerializableExtra("name");
        player[0] = new Player(name);
        player[1] = new Player("computer1");
        player[2] = new Player("computer2");
        player[3] = new Player("computer3");

        for(Player tmp: player) {
            tmp.draw();
        }
        open(player[0].card.get(0));
        open(player[0].card.get(1));

    }

    public void open(Tuple card) {
        switch (card.getX()) {
            case 0:
                switch (card.getY()) {
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                }
                break;
            case 1:
                switch (card.getY()) {
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                }
                break;
            case 2:
                switch (card.getY()) {
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                }
                break;
            case 3:
                switch (card.getY()) {
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                }
                break;
        }
    }
}
