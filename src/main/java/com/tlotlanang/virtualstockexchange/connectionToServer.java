package com.tlotlanang.virtualstockexchange;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectionToServer {
    static Socket socket;
    static DataInputStream inputstream;
    static DataOutputStream outputstream;
    public static void connectionPorts() {
    try
    {
        socket = new Socket("localhost", 9000);


    } catch(
    IOException ex)
    {
        Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static void connectionStreams(){
    try {
        inputstream = new DataInputStream(socket.getInputStream());
        outputstream = new DataOutputStream(socket.getOutputStream());
        //outputstream.writeUTF("Hello Server");
        //String message = inputstream.readUTF();
        //System.out.println(message);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}
    public static void closeresources(){
        try {
            inputstream.close();
            outputstream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
