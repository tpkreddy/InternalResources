package com.google.accenture.viewmodelexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.google.accenture.viewmodelexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    private MainViewModel mvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mvm = new ViewModelProvider(this).get(MainViewModel.class);
        binding.result.setText(String.valueOf(mvm.getCount()));
        binding.plus.setOnClickListener(this);
        binding.minus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.plus){
            mvm.increment();
        }else{
            mvm.decrement();
        }
        binding.result.setText(String.valueOf(mvm.getCount()));
    }
}