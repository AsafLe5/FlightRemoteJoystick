package com.flightremotejoystick.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * The flight-gear model
 */
public class FGPlayer {

    private String ip;
    private int port;

    private Socket fg;
    private PrintWriter out;

    /**
     * initialize the connection
     * @param ip string - computer ip
     * @param port int parameter
     * @throws IOException if failed
     */
    public void initialize(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        connect();
    }

    /**
     * connect and run the program
     * @throws IOException if failed
     */
    public void connect() throws IOException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    fg = new Socket(ip,port);
                    out = new PrintWriter(fg.getOutputStream(), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    /**
     * function that set the aileron of the airplane
     * @param aileron float number from -1 to 1
     */
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

    /**
     * function that set the elevator of the airplane
     * @param elevator float number from -1 to 1
     */
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

    /**
     * function that set the elevator of the airplane
     * @param rudder float number from -1 to 1
     */
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

    /**
     * function that set the throttle of the airplane
     * @param throttle float number from -1 to 1
     */
    public void setThrottle(float throttle) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    out.print("set /controls/engines/current-engine/throttle "+throttle+"\r\n");
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
