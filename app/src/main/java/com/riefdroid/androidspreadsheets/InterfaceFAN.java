package com.riefdroid.androidspreadsheets;

import org.json.JSONException;

public interface InterfaceFAN {
    void successFan(String json) throws JSONException;
    void errorFAN(String error);
}
