package com.example.intent3ytres;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    public TextView texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        texto =  findViewById(R.id.textView);

        new CountDownTimer(5000 , 1000) {

            @Override
            public void onTick(long milis) {
                int segundos = (int) (milis / 1000);
                texto.setText("Cargando... " + segundos );
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
        //crea un objeto Intent que se utiliza para iniciar una nueva actividad en Android.
        //la intención es iniciar la actividad MainActivity desde la actividad Splash.
    }
}