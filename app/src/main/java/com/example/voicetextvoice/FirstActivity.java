package com.example.voicetextvoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dhrumil.
 */
public class FirstActivity extends AppCompatActivity{

    private Button btnVoiceToText,btnTextToVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);

        btnVoiceToText=(Button)findViewById(R.id.btn_voice_to_text);
        btnTextToVoice=(Button)findViewById(R.id.btn_text_to_voice);

        btnVoiceToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstActivity.this,VoiceToTextActivity.class);
                startActivity(i);
            }
        });

        btnTextToVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstActivity.this,TextToVoiceActivity.class);
                startActivity(i);
            }
        });
    }
}
