package com.flightremotejoystick.view_model;

import android.app.Application;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.lifecycle.AndroidViewModel;

import com.flightremotejoystick.model.FGPlayer;

import java.io.IOException;
import java.net.Socket;

/**
 * ViewModel class
 */
public class ViewModel{

    private FGPlayer model;

    /**
     *  initialize the model connection
     * @param ip string - computer ip
     * @param port int parameter
     * @throws IOException if failed
     */
    public void initializeModel(String ip, int port) throws IOException {
        this.model.initialize(ip,port);
    }

    /**
     * constructor
     * @param model FGPlayer
     */
    public ViewModel(FGPlayer model){
         this.model = model;
    }

    /**
     * set aileron
     * @param aileron float number
     */
    public void setAileron(float aileron) {
        this.model.setAileron(aileron);
    }

    /**
     * set elevator
     * @param elevator float number
     */
    public void setElevator(float elevator) {
        this.model.setElevator(elevator);
    }

    /**
     * set throttle
     * @param throttle float number
     */
    public void setThrottle(float throttle) {
        this.model.setThrottle(throttle);
    }

    /**
     * set rudder
     * @param rudder float number
     */
    public void setRudder(float rudder) {
        this.model.setRudder(rudder);
    }
}
