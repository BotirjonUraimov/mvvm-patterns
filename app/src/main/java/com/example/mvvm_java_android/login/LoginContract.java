package com.example.mvvm_java_android.login;

import android.text.TextWatcher;
import android.view.View;

import com.example.mvvm_java_android.base.BaseView;

public class LoginContract {

    interface View  extends BaseView {

        void  moveToMainPage ();
        void  showErrorMessage(String message);

        void setValidEmail(boolean isValidEmail);
    }

    interface  ActionListener {
        void  login(String email, String password);
        android.view.View.OnClickListener loginBtnClick();
        TextWatcher registerPasswordWatcher();
        TextWatcher registerTextWatcher( );


    }

}
