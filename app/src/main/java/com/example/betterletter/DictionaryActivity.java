package com.example.betterletter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DictionaryActivity extends AppCompatActivity {

    private EditText editText;
    private ImageButton imageButton;
    private TextView textView;
    String word;
    String definiton;
     private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        editText = findViewById(R.id.edit_text_id);
        imageButton = findViewById(R.id.image_button_id);
        textView = findViewById(R.id.text_view_id);
        word = editText.getText().toString();
        //requestQueue = Volley.newRequestQueue(this);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search(view);
            }
        });
    }


    public void search(View view)
    {
        String url = "https://www.dictionaryapi.com/api/v3/references/collegiate/json/" + editText.getText().toString() + "?key=932b593b-929f-4519-8e5f-2a14640452f6";
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
                    DictionaryActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setText(myResponse);
                        }
                    });
                }
            }
        });

    }
    public void setText(String text)
    {
        String result = "";
        int end = 0;
        int counter = 0;

        for(int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == 's' && text.charAt(i + 1) == 'h' && text.charAt(i + 2) == 'o')
            {
                for (int j = i + 8; j < text.length(); j++)
                {
                    //if (text.charAt(j) != '[' && text.charAt(j) != ']' && text.charAt(j) != '(' && text.charAt(j) != ')' && text.charAt(j) != '"')
                    //{
                    if(Character.isLetter(text.charAt(j)) || text.charAt(j) == ' ' || text.charAt(j) == ',')
                    {
                        result = result + text.charAt(j);
                    }
                    else if (text.charAt(j) == ')' || text.charAt(j) == ']')
                    {
                        i = j;
                        j = text.length();
                        result = result + "\n\n";
                        counter++;
                        if (counter == 4)
                        {
                            i = text.length();
                        }
                    }
                }
            }
        }
        if (result == "")
        {
            int checker = 0;
            result = "Did you mean...\n\n";
            for (int i = 0; i < text.length(); i++)
            {
                if(Character.isLetter(text.charAt(i)) || text.charAt(i) == ' ' || text.charAt(i) == ',')
                {

                    if (text.charAt(i) == ',')
                    {
                        result = result + "\n";
                        checker++;
                    }
                    else
                    {
                        result = result + text.charAt(i);
                    }
                    if (checker == 5)
                    {
                        i = text.length();
                    }
                }
            }
            if (result == "Did you mean...\n\n")
            {
                result = "No word or suggestion found...";
                Toast toast = Toast.makeText(this, "Please check the spelling", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 1100);
                toast.show();
            }
        }

        textView.setText(result);
    }




}

