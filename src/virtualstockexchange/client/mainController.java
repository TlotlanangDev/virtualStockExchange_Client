package virtualstockexchange.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    
    DataOutputStream outputstream;
    DataInputStream inputstream;
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
    void login(ActionEvent event) throws IOException {
        
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
            /*
            user.getUserNameAndPass();
            user.getUserNameAndPass();
            loginUserName.clear();
            loginPassword.clear();
            user.setFieldErrorReset(loginUserName);
            user.getFieldErrorReset();
            user.setFieldErrorReset(loginPassword);
            user.getFieldErrorReset();
*/
            
            
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
