package com.example.mvvm_java_android;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

public class LoginPresenter  implements LoginContract.ActionListener{

    public String TAG = "TEST";



    private LoginContract.View mLoginView;

    public LoginPresenter(LoginContract.View mLoginView) {
        this.mLoginView = mLoginView;
    }


    @Override
    public void login(String email, String password) {
        if (!isEmailValid(email)) {
            mLoginView.showErrorMessage("Email is not valid");
            Log.d(TAG, "login: Email is not valid");
            return;
        };


    }

    @Override
    public TextWatcher registerTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String email = s.toString();
                Log.d("EditText", email);
                boolean isValidEmail = isEmailValid(email);
                mLoginView.setValidEmail(isValidEmail);


//                if (email.contains("@") && email.indexOf('@') != 0) {
//                    String tail = email.substring(email.indexOf('@'));
//                    if (tail.contains(".")
//                            && tail.indexOf('.') != 1
//                            && email.lastIndexOf('.') != (email.length() - 1)) {
//                        binding.icVerifiedEmail.setVisibility(View.VISIBLE);
//                    } else {
//                        binding.icVerifiedEmail.setVisibility(View.INVISIBLE);
//                    }
//                } else {
//                    binding.icVerifiedEmail.setVisibility(View.INVISIBLE);
//                }



            }
        };
    }

    private boolean isEmailValid(String email) {
        boolean isValid = false;
        if (email.contains("@") && email.indexOf('@') != 0) {
            String tail = email.substring(email.indexOf('@'));
            if (tail.contains(".")
                    && tail.indexOf('.') != 1
                    && email.lastIndexOf('.') != (email.length() - 1)) {
                isValid = true;
            }

        }


        return isValid;
    }
}
