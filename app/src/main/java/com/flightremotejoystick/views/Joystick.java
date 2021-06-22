package com.flightremotejoystick.views;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.flightremotejoystick.R;
import com.flightremotejoystick.databinding.FragmentMainBinding;
import com.flightremotejoystick.view_model.ViewModel;

import io.github.controlwear.virtual.joystick.android.JoystickView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Joystick extends Fragment {

    //Initialize variable
    private FragmentMainBinding binding;
    private View view;
    private ViewModel viewModel;

    /**
     * constructor
     * @param viewModel set ViewModel
     */
    public Joystick(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * creating the view of joystick
     * @param inflater It is an LayoutInflater type parameter
     * @param container It is an ViewGroup type parameter
     * @param savedInstanceState It is an Bundle type parameter
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Assign variable
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false);
        view = binding.getRoot();

        JoystickView joystick = (JoystickView) binding.btJoystick;
                //findViewById(R.id.joystickView);
        joystick.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                // do whatever you want
                // change aileron and elevator values.
                viewModel.setAileron((float)(strength*Math.cos(angle)));
                viewModel.setElevator((float)(strength*Math.sin(angle)));
            }
        });
        return view;
    }
}