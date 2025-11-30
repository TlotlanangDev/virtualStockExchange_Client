package com.tlotlanang.virtualstockexchange;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clientController {


    @FXML
    private DatePicker registerDateofBirth;
    @FXML
    private TextField registerName;
    @FXML
    private TextField registerSurName;
    @FXML
    private PasswordField registerPassword;
    @FXML
    private TextField registerEmail;
    @FXML
    private TextField registerPhone;
    @FXML
    private TextArea registerAddress;
    @FXML
    private PasswordField registerConfPassW;
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
    //static Socket socket;
    //static DataInputStream inputstream;
    //static DataOutputStream outputstream;
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
        }
        else {
            //Connection to server
            connectionToServer.connectionPorts();
            connectionToServer.connectionStreams();
            try {

                //send inputs to server
                connectionToServer.outputstream.writeUTF("Login");
                //output from server
                String returnrequest = connectionToServer.inputstream.readUTF();
                String returnLogin = "Login";
                String returnRegister = "Register";
                if (returnrequest.equals(returnLogin)) {
                    connectionToServer.outputstream.writeUTF(userName);
                    connectionToServer.outputstream.writeUTF(passWord);
                    String loginMessage = connectionToServer.inputstream.readUTF();
                    System.out.println(loginMessage);
                } else if (returnrequest.equals(returnRegister)) {
                    System.out.println("Register method");
                } else {
                    System.out.println("Error!!!!");
                }

                connectionToServer.closeresources();

            } catch (IOException e) {
                throw new RuntimeException(e);

            }
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
        connectionToServer.connectionPorts();
        connectionToServer.connectionStreams();
        try {

            //send inputs to server
            connectionToServer.outputstream.writeUTF("Register");
            //output from server
            String returnrequest = connectionToServer.inputstream.readUTF();
            String confirmRequest = connectionToServer.inputstream.readUTF();
            String returnLogin = "Login";
            String returnRegister = "Register";
            if (returnrequest.equals(returnLogin)) {

                System.out.println("Error!!!");
            } else if (returnrequest.equals(returnRegister)) {
                System.out.println(confirmRequest);
            } else {
                System.out.println("Error!!!!");
            }

            connectionToServer.closeresources();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }


    }

}
