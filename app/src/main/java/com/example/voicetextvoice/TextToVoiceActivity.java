package com.example.voicetextvoice;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

/**
 * Created by Dhrumil.
 */
public class TextToVoiceActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private EditText etInputText;
    private Button btnRead;
    private TextToSpeech tts;
    private final String TAG="TextToVoiceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_to_voice);

        tts = new TextToSpeech(this, this);
        etInputText=(EditText)findViewById(R.id.et_input_text);
        btnRead=(Button)findViewById(R.id.btn_read);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etInputText.getText().toString();
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e(TAG, "Language is not supported");
            }

        } else {
            Log.e(TAG, "Failed!");
        }
    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
