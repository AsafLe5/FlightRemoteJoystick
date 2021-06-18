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

import io.github.controlwear.virtual.joystick.android.JoystickView;


public class MainActivity extends AppCompatActivity {
    //Initialize Binding.
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Assign variable
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get IP from edit text
                String ipString = binding.ipText.getText().toString().trim();
                String portString = binding.portText.getText().toString().trim();
                //Check condition
                if(!ipString.equals("") && !portString.equals("")){
                    //When text is not empty - Set text on text view.
                    String portIp = ipString + "\n" + portString;
                    binding.tvOutput.setText(portIp);
                }
                else{
                    //When text is empty
                    Toast.makeText(getApplicationContext()
                            ,"Please enter both IP and Port!",Toast.LENGTH_SHORT).show();
                }
            }
        });



        //initialize fragment
        Fragment fragment = new MainFragment();
        //Commit fragment.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment,fragment).commit();




        //Joystick
        //Fragment joystick = new Joystick();
       // getSupportFragmentManager().beginTransaction()
         //       .replace(R.id.bt_joystick,joystick).commit();




        //setContentView(R.layout.activity_main); not goodie good:)
    }
}