package com.example.mvvm_java_android;

import android.view.LayoutInflater;

import com.example.mvvm_java_android.base.BaseActivity;
import com.example.mvvm_java_android.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    public ActivityMainBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityMainBinding.inflate(inflater);
    }


}
