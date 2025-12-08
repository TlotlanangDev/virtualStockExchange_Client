package com.tlotlanang.virtualstockexchange;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.time.LocalDate;

public class clientController {


    @FXML
    private CheckBox termsandConditions;
    @FXML
    private Label welcomemesage;
    @FXML
    private Label regphoneNumWarning;
    @FXML
    private Label regemailwarning;
    @FXML
    private Label regNameWarning;
    @FXML
    private Label regSurnameWarn;
    @FXML
    private Label regaddWarning;
    @FXML
    private Label regPasswordWarn;
    @FXML
    private Label regconfPassWarn;
    @FXML
    private Label regbirthDateWarn;
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
    private Button registerButton;
    int phoneNumber;

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
        registerName.setText(null);

    }
    public void registerAccount(){

        String userName = registerName.getText();
        String userSurname = registerSurName.getText();
        String emailAddress = registerEmail.getText();
        String passWord = registerPassword.getText();
        String confirmPass = registerConfPassW.getText();
        String physicalAddress = registerAddress.getText();
        LocalDate dateOfBirth = registerDateofBirth.getValue();
        //catches interger exception to deal with formatting if input not an integer or is blank

        try {
            phoneNumber = Integer.parseInt(registerPhone.getText());

        }catch (NumberFormatException e){
            regphoneNumWarning.setText("Phone Numbers!");
            regphoneNumWarning.setTextFill(Color.RED.darker());
        }catch (Exception e){
            System.out.println(e);
        }


        //A condition to ensure both inputs are not empty
         if(userName.isEmpty()){
            regNameWarning.setText("Enter Username!!");
            regNameWarning.setTextFill(Color.RED.darker());
        } else if (userSurname.isEmpty()) {
            regSurnameWarn.setText("Enter Surname!!");
            regSurnameWarn.setTextFill(Color.RED.darker());
        } else if (emailAddress.isEmpty() || !emailAddress.contains("@") || !emailAddress.contains(".")) {
            regemailwarning.setText("Enter Email!!");
            regemailwarning.setTextFill(Color.RED.darker());
        } else if (physicalAddress.isEmpty()) {
            regaddWarning.setText("Enter Address!!");
            regaddWarning.setTextFill(Color.RED.darker());
        } else if (passWord.isEmpty()) {
            regPasswordWarn.setText("Enter Password!!");
            regPasswordWarn.setTextFill(Color.RED.darker());
        }  else if (confirmPass.isEmpty()) {
            regconfPassWarn.setText("Confirm Password!!");
            regconfPassWarn.setTextFill(Color.RED.darker());
        } else if (dateOfBirth.equals(null)) {

                 regbirthDateWarn.setText("Enter Date Of Birth!!");
                 regbirthDateWarn.setTextFill(Color.RED.darker());
        } else if (!termsandConditions.isSelected()) {
            termsandConditions.setText("Terms and Conditions");
            termsandConditions.setTextFill(Color.RED.darker());
        } else {
            connectionToServer.connectionPorts();
            connectionToServer.connectionStreams();
            try {

                //send register message to server to inform server to use register method
                connectionToServer.outputstream.writeUTF("Register");
                //return request from server to confirm if its register
                String returnrequest = connectionToServer.inputstream.readUTF();


                String returnLogin = "Login";
                String returnRegister = "Register";
                //if return request is login, its an error, if its register, the send inputs from textfields to the server

                if (returnrequest.equals(returnLogin)) {

                    System.out.println("Error!!!");
                } else if (returnrequest.equals(returnRegister)) {
                    connectionToServer.outputstream.writeUTF(userName);
                    connectionToServer.outputstream.writeUTF(userSurname);
                    connectionToServer.outputstream.writeUTF(passWord);
                    connectionToServer.outputstream.writeUTF(String.valueOf(dateOfBirth));
                    connectionToServer.outputstream.writeUTF(emailAddress);
                    connectionToServer.outputstream.writeUTF(String.valueOf(phoneNumber));
                    connectionToServer.outputstream.writeUTF(physicalAddress);

                    String regiconfirm = connectionToServer.inputstream.readUTF();
                    System.out.println(regiconfirm);
                } else {
                    System.out.println("Error!!!!");
                }
                //close sockets
                connectionToServer.closeresources();

            } catch (IOException e) {
                throw new RuntimeException(e);

            }

        }
    }

}
