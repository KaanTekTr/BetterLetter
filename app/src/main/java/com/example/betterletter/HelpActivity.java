package com.example.betterletter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    private TextView helpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        helpText = findViewById(R.id.help_id);

        String first = "\n      Welcome to BetterLetter!\n\n    This app offers you various cool features for you to strengthen your writing skills\n\n"
                + "    You can check our DICTIONARY for the unknown words, try out CHECKER to notice and correct your typos and finally, enjoy ENHANCER "
                +"by editing your text in the most appealing way. Have fun!";
        helpText.setText(first);
    }
}