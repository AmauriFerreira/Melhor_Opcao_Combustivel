package com.example.melhor_opcao_combustivel;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();


    private SeekBar precoAlcoolSeekBar;
    private SeekBar precoGasolinaSeekBar;
    private TextView resultado;
    private TextView varTextView1;
    private TextView varTextView2;
    private double number1;
    private double number2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoGasolinaSeekBar = findViewById(R.id.precoGasolinaSeekBar);
        precoAlcoolSeekBar = findViewById(R.id.precoAlcoolSeekBar);
        varTextView1 =findViewById(R.id.varTextView1);
        varTextView2 = findViewById(R.id.varTextView2);
        resultado = findViewById(R.id.resultado);

        precoGasolinaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {
                number1 = progress/100d;
                varTextView1.setText(currencyFormat.format(number1));

                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {

            }
        });

        precoAlcoolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                number2 = progress/100d;
                varTextView2.setText(currencyFormat.format(number2));
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {

            }
        });


    }


    private void  calcular(){
        double res= number2/number1;
        if (res<=0.7) {
            resultado.setText(R.string.variavel1);
            ImageView imageView=(ImageView) findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.etanol);

        }else {
            resultado.setText(R.string.variavel2);;
            ImageView imageView=(ImageView) findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.gasosa);
        }

    }

}