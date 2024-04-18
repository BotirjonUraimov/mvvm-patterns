package com.example.mvvm_java_android.login;

import android.text.TextWatcher;

import com.example.mvvm_java_android.base.BaseView;

public class LoginContract {

    interface View  extends BaseView {

        void  moveToMainPage ();
        void  showErrorMessage(String message);

        void setValidEmail(boolean isValidEmail);



    }

    interface  ActionListener {
        void  login(String email, String password);

        TextWatcher registerTextWatcher( );


    }

}
