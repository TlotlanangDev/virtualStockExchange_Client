package virtualstockexchange.client;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mainController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private TextField loginUserName;
    
    @FXML
    private AnchorPane mainrootpane;

    @FXML
    private TextArea regAddress;

    @FXML
    private Button regButton;

    @FXML
    private PasswordField regConfirmPass;

    @FXML
    private DatePicker regDateOfBirth;

    @FXML
    private TextField regEMail;

    @FXML
    private TextArea regEducation;

    @FXML
    private PasswordField regPassWord;

    @FXML
    private TextField regPhone;
    
    @FXML
    private AnchorPane portAnchorRoot;

    @FXML
    private TextField regSurName;

    @FXML
    private CheckBox regTerms;

    @FXML
    private TextField regUserName;
    
    @FXML
    private Label logUserWarningLabel;
    User user = new User();
   
    

    @FXML
    void logPassKeyPress(KeyEvent event) {
       
       
    }

    @FXML
    void logPassMouseClick(MouseEvent event) {

    }

    @FXML
    void logUserNameKeyPress(KeyEvent event) {
        
    }

    @FXML
    void logUserNameMouseClick(MouseEvent event) {

    }

    //Executes when the login button is pressed to send data to the server
    @FXML
    void login(ActionEvent event) {
        
        //local username and password variable to store user input.
        String userName = loginUserName.getText();
        String passWord = loginPassword.getText();
        
        //validate input before sending data.
        if(userName.isEmpty()){
            
            user.setTextFieldEmptyError(loginUserName);
            user.getTextFieldEmptyError();
        }else if(passWord.isEmpty()){
            user.setFieldErrorReset(loginUserName);
            user.getFieldErrorReset(); 
            user.setTextFieldEmptyError(loginPassword);
            user.getTextFieldEmptyError();
        }else{
            user.setUserNameAndPass(userName, passWord);
            user.getUserNameAndPass();
            loginUserName.clear();
            loginPassword.clear();
            user.setFieldErrorReset(loginUserName);
            user.getFieldErrorReset();
            user.setFieldErrorReset(loginPassword);
            user.getFieldErrorReset();
            
            
        }  
    }

    @FXML
    void regEmailKeyPress(KeyEvent event) {
        
    }

    @FXML
    void regEmailKeyTyped(KeyEvent event) {

    }

    @FXML
    void regNameKeyPress(KeyEvent event) {

    }

    @FXML
    void regNumberKeyPress(KeyEvent event) {

    }

    @FXML
    void regNumberKeyTyped(KeyEvent event) {

    }

    @FXML
    void registerAccount(ActionEvent event) {
        
        
    }
    
    

}
