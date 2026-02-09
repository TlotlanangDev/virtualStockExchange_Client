package virtualstockexchange.client;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mainController  implements Initializable{
  
    @FXML
    private Button loginButton, regButton;

    @FXML
    private PasswordField loginPassField, regConfirmPassField, regPassWordField;

    @FXML
    private TextField logInNameField, regEMailField, regPhoneField, regSurNameField, regUserNameField;
    
    @FXML
    private AnchorPane mainrootpane, portAnchorRoot;

    @FXML
    private TextArea regAddressArea, regEducationArea;
    
    @FXML
    private AreaChart<?, ?> marketsChart;

    @FXML
    private DatePicker regDateOfBirthField;
    
    @FXML
    private Label logUserWarningLabel;
    
    @FXML
    private CheckBox businessCheckBox, investorLogInCheck, regTerms;

    
    
    User user = new User();
    Errors errors = new Errors();
    filesLoader loadFile = new filesLoader();
    InputValidator validateInput = new InputValidator();
    

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
        
        validateInput.setUserInputText(userName, logInNameField);
        validateInput.setUserInputText(passWord, loginPassField);
        validateInput.getUserInputText();
        //Make sure that you only send info to the database when all inputs have data
        if(userName.isEmpty() | passWord.isEmpty()){
            System.out.println("Not all fields are field label error  or pop up message..");
        }else{
            user.setLoginInput(userName, passWord, event);
            user.getLoginInput();
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

    //register method for register button when clicked
    @FXML
    void registerAccount(ActionEvent event) {
       
       String UserName = regUserNameField.getText();
       String surName = regSurNameField.getText();
       String eMail = regEMailField.getText();
       String phoneNumber = regPhoneField.getText();
       //String PhysicalAddress = regAddressArea.getText();
       //String Education = regEducationArea.getText();
       String passWord = regPassWordField.getText();
       String ConfirmPassWord = regConfirmPassField.getText();
       //LocalDate DateofBirth = regDateOfBirthField.getValue();
       
       validateInput.setUserInputText(UserName, regUserNameField);
       validateInput.setUserInputText(surName, regSurNameField);
       validateInput.setUserInputText(eMail, regEMailField);
       validateInput.setUserInputText(phoneNumber, regPhoneField);
       //validateInput.setUserInputTextArea(PhysicalAddress, regAddressArea);
       //validateInput.getUserInputTextArea();
       validateInput.setUserInputText(passWord, regPassWordField);
       validateInput.setUserInputText(ConfirmPassWord, regConfirmPassField); 
       validateInput.getUserInputText();
       
       
       
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
