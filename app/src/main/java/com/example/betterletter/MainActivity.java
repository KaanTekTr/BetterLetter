package com.example.betterletter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton Imagebutton;
    private Button enhanceButton;
    private Button dictionaryButton;
    private Button checkerButton;
    private TextView kaanTek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enhanceButton = (Button) findViewById(R.id.enhance_button);
        dictionaryButton = (Button) findViewById(R.id.dictionary_button);
        checkerButton = findViewById(R.id.checker_button);
        kaanTek = findViewById(R.id.kaan_tek_text);

        enhanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTextActivity();
            }
        });

        dictionaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDictionaryActivity();
            }
        });

        checkerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCheckerActivity();
            }
        });

        Imagebutton = (ImageButton) findViewById(R.id.help_Button);
        Imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHelpActivity();
            }
        });
    }

    public void openHelpActivity()
    {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
    public void openTextActivity()
    {
        Intent intent = new Intent(this, TextActivity.class);
        startActivity(intent);
    }
    public void openDictionaryActivity()
    {
        Intent intent = new Intent(this, DictionaryActivity.class);
        startActivity(intent);
    }
    public void openCheckerActivity()
    {
        Intent intent = new Intent(this, CheckerActivity.class);
        startActivity(intent);
    }

}