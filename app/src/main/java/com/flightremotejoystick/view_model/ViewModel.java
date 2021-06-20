package com.flightremotejoystick.view_model;

import android.app.Application;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.lifecycle.AndroidViewModel;

import com.flightremotejoystick.model.FGPlayer;

import java.io.IOException;
import java.net.Socket;


public class ViewModel{ //extends AndroidViewModel {

    private FGPlayer model;

    private String ip;
    private int port;

    public void initializeModel(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        this.model.initialize(ip,port);
    }


    public ViewModel(FGPlayer model){
         this.model = model;
    }

    public void setAileron(float aileron) {
        this.model.setAileron(aileron);
    }

    public void setElevator(float elevator) {
        this.model.setElevator(elevator);
        //TODO: call a function in main for sending to server.
    }

    public void setThrottle(float throttle) {
        this.model.setThrottle(throttle);
    }

    public void setRudder(float rudder) {
        this.model.setRudder(rudder);
    }
}
