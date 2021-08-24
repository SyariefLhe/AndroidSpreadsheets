package com.riefdroid.androidspreadsheets;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONException;
import java.util.Map;

public class FAN {

    public void getFAN(String url, String tag, InterfaceFAN view) {
        AndroidNetworking.get(url)

                .setTag(tag)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            view .successFan(response);
                        } catch (JSONException e) {
                            view.errorFAN(e.getMessage());
                            // e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.errorFAN(String.valueOf(anError));

                    }
                });

    }

    public void postFAN(String url, String tag, Map<String, String> maps, InterfaceFAN view) {
        AndroidNetworking.post(url)

                .addBodyParameter(maps)// post map
                .setTag(tag)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            view .successFan(response);
                        } catch (JSONException e) {
                            view.errorFAN(e.getMessage());
                            // e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.errorFAN(String.valueOf(anError));

                    }
                });

    }

}
