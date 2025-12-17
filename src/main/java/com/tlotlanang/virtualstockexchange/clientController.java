package com.tlotlanang.virtualstockexchange;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

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
    int phoneNumber;

/*Login page, it communicates with the server when the user wants to log in, the server will communicate with the database
to check is user information is available.*/

    public void login() {
        //resetRegistrationForm();
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
                //reset username labels from red warning because the textfield is now filed.
                usernamewarning.setText("Username");
                usernamewarning.setTextFill(Color.WHITE);

                //warning for empty password textfield
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

    //Reset registration textfields and labels
    public void resetRegistrationForm(){
        registerName.clear();
        registerConfPassW.clear();
        registerPhone.clear();
        registerPassword.clear();
        registerEmail.clear();
        registerSurName.clear();
        registerAddress.clear();
        //change warning labels from red to white when inputs are filled
        regNameWarning.setText("UserName");
        regNameWarning.setTextFill(Color.WHITE);
        regSurnameWarn.setText("Surname");
        regSurnameWarn.setTextFill(Color.WHITE);
        regemailwarning.setText("Email");
        regemailwarning.setTextFill(Color.WHITE);
    }

    //To reset login inputs textfields and labels
    public void resetLogin(){
        loginUserName.clear();
        loginPassword.clear();
        usernamewarning.setText("Username");
        usernamewarning.setTextFill(Color.WHITE);
        passwordwarning.setText("Password");
        passwordwarning.setTextFill(Color.WHITE);
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
        //String dateOfBirth = registerDateofBirth.toString();
        //Pattern datePatten = Pattern.compile("yyyy-MM-dd");




        // Condition to validate null inputs.
         if(userName.isEmpty()){
            regNameWarning.setText("Enter Username!!");
            regNameWarning.setTextFill(Color.RED.darker());
            return;
         } else if (userSurname.isEmpty()) {
            regNameWarning.setText("UserName");
            regNameWarning.setTextFill(Color.WHITE);
            regSurnameWarn.setText("Enter Surname!!");
            regSurnameWarn.setTextFill(Color.RED.darker());
             return;
        } else if (emailAddress.isEmpty()) {
            regSurnameWarn.setText("Surname");
            regSurnameWarn.setTextFill(Color.WHITE);
            regemailwarning.setText("Enter Email!!");
            regemailwarning.setTextFill(Color.RED.darker());
             return;
        } else if (!emailAddress.contains("@") || !emailAddress.contains(".")) {
             regSurnameWarn.setText("Surname");
             regSurnameWarn.setTextFill(Color.WHITE);
             regemailwarning.setText("Enter Correct Email!!");
             regemailwarning.setTextFill(Color.RED.darker());
             return;
         } else if (parseInt(String.valueOf(registerPhone.getLength())) != 10) {
             regemailwarning.setText("Email");
             regemailwarning.setTextFill(Color.WHITE);
             regphoneNumWarning.setText("Enter a 10 digit Number!");
             regphoneNumWarning.setTextFill(Color.RED.darker());
             return;
         }
        //catches interger exception to deal with formatting if input is not an integer, or if it is blank
        try {
            phoneNumber = parseInt(registerPhone.getText());

        }catch (NumberFormatException e){
            regemailwarning.setText("Email");
            regemailwarning.setTextFill(Color.WHITE);
            regphoneNumWarning.setText("Phone not correct!");
            regphoneNumWarning.setTextFill(Color.RED.darker());
            return;
        }catch (NullPointerException e){
            regemailwarning.setText("Email");
            regemailwarning.setTextFill(Color.WHITE);
            regphoneNumWarning.setText("Enter Numbers");
            regphoneNumWarning.setTextFill(Color.RED.darker());
            return;
        } catch (Exception e){
            regemailwarning.setText("Email");
            regemailwarning.setTextFill(Color.WHITE);
            regphoneNumWarning.setText("Phone Numbers!");
            regphoneNumWarning.setTextFill(Color.RED.darker());
            return;
        }
         if (physicalAddress.isEmpty()) {
            regphoneNumWarning.setText("Phone Numbers");
            regphoneNumWarning.setTextFill(Color.WHITE);
            regaddWarning.setText("Enter Address!!");
            regaddWarning.setTextFill(Color.RED.darker());
             return;
        } else if (passWord.isEmpty()) {
            regPasswordWarn.setText("Enter Password!!");
            regPasswordWarn.setTextFill(Color.RED.darker());
             return;
        } else if (passWord.length() < 5) {
             regphoneNumWarning.setText("Phone Numbers");
             regphoneNumWarning.setTextFill(Color.WHITE);
             regPasswordWarn.setText("Weak Password!!");
             regPasswordWarn.setTextFill(Color.RED.darker());
             return;

         } else if (confirmPass.isEmpty() || !passWord.equals(confirmPass)) {
            regPasswordWarn.setText("Password");
            regPasswordWarn.setTextFill(Color.WHITE);
            regconfPassWarn.setText("Password not a Match!");
            regconfPassWarn.setTextFill(Color.RED.darker());
             return;
         } else if (dateOfBirth == null) {
             regconfPassWarn.setText("Confirm Password");
             regconfPassWarn.setTextFill(Color.WHITE);
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
                System.out.println("Unable to send initial output Stream.");

            }

        }
         //reset registration inputs to empty
        resetRegistrationForm();
    }
    //connection to server method
    public void connection(){
        try {
            connectionToServer.connectionPorts();
            connectionToServer.connectionStreams();
        } catch (Exception e) {
            System.out.println("No connection to Server.");

        }
    }

}
