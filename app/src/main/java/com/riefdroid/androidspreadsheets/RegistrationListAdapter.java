package com.riefdroid.androidspreadsheets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RegistrationListAdapter extends RecyclerView.Adapter<RegistrationListAdapter.itemHolder> {


    private Context context;
    private ArrayList<RegistrationModel> registrationModels;

    public RegistrationListAdapter(Context context, ArrayList<RegistrationModel> registrationModels) {
        this.context = context;
        this.registrationModels = registrationModels;
    }




    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_registration, parent, false);
        return new itemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        RegistrationModel model = registrationModels.get(position);
        holder.TvNama.setText(model.getNama());
        holder.TvEmail.setText(model.getEmail());
        holder.TvJenisKelamin.setText(model.getJenis_kelamin());
        holder.TvAlamat.setText(model.getAlamat());


    }

    @Override
    public int getItemCount() {
        return registrationModels.size();
    }

    static class itemHolder extends RecyclerView.ViewHolder{

        private TextView TvNama, TvEmail, TvJenisKelamin, TvAlamat;
        public itemHolder(@NonNull View v) {
            super(v);
            TvNama = (TextView) v.findViewById(R.id.TvName);
            TvEmail = (TextView) v.findViewById(R.id.TvEmail);
            TvJenisKelamin = (TextView)  v.findViewById(R.id.TvJenisKelamin);
            TvAlamat = (TextView) v.findViewById(R.id.TvAlamat);

        }
    }
}
