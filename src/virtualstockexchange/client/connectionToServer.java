package virtualstockexchange.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class connectionToServer {
    private Socket socket;
    private DataInputStream inputstream;
    private DataOutputStream outputstream;
    private String outMessage;
    private String inputData;
    void setConnectionPorts(Socket socket) {
        this.socket = socket;
        
    try
    {
        System.out.println("Connecting to ports");
        socket = new Socket("127.0.0.1", 9000);
        System.out.println("Socket Connected..");

    } catch(IOException ex) {
        System.out.println("Socket not connected.");

    }
}

    public Socket getConnectionPorts() {
        return socket;
    }
void setInpuDataStream(DataInputStream inputstream){
    this.inputstream = inputstream;
  
    try {
        inputstream = new DataInputStream(socket.getInputStream());
        

    } catch (IOException e) {
        System.out.println("Connection InputStream Error!.");

    }
}

    public DataInputStream getInputstream() {
        
        return inputstream;
    }

    public DataOutputStream getOutputstream() {
        return outputstream;
    }

void setOutputDataStream(DataOutputStream outputstream){
    this.outputstream = outputstream;
    
    try {
        
        outputstream = new DataOutputStream(socket.getOutputStream());
        //outputstream.writeUTF(outMessage);

    } catch (IOException e) {
        System.out.println("Connection Output stream Error!!.");

    }

}
    
    void setcloseSocket(Socket socket){
        this.socket = socket;
        
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("Cannot Close Socket!");
        }  
    }
    
    void setCloseInputStream(DataInputStream inputstream){
        this.inputstream = inputstream;
        try {
            inputstream.close();
        } catch (IOException ex) {
            System.out.println("Cannot Close InputStream!");
        }
    }
    
    void setCloseOutputStream(DataOutputStream outputstream){
        this.outputstream = outputstream;
        try {
            outputstream.close();
        } catch (IOException ex) {
            System.out.println("Cannot Close OutputStream");
        }
    }
}
