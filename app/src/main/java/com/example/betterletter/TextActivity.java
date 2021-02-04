package com.example.betterletter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class TextActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editText;
    private Button caseButton;
    private Spinner colorSpinner;
    private Spinner fontSpinner;
    private Spinner fontTypeSpinner;
    boolean caseChecker;

    //This is the checkar part. Here you can seeee the typos you make and chenge them. It also showes you the word coant.

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        editText = findViewById(R.id.edit_text_id);
        caseButton = findViewById(R.id.case_button);
        colorSpinner = findViewById(R.id.color_spinner_id);
        fontSpinner = findViewById(R.id.font_spinner_id);
        fontTypeSpinner = findViewById(R.id.font_type_spinner_id);
        caseChecker = false;

        caseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caseChanger();
            }
        });
        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorAdapter);
        colorSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> fontAdapter = ArrayAdapter.createFromResource(this, R.array.fonts, android.R.layout.simple_spinner_item);
        fontAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSpinner.setAdapter(fontAdapter);
        fontSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> fontTypeAdapter = ArrayAdapter.createFromResource(this, R.array.fontTypes, android.R.layout.simple_spinner_item);
        fontTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontTypeSpinner.setAdapter(fontTypeAdapter);
        fontTypeSpinner.setOnItemSelectedListener(this);

    }

    public void caseChanger()
    {
        String text = editText.getText().toString();
        if (!caseChecker) {
            text = text.toUpperCase();
            editText.setText(text);
            caseChecker = true;
        }
        else {
            text = text.toLowerCase();
            editText.setText(text);
            caseChecker = false;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == colorSpinner.getId()) {
            if (i == 0) {
                editText.setTextColor(Color.BLACK);
            } else if (i == 1) {
                editText.setTextColor(Color.RED);
            } else if (i == 2) {
                editText.setTextColor(Color.BLUE);
            } else if (i == 3) {
                editText.setTextColor(Color.GREEN);
            } else if (i == 4) {
                editText.setTextColor(Color.YELLOW);
            }
        }
        else if (adapterView.getId() == fontSpinner.getId())
        {
            if (i == 0) {
                editText.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
            }
            if (i == 1) {
                editText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            }
            if (i == 2) {
                editText.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
            }
            if (i == 3) {
                editText.setTypeface(Typeface.DEFAULT, Typeface.BOLD_ITALIC);
            }
        }
        else if (adapterView.getId() == fontTypeSpinner.getId())
        {
            if (i == 0) {
               //Typeface typeface = ResourcesCompat.getFont(this, R.font.);
               //editText.setTypeface(typeface);
            }
            if (i == 1) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.aclonica);
                editText.setTypeface(typeface);
            }
            if (i == 2) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.akronim);
                editText.setTypeface(typeface);
            }
            if (i == 3) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.almendra_display);
                editText.setTypeface(typeface);
            }
            if (i == 4) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.anton);
                editText.setTypeface(typeface);
            }
            if (i == 5) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.bangers);
                editText.setTypeface(typeface);
            }
            if (i == 6) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.bungee_shade);
                editText.setTypeface(typeface);
            }
            if (i == 7) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.caesar_dressing);
                editText.setTypeface(typeface);
            }
            if (i == 8) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.delius_swash_caps);
                editText.setTypeface(typeface);
            }
            if (i == 9) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.faster_one);
                editText.setTypeface(typeface);
            }
            if (i == 10) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.mountains_of_christmas);
                editText.setTypeface(typeface);
            }
            if (i == 11) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.schoolbell);
                editText.setTypeface(typeface);
            }
            if (i == 12) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.snowburst_one);
                editText.setTypeface(typeface);
            }
            if (i == 13) {
                Typeface typeface = ResourcesCompat.getFont(this, R.font.unifrakturmaguntia);
                editText.setTypeface(typeface);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}