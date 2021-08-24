package com.riefdroid.androidspreadsheets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FileJson {

    public void simpan (String json, InterfaceFileJson.save view) throws JSONException {
        JSONObject object = new JSONObject(json);
        view.successSimpan(object.getString("status"));
    }

    public void listRegistration(String json, InterfaceFileJson.list view) throws JSONException{
        JSONObject object = new JSONObject(json);
        JSONArray JsonArray = object.getJSONArray("records");
        ArrayList<RegistrationModel> registrationModels = new ArrayList<>();
        for (int i = 0 ; i <JsonArray.length(); i++){
            RegistrationModel model = new RegistrationModel();
            model.setNama(JsonArray.getJSONObject(i).getString("nama"));
            model.setEmail(JsonArray.getJSONObject(i).getString("email"));
            model.setJenis_kelamin(JsonArray.getJSONObject(i).getString("jenis_kelamin"));
            model.setAlamat(JsonArray.getJSONObject(i).getString("alamat"));

            registrationModels.add(model);

        }

        view.ListRegistration(registrationModels);
    }


}
