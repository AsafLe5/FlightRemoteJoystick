package com.flightremotejoystick.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class FGPlayer {

    private String ip;
    private int port;

    private Socket fg;
    private PrintWriter out;

    public void initialize(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        connect();
    }

    public Boolean connect() throws IOException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    //fg = new Socket(ip,port);
                    fg = new Socket("10.0.0.10", 6400);
                    out = new PrintWriter(fg.getOutputStream(), true);
//                    out.print("set /controls/flight/rudder "+1+"\r\n");
//                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
        return true;
    }

    public void setAileron(float aileron) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    out.print("set /controls/flight/aileron " + aileron + "\r\n");
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void setElevator(float elevator) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    out.print("set /controls/flight/elevator " + elevator + "\r\n");
                    out.flush();
                } catch (Exception e) {
                e.printStackTrace();
            }
            }
        };
        thread.start();
    }

    public void setRudder(float rudder) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    out.print("set /controls/flight/rudder "+rudder+"\r\n");
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void setThrottle(float throttle) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    out.print("set /controls/flight/current-engine/throttle "+throttle+"\r\n");
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }




}
