package com.example.mvvm_java_android;

import android.text.TextWatcher;

public class LoginContract {

    interface View {

        void  moveToMainPage ();
        void  showErrorMessage(String message);

        void setValidEmail(boolean isValidEmail);



    }

    interface  ActionListener {
        void  login(String email, String password);

        TextWatcher registerTextWatcher( );


    }

}
