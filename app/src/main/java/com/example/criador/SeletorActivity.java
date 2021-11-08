package com.example.criador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SeletorActivity extends AppCompatActivity {

    private TextView cor;
    private SeekBar corRed;
    private SeekBar corGreen;
    private SeekBar corBlue;
    private Button btSalvar;
    private Button btCancelar;

    private int red;
    private int green;
    private int blue;
    int background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seletor);

        this.cor = findViewById(R.id.texto);
        this.corRed = findViewById(R.id.seekRed);
        this.corGreen = findViewById(R.id.seekGreen);
        this.corBlue = findViewById(R.id.seekBlue);
        this.btSalvar = findViewById(R.id.btSelectorSalvar);
        this.btCancelar = findViewById(R.id.btSelectorCanelar);

        this.corRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                atualizarBackground();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        this.corGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                atualizarBackground();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        this.corBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                atualizarBackground();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        this.btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        this.btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });

    }

    public void salvar(){
        int[] cores = {red, green, blue};
        Intent intentCor = new Intent().putExtra("BACKGROUND", cores);
        setResult(RESULT_OK, intentCor);
        finish();
    }

    public void cancelar(){
        finish();
    }

    public void atualizarBackground(){
        background = Color.rgb(red, green, blue);
        cor.setBackgroundColor(background);
        String hex = String.format("%02X%02X%02X", red, green, blue);
        cor.setText("#" + hex);


    }
}