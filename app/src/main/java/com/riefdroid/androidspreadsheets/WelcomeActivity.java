package com.riefdroid.androidspreadsheets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView TvTambah, TvData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_welcome);

        TvTambah = (TextView) findViewById(R.id.TvTambah);
        TvData = (TextView) findViewById(R.id.TvData);

        TvTambah.setOnClickListener(this);
        TvData.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == TvTambah) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (v == TvData) {
            Intent i = new Intent(this, RegistrationListActivity.class);
            startActivity(i);

        }
    }
}
