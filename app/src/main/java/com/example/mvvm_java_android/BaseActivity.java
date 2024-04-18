package com.example.mvvm_java_android;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.example.mvvm_java_android.base.BaseView;
import com.example.mvvm_java_android.util.PreferenceManager;

public abstract class BaseActivity <VB extends ViewBinding>  extends AppCompatActivity implements BaseView {


    public VB binding;


    public abstract VB inflateViewBinding(LayoutInflater inflater);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflateViewBinding(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    @Override
    public void showLoading(boolean isShowing) {

    }
}
