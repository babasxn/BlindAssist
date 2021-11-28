package com.babasxn.blindassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class outputActivity extends AppCompatActivity {

    String message;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textViewOutput);
        textView.setText(message);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);

                }
            }
        });
    }

    public void Add2(View view)
    {

        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void speech(View view) {

        String toSpeak = message;

        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

    }
}