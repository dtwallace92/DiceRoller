package com.dtwallace.diceroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int diceSize;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText diceSizeEditText = findViewById(R.id.diceSizeEditText);
        Button rollButton = findViewById(R.id.rollButton);
        final TextView resultText = findViewById(R.id.resultText);

        /**
         * When Roll button is clicked take chosen dice number and roll for a random number within
         * that range.
         */
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                String editValue = diceSizeEditText.getText().toString();
                diceSize = Integer.parseInt(editValue);

                // Make sure user input a proper dice size
                if (diceSize > 0) {
                    result = r.nextInt(diceSize) + 1;
                    resultText.setText(String.valueOf(result));
                } else {
                    Toast.makeText(MainActivity.this, "Dice must be larger than zero!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
