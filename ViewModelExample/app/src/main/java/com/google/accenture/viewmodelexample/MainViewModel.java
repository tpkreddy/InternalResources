package com.google.accenture.viewmodelexample;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int count;
    public MainViewModel() {
        count = 0;
        Log.v("MainViewModel","ViewModel is created");
    }

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }

    public int getCount(){
        return count;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.v("MainViewModel","ViewModel is destroyed");
    }
}
