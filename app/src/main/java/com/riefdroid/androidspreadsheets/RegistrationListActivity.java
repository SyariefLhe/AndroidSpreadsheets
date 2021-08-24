package com.riefdroid.androidspreadsheets;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;

public class RegistrationListActivity extends AppCompatActivity implements InterfaceFAN, InterfaceFileJson, InterfaceFileJson.list {

    private RecyclerView TvList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String url = "https://script.google.com/macros/s/AKfycbx0USUIn-uo33o41W9mV8-LpBGzYq6RRooBsdvMi_v8MORMKMw/exec?action=read";
        FAN fan = new FAN();
        fan.getFAN(url, "list", this);

        TvList = (RecyclerView) findViewById(R.id.TvList);
        TvList.setLayoutManager(new LinearLayoutManager(this));
        TvList.setHasFixedSize(true);

    }

    @Override
    public void successFan(String json) throws JSONException {
        FileJson fileJson = new FileJson();
        fileJson.listRegistration(json, this);
    }

    @Override
    public void errorFAN(String error) {

        Toast.makeText( this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ListRegistration(ArrayList<RegistrationModel> registrationModels) {
        TvList.setAdapter(new RegistrationListAdapter(this, registrationModels));
    }
}
