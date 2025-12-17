package com.tlotlanang.virtualstockexchange;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class connectionToServer {
    static Socket socket;
    static DataInputStream inputstream;
    static DataOutputStream outputstream;
    public static void connectionPorts() {
    try
    {
        socket = new Socket("127.0.0.1", 9000);

    } catch(IOException ex) {
        System.out.println("Socket not connected.");

    }
}
public static void connectionStreams(){
    try {
        inputstream = new DataInputStream(socket.getInputStream());
        outputstream = new DataOutputStream(socket.getOutputStream());

    } catch (IOException e) {
        System.out.println("Connection Streams not connected.");

    }

}
    public static void closeresources(){
        try {
            inputstream.close();
            outputstream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Cannot close connection resources.");

        }


    }
}
