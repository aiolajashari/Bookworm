package com.bookworm.bookworm.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bookworm.bookworm.R;

public class Scoreboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        TextView tvpPrompt= findViewById(R.id.tvpPrompt);
        //(TextView)
        tvpPrompt.setText(getIntent().getStringExtra("tvpPrompt"));
    }
}
