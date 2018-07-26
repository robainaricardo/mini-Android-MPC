package com.example.ricardo.miniandoidmpc;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // os botoes
    private ImageView btn1, btn2, btn3, btn4, btn5, btn6;
    // um ObjetoMediaPlayer para cada botao para diminuir a latencia
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (ImageView) findViewById(R.id.btn1ID);
        btn2 = (ImageView) findViewById(R.id.btn2ID);
        btn3 = (ImageView) findViewById(R.id.btn3ID);
        btn4 = (ImageView) findViewById(R.id.btn4ID);
        btn5 = (ImageView) findViewById(R.id.btn5ID);
        btn6 = (ImageView) findViewById(R.id.btn6ID);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1ID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bumbo);
                tocarSom();
                break;
            case R.id.btn2ID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.boom);
                tocarSom();
                break;
            case R.id.btn3ID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.caixa);
                tocarSom();
                break;
            case R.id.btn4ID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bop);
                tocarSom();
                break;
            case R.id.btn5ID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.chipofechado);
                tocarSom();
                break;
            case R.id.btn6ID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.chipoaberto);
                tocarSom();
                break;

        }
    }



    public void tocarSom(){
        //toca o som
        if(mediaPlayer!=null){
            mediaPlayer.start();
        }

        //libera recursos
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }


}
