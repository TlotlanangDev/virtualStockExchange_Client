/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtualstockexchange.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.scene.control.TextField;



/**
 *
 * @author Tlotlanang
 */

class User{
    private String userName;
    private String passWord;
    private TextField textFieldError;
    private TextField textFieldErrorReset;
    
    connectionToServer connection = new connectionToServer();

    
    
    //get userName
public String getUserNameAndPass() {
        return userName + passWord;
    }

    public TextField getTextFieldEmptyError() {
        return textFieldError;
    }
    
    public TextField getFieldErrorReset(){
        return textFieldErrorReset;
    }
    
    //Point to the textfield when it is empty there
    void setTextFieldEmptyError(TextField textFieldError) {
        this.textFieldError = textFieldError;
        
            textFieldError.requestFocus();
            textFieldError.getStyleClass().add("textfield-error"); 
    }
    
    void setFieldErrorReset(TextField textFieldErrorReset){
         this.textFieldErrorReset = textFieldErrorReset;
         textFieldErrorReset.getStyleClass().add("textfield-error-reverse");
    }

    void setUserNameAndPass(String userName, String passWord) throws IOException{
        
        this.userName = userName;
        this.passWord = passWord;
        
        
        String initialMessage = "Login";
        //String inputData;
        Socket socket  = new Socket("127.0.0.1", 9000);
        DataOutputStream outputstream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputstream = new DataInputStream(socket.getInputStream());
        
        connection.setConnectionPorts(socket);
        connection.getConnectionPorts();
        connection.setOutputDataStream(outputstream);
        connection.getOutputstream().writeUTF(initialMessage);
        connection.setInpuDataStream(inputstream);
        String serverInitialResponse = connection.getInputstream().readUTF();
        /*
        connection.setcloseSocket(socket);
        connection.getConnectionPorts();
        connection.setCloseInputStream(inputstream);
        connection.getInputstream();
        connection.setCloseOutputStream(outputstream);
        connection.getOutputstream();
        */
        System.out.println("Hey server: " + serverInitialResponse);
        
        
        if(serverInitialResponse.equals(initialMessage)){
            System.out.println("Matches");
        
            //connection.setConnectionPorts(socket);
            //connection.getConnectionPorts();
            connection.setOutputDataStream(outputstream);
            //connection.setOutputDataStream(outputstream);
            connection.getOutputstream().writeUTF(userName);
            connection.getOutputstream().writeUTF(passWord);
           
            
            connection.setInpuDataStream(inputstream);
            String loginDetailResponse = connection.getInputstream().readUTF();
            System.out.println(loginDetailResponse);
            
            connection.setcloseSocket(socket);
            connection.getConnectionPorts();
            connection.setCloseInputStream(inputstream);
            connection.getInputstream();
            connection.setCloseOutputStream(outputstream);
            connection.getOutputstream();
            
        
        }else{
            System.out.println("Login response error!!");
        }
        
        
        
        
    }

    
    
   
}

    
