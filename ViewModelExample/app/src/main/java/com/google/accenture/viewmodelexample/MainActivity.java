package com.google.accenture.viewmodelexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.google.accenture.viewmodelexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.plus.setOnClickListener(this);
        binding.minus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.plus){
            count++;
        }else{
            count--;
        }
        binding.result.setText(String.valueOf(count));
    }
}