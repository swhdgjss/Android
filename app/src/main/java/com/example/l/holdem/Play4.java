package com.example.l.holdem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.*;

public class Play4 extends AppCompatActivity {

    ImageView card1, card2, card3, card4, card5, card6, card7, card8,
            board1, board2, board3, board4, board5;
    TextView state, money, money1, money2, money3;
    EditText editText;
    Button replay, bet;
    AlertDialog.Builder dialog;
    Deck deck;
    Rule rule;
    Player[] player;
    double[] score;
    String[] hand;
    int flag = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play4);

        Intent intent = getIntent();
        dialog = new AlertDialog.Builder(Play4.this);
        state = (TextView) findViewById(R.id.textView4);
        money = (TextView) findViewById(R.id.textView5);
        money1 = (TextView) findViewById(R.id.money1);
        money2 = (TextView) findViewById(R.id.money2);
        money3 = (TextView) findViewById(R.id.money3);
        editText = (EditText) findViewById(R.id.editText2);
        card1 = (ImageView) findViewById(R.id.card1);
        card2 = (ImageView) findViewById(R.id.card2);
        card3 = (ImageView) findViewById(R.id.card3);
        card4 = (ImageView) findViewById(R.id.card4);
        card5 = (ImageView) findViewById(R.id.card5);
        card6 = (ImageView) findViewById(R.id.card6);
        card7 = (ImageView) findViewById(R.id.card7);
        card8 = (ImageView) findViewById(R.id.card8);
        board1 = (ImageView) findViewById(R.id.board1);
        board2 = (ImageView) findViewById(R.id.board2);
        board3 = (ImageView) findViewById(R.id.board3);
        board4 = (ImageView) findViewById(R.id.board4);
        board5 = (ImageView) findViewById(R.id.board5);
        replay = (Button) findViewById(R.id.button2);
        bet = (Button) findViewById(R.id.bet);
        deck = new Deck();
        rule = new Rule(deck);
        player = new Player[4];
        score = new double[4];
        hand = new String[4];

        String name = intent.getStringExtra("state");
        player[0] = new Player(name, deck);
        player[1] = new Player("computer1", deck);
        player[2] = new Player("computer2", deck);
        player[3] = new Player("computer3", deck);

        game();

        bet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(flag) {
                    case 0:
                        firstTurn();
                        break;
                    case 1:
                        secondTurn();
                        break;
                    case 2:
                        thirdTurn();
                        break;
                    case 3:
                        fourthTurn();
                        lastTurn();
                        showDown();
                        break;
                }
            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setTitle("다시하기");
                dialog.setMessage("다시 하시겠습니까?");
                dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        replay();
                    }
                });
                dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
    }

    public void game() {
        state.setText(player[0].name + ", 현재 돈 :" + player[0].money);
        money1.setText("현재 돈 :" + player[1].money);
        money2.setText("현재 돈 :" + player[2].money);
        money3.setText("현재 돈 :" + player[3].money);
        money.setText("판돈 :" + rule.gameMoney);

        for(Player tmp: player) {
            tmp.draw();
        }

        open(player[0].card.get(0), card1);
        open(player[0].card.get(1), card2);
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

    public void firstTurn() {
        betting();

        rule.flopOpen();
        open(rule.board.get(0), board1);
        open(rule.board.get(1), board2);
        open(rule.board.get(2), board3);
        flag++;
    }

    public void secondTurn() {
        betting();

        rule.turnOpen();
        open(rule.board.get(3), board4);
        flag++;
    }

    public void thirdTurn() {
        betting();

        rule.riverOpen();
        open(rule.board.get(4), board5);
        flag++;
    }

    public void fourthTurn() {
        betting();
        flag++;
    }

    public void lastTurn() {
        for(int i = 0; i < 4; i++) {
            player[i].sum(player[i].card, rule.board);
            score[i] = player[i].determineHands(player[i].hands(player[i].card));
        }
        double win = max(max(score[0], score[1]), max(score[2], score[3]));

        for(Player tmp: player) {
            if(tmp.score == win) {
                Toast.makeText(this, tmp.name + "'s win!!", Toast.LENGTH_SHORT).show();
                tmp.money += rule.gameMoney;
                break;
            }
        }

        state.setText(player[0].name + ", 현재 돈 :" + player[0].money);
        money1.setText("현재 돈 :" + player[1].money);
        money2.setText("현재 돈 :" + player[2].money);
        money3.setText("현재 돈 :" + player[3].money);
        money.setText("판돈 :" + rule.gameMoney);
    }

    public void replay() {
        for(Player tmp: player) {
            tmp.clear();
        }
        rule.clear();
        flag = 0;

        board1.setImageResource(R.drawable.back);
        board2.setImageResource(R.drawable.back);
        board3.setImageResource(R.drawable.back);
        board4.setImageResource(R.drawable.back);
        board5.setImageResource(R.drawable.back);

        card1.setImageResource(R.drawable.back);
        card2.setImageResource(R.drawable.back);
        card3.setImageResource(R.drawable.back);
        card4.setImageResource(R.drawable.back);
        card5.setImageResource(R.drawable.back);
        card6.setImageResource(R.drawable.back);
        card7.setImageResource(R.drawable.back);
        card8.setImageResource(R.drawable.back);
        money.setText("판돈 :" + rule.gameMoney);

        game();
    }

    public void showDown() {
        open(player[1].card.get(0), card3);
        open(player[1].card.get(1), card4);
        open(player[2].card.get(0), card5);
        open(player[2].card.get(1), card6);
        open(player[3].card.get(0), card7);
        open(player[3].card.get(1), card8);
    }

    public void betting() {
        if(editText.getText().toString().equals("")) {
            for(Player tmp: player) {
                tmp.bet(0);
            }
            rule.doBet(0);
        } else {
            for(Player tmp: player) {
                //tmp.bet(Integer.parseInt(editText.getText().toString()));
                rule.doBet(tmp.bet(Integer.parseInt(editText.getText().toString())));
            }
        }
        state.setText(player[0].name + ", 현재 돈 :" + player[0].money);
        money1.setText("현재 돈 :" + player[1].money);
        money2.setText("현재 돈 :" + player[2].money);
        money3.setText("현재 돈 :" + player[3].money);
        money.setText("판돈 :" + rule.gameMoney);
    }
}
