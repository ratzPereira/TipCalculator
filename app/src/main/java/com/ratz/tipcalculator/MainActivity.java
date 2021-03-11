package com.ratz.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText tipValue;
    private TextView tipPercent;
    private TextView textTip;
    private TextView textTotal;
    private SeekBar tip;

    private double percent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipValue = findViewById(R.id.tipValue);
        tipPercent = findViewById(R.id.tipPercentage);
        textTip = findViewById(R.id.textTip);
        textTotal = findViewById(R.id.textTotal);
        tip = findViewById(R.id.seekBarTip);

        //seek bar Listner
        tip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                percent = progress;
                tipPercent.setText( Math.round(percent)  + "%");
                calculateTip();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculateTip() {

        String userInput = tipValue.getText().toString();

        if(userInput == null || userInput.equals("")){

            Toast.makeText(getApplicationContext(), "Insert value", Toast.LENGTH_LONG).show();

        } else {

            //Convert to Double
            double value = Double.parseDouble(userInput);

            //calc tip
            double tip = value * (percent / 100);

            //show tip and total
            textTip.setText("$ " + Math.round(tip) );
            textTotal.setText("$ " + Math.round(value + tip));
        }
    }
}
