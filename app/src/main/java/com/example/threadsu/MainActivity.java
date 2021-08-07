package com.example.threadsu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvtoshow;
    private EditText ettoshow;
    private Button btntosend;
    private String name;
    private ProgressBar progressIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }

    private void initviews() {

        tvtoshow = findViewById(R.id.tvtoshow);
        ettoshow = findViewById(R.id.ettogive);
        btntosend = findViewById(R.id.btntosend);
        progressIndicator = findViewById(R.id.progressbar);

        btntosend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncTask.execute();
                progressIndicator.setVisibility(View.VISIBLE);
            }
        });
    }


    public String getname() {
        int count = 0;
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(1000);
                count = count + 10;
                progressIndicator.setProgress(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Display";
    }

    private AsyncTask<String, Void, String> asyncTask = new AsyncTask<String, Void, String>() {
        @Override
        protected String doInBackground(String... strings) {
            String name = ettoshow.getText().toString();
            String output = getname() + " : " + name;
            return output;
        }

        @Override
        protected void onPostExecute(String s) {
            tvtoshow.setVisibility(View.VISIBLE);
            progressIndicator.setVisibility(View.GONE);
            tvtoshow.setText(s);
        }

    };

}