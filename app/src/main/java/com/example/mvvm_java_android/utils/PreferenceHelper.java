package com.example.mvvm_java_android.utils;

public interface PreferenceHelper {
    void setValue(String key, Object value);
    <T> Object getValue (Class <T> aClass, String key, Object defaultValue);
}
