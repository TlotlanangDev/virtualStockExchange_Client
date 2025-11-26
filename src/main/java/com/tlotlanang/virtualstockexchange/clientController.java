package com.tlotlanang.virtualstockexchange;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;

public class clientController {


    @FXML
    private Label passwordwarning;
    @FXML
    private Tab overview;
    @FXML
    private Label usernamewarning;
    @FXML
    private VBox loginVbox;
    @FXML
    private Pane Registeranchorpane;
    @FXML
    private TabPane menuTabpane;
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

        //Get username input
        String userName = loginUserName.getText();
        //Get user password input
        String passWord = loginPassword.getText();
        //A condition to ensure both inputs are not empty
        if(userName.isEmpty()){
            usernamewarning.setText("Please Enter Username!!");
            usernamewarning.setTextFill(Color.RED.darker());

        } else if (passWord.isEmpty()) {
            passwordwarning.setText("Please Enter Password!!");
            passwordwarning.setTextFill(Color.RED.darker());
        } else {
            //Connection to server
            connectionToServer.connectionPorts();
            connectionToServer.connectionStreams();
            try {
                //send inputs to server
                connectionToServer.outputstream.writeUTF(userName);
                connectionToServer.outputstream.writeUTF(passWord);
                //output from server
                String message = connectionToServer.inputstream.readUTF();
                System.out.println(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            connectionToServer.closeresources();
        }

    }
    //Register button in the main page when user does not have an account, when clicked,menu page disappears and register page appears
    public void mainregisterButton(ActionEvent event) {
        if(menuTabpane.isVisible()){
            menuTabpane.setVisible(false);
            menuTabpane.setManaged(false);
            Registeranchorpane.setVisible(true);
            Registeranchorpane.setManaged(true);
            loginVbox.setVisible(false);

        }

    }
    //The "Back" button on the register page to allow the user to go back to the main page if they clicked register by mistake
    public void backMainPage(ActionEvent event){

        if(!menuTabpane.isVisible()) {
            menuTabpane.setVisible(true);
            menuTabpane.setManaged(true);
            Registeranchorpane.setVisible(false);
            Registeranchorpane.setManaged(false);
            loginVbox.setVisible(true);
        }
    }
    public void registerAccount(){

    }
}
