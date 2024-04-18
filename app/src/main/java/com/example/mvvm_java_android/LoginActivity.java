package com.example.mvvm_java_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.example.mvvm_java_android.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements  LoginContract.View{


    private LoginContract.ActionListener userActionListener;

    @Override
    public ActivityLoginBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityLoginBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userActionListener = new LoginPresenter(this);

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = binding.emailEditText.getText().toString();
                String password = binding.passwordEdittext.getText().toString();
                userActionListener.login(email, password);

            }
        });

        binding.emailEditText.addTextChangedListener(userActionListener.registerTextWatcher());

    }

    @Override
    public void moveToMainPage() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void showErrorMessage(String message) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void setValidEmail(boolean isValidEmail) {
        binding.icVerifiedEmail.setVisibility(isValidEmail? View.VISIBLE : View.INVISIBLE);
    }



}