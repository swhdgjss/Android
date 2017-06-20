package com.example.l.holdem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    RadioGroup radioGroup;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, Splash.class));

        button = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;

                if(editText.getText().toString().equals("")) name = "Guest";
                else name = editText.getText().toString();
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton:
                        Intent intent = new Intent(MainActivity.this, Play4.class);
                        intent.putExtra("state", name);
                        startActivity(intent);
                        break;
                    case R.id.radioButton2:
                        Intent intent2 = new Intent(MainActivity.this, Play5.class);
                        intent2.putExtra("state", name);
                        startActivity(intent2);
                        break;
                    case R.id.radioButton3:
                        Intent intent3 = new Intent(MainActivity.this, Play6.class);
                        intent3.putExtra("state", name);
                        startActivity(intent3);
                        break;
                }
            }
        });
    }
}
