package virtualstockexchange.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
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

public class mainController  implements Initializable{
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField loginPassField;

    @FXML
    private TextField logInNameField;
    
    @FXML
    private AnchorPane mainrootpane;

    @FXML
    private TextArea regAddress;
    
    @FXML
    private AreaChart<?, ?> marketsChart;

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
    Errors errors = new Errors();
    filesLoader loadFile = new filesLoader();
    //ActionEvent event = new ActionEvent();
    

    @FXML
    void logPassKeyPress(KeyEvent event) {
       
       
    }
    /*
    @FXML
    void logPassMouseClick(MouseEvent event) {
        System.out.println("Mouse Event");
    } */

    @FXML
    void logUserNameKeyPress(KeyEvent event) {
        
    }
    /*
    @FXML
    void logUserNameMouseClick(MouseEvent event) {
        System.out.println("Mouse Event 2");

    } */

    //Executes when the login button is pressed to send data to the server
    @FXML
    void login(ActionEvent event){
        
        //local username and password variable to store user input.
        String userName = logInNameField.getText();
        String passWord = loginPassField.getText();
            
            //send data to database
            user.setLoginInput(userName, passWord, logInNameField, loginPassField, event);
            user.getLoginInput();
               
                       
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

    //register method for register button when clicked
    @FXML
    void registerAccount(ActionEvent event) {
        
       String UserName = regUserName.getText();
       String surName = regSurName.getText();
       String eMail = regEMail.getText();
       String phoneNumber = regPhone.getText();
       String PhysicalAddress = regAddress.getText();
       String Education = regEducation.getText();
       String passWord = regPassWord.getText();
       String ConfirmPassWord = regConfirmPass.getText();
       LocalDate DateofBirth = regDateOfBirth.getValue();
       
       if(UserName.isEmpty()){
            
            errors.setTextFieldEmptyError(regUserName);
            errors.getTextFieldEmptyError();
        }else if(surName.isEmpty()){
            errors.setTextFieldEmptyError(regSurName);
            errors.getTextFieldEmptyError();
        }else if(eMail.isEmpty()){
            errors.setTextFieldEmptyError(regEMail);
            errors.getTextFieldEmptyError();
            errors.setEmailChecker(eMail);
            errors.getEmailChecker();
        }else if(phoneNumber.isEmpty()){
            errors.setTextFieldEmptyError(regPhone);
            errors.getTextFieldEmptyError();
        }else if(PhysicalAddress.isEmpty()){
            errors.setTextAreaEmptyError(regAddress);
            errors.getTextAreaEmptyError();
        }else if(Education.isEmpty()){
            errors.setTextAreaEmptyError(regEducation);
            errors.getTextAreaEmptyError();
        }else if(passWord.isEmpty()){
            errors.setTextFieldEmptyError(regPassWord);
            errors.getTextFieldEmptyError();
        }else if(ConfirmPassWord.isEmpty()){
            errors.setTextFieldEmptyError(regConfirmPass);
            errors.getTextFieldEmptyError();
        }else{
            System.out.println("Perfect");
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        XYChart.Series Series = new XYChart.Series<>();
        Series.getData().add(new XYChart.Data<>("0", 0));
        Series.getData().add(new XYChart.Data<>("1", 2));
        Series.getData().add(new XYChart.Data<>("2", 50));
        Series.getData().add(new XYChart.Data<>("3", 90));
       
        
        XYChart.Series Series0 = new XYChart.Series<>();
        Series0.getData().add(new XYChart.Data<>("0", 0));
        Series0.getData().add(new XYChart.Data<>("1", 25));
        Series0.getData().add(new XYChart.Data<>("2", 67));
        Series0.getData().add(new XYChart.Data<>("3", 100));
        //marketsChart.getData().addAll(Series0);
         marketsChart.getData().addAll(Series, Series0);
        
    }
    
    
    
    

}
