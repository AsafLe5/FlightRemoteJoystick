package com.flightremotejoystick.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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


        //findViewById(R.id.bt_connect).setOnClickListener(new View.OnClickListener(){
        binding.btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get IP from edit text
                String ipString = binding.ipText.getText().toString().trim();
                //Check condition
                if(!ipString.equals("")){
                    //When text is not empty
                    //Set text on text view
                    binding.tvOutput.setText(ipString);
                }
                else{
                    //When text is empty
                    Toast.makeText(getApplicationContext()
                            ,"please enter text!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //initialize fragment
        Fragment fragment = new MainFragment();
        //Commit fragment.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment,fragment).commit();
        //setContentView(R.layout.activity_main);
    }
}