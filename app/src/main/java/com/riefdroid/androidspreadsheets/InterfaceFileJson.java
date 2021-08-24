package com.riefdroid.androidspreadsheets;

import java.util.ArrayList;

public interface InterfaceFileJson {

    interface save{
        void successSimpan(String message);
    }

    interface list{
        void ListRegistration(ArrayList<RegistrationModel> registrationModels);
    }


}
