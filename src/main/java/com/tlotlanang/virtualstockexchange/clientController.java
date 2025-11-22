package com.tlotlanang.virtualstockexchange;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class clientController {


    
    @FXML
    private Tab RegisterTab;
    @FXML
    private TabPane menuTabpane;
    @FXML
    private TabPane RegisterTabpane;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private TextField loginUserName;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

/*Login page, it communicates with the server when the user wants to log in, the server will communicate with the database
to check is user information is available.*/
    public void login(ActionEvent event) {
        String userName = loginUserName.getText();
        String passWord = loginPassword.getText();
        if(userName.isEmpty()){
            System.out.println("Please Enter Username");

        } else if (passWord.isEmpty()) {
            System.out.println("Please Enter Password");
        } else {

            connectionToServer.connectionPorts();
            connectionToServer.connectionStreams();
            try {
                connectionToServer.outputstream.writeUTF(userName);
                connectionToServer.outputstream.writeUTF(passWord);
                String message = connectionToServer.inputstream.readUTF();
                System.out.println(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            connectionToServer.closeresources();
        }

    }

    public void Register(ActionEvent event) {

        if(!RegisterTabpane.isVisible()){

            RegisterTabpane.setVisible(true);
            RegisterTabpane.setManaged(true);

        }else {
            menuTabpane.setVisible(false);
            menuTabpane.setManaged(false);

        }

        //menuTabpane.getSelectionModel().select(RegisterTab);


    }
}
