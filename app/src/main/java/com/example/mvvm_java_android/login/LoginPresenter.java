package com.example.mvvm_java_android.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.example.mvvm_java_android.model.User;
import com.example.mvvm_java_android.utils.ApiService;
import com.example.mvvm_java_android.utils.MainApi;
import com.example.mvvm_java_android.utils.PreferenceManager;
import com.example.mvvm_java_android.utils.RequestCallback;

import retrofit2.Call;
import retrofit2.Response;

public class LoginPresenter  implements LoginContract.ActionListener{

    public String TAG = "TEST";

    private PreferenceManager preferenceManager;



    private LoginContract.View mLoginView;

    private MainApi mainApi;



    public LoginPresenter(LoginContract.View mLoginView) {
        this.mLoginView = mLoginView;
        mainApi = ApiService.provideApi(MainApi.class, (LoginActivity) mLoginView);
        preferenceManager = new PreferenceManager((LoginActivity) mLoginView);
    }


    @Override
    public void login(String email, String password) {
        if (!isEmailValid(email)) {
            mLoginView.showErrorMessage("Email is not valid");
            Log.d(TAG, "login: Email is not valid");
            return;
        };

        User user = new User(email, password);
        mainApi.login(user).enqueue(new RequestCallback<User>() {
            @Override
            protected void onResponseSuccess(Call<User> call, Response<User> response) {

                User authUser = response.body();


                    preferenceManager.setValue("isLogin", true);
                    preferenceManager.setValue("access_token", authUser.getAccess_token());
                    preferenceManager.setValue("id", authUser.getId());
                    preferenceManager.setValue("email", authUser.getEmail());
                    preferenceManager.setValue("first_name", authUser.getFirst_name());
                    preferenceManager.setValue("last_name", authUser.getLast_name());
                    preferenceManager.setValue("phone_number", authUser.getPhone_number());
                    preferenceManager.setValue("address", authUser.getAddress());
                    preferenceManager.setValue("refresh_token", authUser.getRefresh_token());
                    preferenceManager.setValue("user", authUser);

                    mLoginView.moveToMainPage();






            }

            @Override
            protected void onResponseFailed(Call<User> call, Throwable t) {

            }
        });



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
