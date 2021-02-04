package com.example.betterletter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CheckerActivity extends AppCompatActivity {

    private Button check_button;
    private EditText editText;
    private TextView wordCount;
    private OkHttpClient client = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checker);

        check_button = findViewById(R.id.typo_button_id);
        editText = findViewById(R.id.typo_text_id);
        wordCount = findViewById(R.id.word_count_text);

        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTheText();
            }
        });
    }

    public void checkTheText()
    {
        int counter = 0;
        String text = editText.getText().toString();
        SpannableString ss = new SpannableString(text);
        for (int i = 0; i < text.length(); i++)
        {
            String word = "";
            for (int j = i; j < text.length(); j++)
            {
                int holder1 = i;
                int holder2 = 0;

                if (Character.isLetter(text.charAt(j)))
                {
                    word = word + text.charAt(j);
                }
                else if (!Character.isLetter(text.charAt(j)) && Character.isLetter(text.charAt(j-1)))
                {
                    holder2 = j;
                    i = j;
                    j = text.length();
                    checkTheWord(word, holder1 ,holder2, ss);
                    counter++;

                }
            }
        }
        wordCount.setText("Word count: " + counter );
        Toast toast = Toast.makeText(this, "Don't forget to correct the typos!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 1100);
        toast.show();
    }

    public void checkTheWord(String word, int holder1, int holder2, SpannableString ssb)
    {
        final int holder3 = holder1;
        final int holder4 = holder2;
        final SpannableString ss = ssb;
        String url = "https://www.dictionaryapi.com/api/v3/references/collegiate/json/" + word + "?key=932b593b-929f-4519-8e5f-2a14640452f6";
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                if (response.isSuccessful())
                {
                    final String myResponse = response.body().string();
                    CheckerActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            highlight(myResponse, holder3, holder4, ss);
                        }
                    });
                }
            }
        });
    }

    public void highlight(String def, int start, int stop, SpannableString ssfinal)
    {
        if (def.charAt(1) != '{')
        {
            // SpannableString ss = new SpannableString(text3);
            BackgroundColorSpan yellowHighlight = new BackgroundColorSpan(Color.YELLOW);
            ssfinal.setSpan(yellowHighlight, start, stop, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            editText.setText(ssfinal);
        }

    }
    // Hello, welcama to my first projact. I hope you reallie like it! Please feel free to giiive some feedbeck.



}