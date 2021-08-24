package com.riefdroid.androidspreadsheets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, InterfaceFAN, InterfaceFileJson.save {

    private TextView TvSimpan;
    private EditText etnama, etemail, etjenis_kelamin, etalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TvSimpan = (TextView) findViewById(R.id.TvSimpan);
        etnama = (EditText) findViewById(R.id.nama);
        etemail = (EditText) findViewById(R.id.email);
        etjenis_kelamin = (EditText) findViewById(R.id.jenis_kelamin);
        etalamat = (EditText) findViewById(R.id.alamat);

        TvSimpan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(TvSimpan == v){
            String nama = etnama.getText().toString();
            String email = etemail.getText().toString();
            String jeniskelamin = etjenis_kelamin.getText().toString();
            String alamat = etalamat.getText().toString();
            if(TextUtils.isEmpty(nama)){
                etnama.setError("Isi Data");
                return;
            }
            if(TextUtils.isEmpty(email)){
                etemail.setError("Isi Data");
                return;
            }
            if(TextUtils.isEmpty(jeniskelamin)){
                etjenis_kelamin.setError("Isi Data");
                return;
            }
            if(TextUtils.isEmpty(alamat)){
                etalamat.setError("Isi Data");
                return;
            }

            Map<String, String> maps = new HashMap<>();
            maps.put("nama", nama);
            maps.put("email", email);
            maps.put("jenis_kelamin", jeniskelamin);
            maps.put("alamat", alamat);

            String url = "https://script.google.com/macros/s/AKfycbx0USUIn-uo33o41W9mV8-LpBGzYq6RRooBsdvMi_v8MORMKMw/exec";
            FAN fan = new FAN();
            fan.postFAN(url, "Simpan", maps ,this);

        }
    }

    @Override
    public void successFan(String json) throws JSONException {
        FileJson fileJson = new FileJson();
        fileJson.simpan(json,this);
    }

    @Override
    public void errorFAN(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void successSimpan(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        finish();
    }
}