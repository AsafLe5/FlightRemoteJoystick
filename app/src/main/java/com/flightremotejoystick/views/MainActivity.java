package com.flightremotejoystick.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.flightremotejoystick.R;
import com.flightremotejoystick.databinding.ActivityMainBinding;
import com.flightremotejoystick.model.FGPlayer;
import com.flightremotejoystick.view_model.ViewModel;

import java.io.IOException;

/**
 * MainActivity class
 */
public class MainActivity extends AppCompatActivity {

    //Initialize Binding.
    private FGPlayer model;
    private ViewModel viewModel;
    ActivityMainBinding binding;

    /**
     * create the main activity
     * @param savedInstanceState It is an Bundle type parameter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            model = new FGPlayer();
            viewModel = new ViewModel(model);

        super.onCreate(savedInstanceState);
        //Assign variable
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btConnect.setOnClickListener(new View.OnClickListener() {
            /**
             * binding when pressing the screen
             * @param v View parameter
             */
            @Override
            public void onClick(View v) {
                //Get IP from edit text
                String ipString = binding.ipText.getText().toString().trim();
                String portString = binding.portText.getText().toString().trim();
                //Check condition
                if(!ipString.equals("") && !portString.equals("")){
                    //When text is not empty - Set text on text view.
                    try {
                        viewModel.initializeModel(ipString,Integer.parseInt(portString));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    //When text is empty
                    Toast.makeText(getApplicationContext()
                            ,"Please enter both IP and Port!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.rudderSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * change the placement of sliders
             * @param seekBar It is an Bundle type parameter
             * @param progress int parameter
             * @param b boolean parameter
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int start = binding.rudderSeekBar.getMax();
                float rudder = (float)(progress)/(float)start;
                if (rudder<0.5){
                    rudder = (float)(rudder-0.5)*2;
                }else
                    rudder = (float)(rudder-0.5)*2;
                viewModel.setRudder(rudder);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        binding.throttleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * change the placement of sliders
             * @param seekBar It is an Bundle type parameter
             * @param progress int parameter
             * @param b boolean parameter
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int start = binding.throttleSeekBar.getMax();
                float throttle = (float)(progress)/(float)start;
                viewModel.setThrottle(throttle);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        //initialize fragment
        Fragment fragment;
        fragment = new Joystick(this.viewModel);
        //Commit fragment.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment,fragment).commit();
    }
}