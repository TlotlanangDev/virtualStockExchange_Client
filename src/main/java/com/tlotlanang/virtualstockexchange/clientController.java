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
    private TextArea registerAddress;
    @FXML
    private Label regNameWarning, regSurnameWarn, regemailwarning, regphoneNumWarning, regaddWarning, regPasswordWarn,
            regconfPassWarn, regbirthDateWarn, passwordwarning, usernamewarning;
    @FXML
    private DatePicker registerDateofBirth;
    @FXML
    private TextField registerName, registerSurName, registerEmail, registerPhone, loginUserName;
    @FXML
    private PasswordField registerPassword, registerConfPassW, loginPassword;
    @FXML
    private Tab overview;
    @FXML
    private VBox loginVbox;
    @FXML
    private Pane Registeranchorpane;
    @FXML
    private TabPane menuTabpane;
    @FXML
    private Button registerButton;
    int phoneNumber;

/*Login page, it communicates with the server when the user wants to log in, the server will communicate with the database
to check is user information is available.*/

    public void login() {

            //Get username input
            String userName = loginUserName.getText();
            //Get user password input
            String passWord = loginPassword.getText();

            //A condition to ensure both login inputs are not empty
            if (userName.isEmpty()) {
                usernamewarning.setText("Please Enter Username!!");
                usernamewarning.setTextFill(Color.RED.darker());
                return;
           } else if (passWord.isEmpty()) {
                passwordwarning.setText("Please Enter Password!!");
                passwordwarning.setTextFill(Color.RED.darker());
                return;
            }else {

                //Connection to server
                connection();

                try {
                    //send initial output to inform server this is login button
                    connectionToServer.outputstream.writeUTF("Login");

                    //return input from server
                    String returnrequest = connectionToServer.inputstream.readUTF();
                    String returnLogin = "Login";

                    /*if initial message of login is true, send the two inputs to server to check if they are available in
                     the database.*/
                    if (returnrequest.equals(returnLogin)) {
                        connectionToServer.outputstream.writeUTF(userName);
                        connectionToServer.outputstream.writeUTF(passWord);
                        String loginMessage = connectionToServer.inputstream.readUTF();
                        System.out.println(loginMessage);
                    } else {
                        System.out.println("Return from Server not Login");
                        return;
                    }
                    //close connections to server
                    connectionToServer.closeresources();

                } catch (IOException | NullPointerException e) {

                    System.out.println("Initial output to server Error!!!");
                    return;

                }

            }
            //reset input textfields to null after login button is clicked.
        resetLogin();
    }
    //Register button in the main page, when clicked,menu page disappears and register page appears
    public void mainregisterButton() {
        if(menuTabpane.isVisible()){
            menuTabpane.setVisible(false);
            menuTabpane.setManaged(false);
            Registeranchorpane.setVisible(true);
            Registeranchorpane.setManaged(true);
            loginVbox.setVisible(false);

        }
        resetLogin();

    }
    /*The "Back" button on the register page to allow the user to go back to the main page if they clicked register by mistake
     when clicked, register page disappears and menu appears.*/
    public void backMainPage(){

        if(!menuTabpane.isVisible()) {
            menuTabpane.setVisible(true);
            menuTabpane.setManaged(true);
            Registeranchorpane.setVisible(false);
            Registeranchorpane.setManaged(false);
            loginVbox.setVisible(true);
        }
        //resets the registration input fields to null.
        resetRegistrationForm();
    }

    //Reset registration textfields
    public void resetRegistrationForm(){
        registerName.setText(null);
        registerConfPassW.setText(null);
        registerPhone.setText(null);
        registerPassword.setText(null);
        registerEmail.setText(null);
        registerSurName.setText(null);
        registerAddress.setText(null);
    }

    //To reset login inputs textfields
    public void resetLogin(){
        loginUserName.setText(null);
        loginPassword.setText(null);
    }
    /* */
    public void registerAccount(){
        //All the input fields with local variables.
        String userName = registerName.getText();
        String userSurname = registerSurName.getText();
        String emailAddress = registerEmail.getText();
        String passWord = registerPassword.getText();
        String confirmPass = registerConfPassW.getText();
        String physicalAddress = registerAddress.getText();
        LocalDate dateOfBirth = registerDateofBirth.getValue();

        //catches interger exception to deal with formatting if input is not an integer, or it is blank
        try {
            phoneNumber = Integer.parseInt(registerPhone.getText());

        }catch (NumberFormatException e){
            regphoneNumWarning.setText("Enter correct Phone Numbers!");
            regphoneNumWarning.setTextFill(Color.RED.darker());
            return;
        }catch (Exception e){
            regphoneNumWarning.setText("Phone Numbers!");
            regphoneNumWarning.setTextFill(Color.RED.darker());
            return;
        }

        // Condition to validate inputs.
         if(userName.isEmpty()){
            regNameWarning.setText("Enter Username!!");
            regNameWarning.setTextFill(Color.RED.darker());
            return;
        } else if (userSurname.isEmpty()) {
            regSurnameWarn.setText("Enter Surname!!");
            regSurnameWarn.setTextFill(Color.RED.darker());
             return;
        } else if (emailAddress.isEmpty()) {
            regemailwarning.setText("Enter Email!!");
            regemailwarning.setTextFill(Color.RED.darker());
             return;
        } else if (!emailAddress.contains("@") || !emailAddress.contains(".")) {
             regemailwarning.setText("Enter Correct Email!!");
             regemailwarning.setTextFill(Color.RED.darker());

         } else if (physicalAddress.isEmpty()) {
            regaddWarning.setText("Enter Address!!");
            regaddWarning.setTextFill(Color.RED.darker());
             return;
        } else if (passWord.isEmpty()) {
            regPasswordWarn.setText("Enter Password!!");
            regPasswordWarn.setTextFill(Color.RED.darker());
             return;
        }  else if (confirmPass.isEmpty()) {
            regconfPassWarn.setText("Confirm Password!!");
            regconfPassWarn.setTextFill(Color.RED.darker());
             return;
        } else if (dateOfBirth.equals(null)) {

             regbirthDateWarn.setText("Enter Date Of Birth!!");
             regbirthDateWarn.setTextFill(Color.RED.darker());
             return;
        } else if (!termsandConditions.isSelected()) {
            termsandConditions.setText("Terms and Conditions");
            termsandConditions.setTextFill(Color.RED.darker());
             return;
        } else {
             //Connection to server
             connection();

            try {
                //send register message to server to inform server to use register method
                connectionToServer.outputstream.writeUTF("Register");
                //return request from server to confirm if its register
                String returnrequest = connectionToServer.inputstream.readUTF();
                String returnRegister = "Register";
                //if return request is login, it's an error, if its register, the send inputs from textfields to the server
                if (returnrequest.equals(returnRegister)) {
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
                    System.out.println("Initial return message is not Register.");
                }
                //close sockets
                connectionToServer.closeresources();

            } catch (IOException e) {
                throw new RuntimeException(e);

            }

        }
        resetRegistrationForm();
    }
    public void connection(){
        try {
            connectionToServer.connectionPorts();
            connectionToServer.connectionStreams();
        } catch (Exception e) {
            System.out.println("No connection to Server.");
            return;
        }
    }

}
