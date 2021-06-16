package com.flightremotejoystick.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.flightremotejoystick.R;
import com.flightremotejoystick.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    //Initialize Binding.
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Assign variable
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get IP from edit text
                String ip = binding.ipText.getText().toString().trim();
                //Check condition
                if(!ip.equals("")){
                    //When text is not empty
                    //Set text on text view
                    binding.tvOutput.setText(ip);
                }
                else{
                    //When text is empty - display t
                }
            }
        });
        setContentView(R.layout.activity_main);
    }
}