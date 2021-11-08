package com.example.criador;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textCor;
    private Button btNovaCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textCor = findViewById(R.id.tvTextoCor);
        this.btNovaCor = findViewById(R.id.btMainNovaCor);

        // Contrato para pegar Intent da SelectorActiviy
        ActivityResultLauncher<Intent> selectorResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        int[] background = result.getData().getIntArrayExtra("BACKGROUND");
                        int backgroundColor = Color.rgb(background[0], background[1], background[2]);
                        textCor.setBackgroundColor(backgroundColor);
                        String hex = String.format("%02X%02X%02X", background[0], background[1], background[2]);
                        textCor.setText("#" + hex);

                    }
                }
        );

        // Abrir nova tela de seleção de cores
        this.btNovaCor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentColetor = new Intent(MainActivity.this, SeletorActivity.class);
                selectorResult.launch(intentColetor);
            }
        });
    }
}