
package virtualstockexchange.client;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Tlotlanang
 */
public class clientUserLogin implements loginUser{
    //String userName;
    //String password;
    //PasswordField loginPassField;
    //TextField logInNameField;
   
    @Override
    public void userNameLogin(String username, TextField logInNameField) {
        //this.userName = username;
        //this.logInNameField = logInNameField;
        loginNameInputField loginName = new loginNameInputField();
        
            //check if it is empty
            loginName.inputEmpty(username, logInNameField);
            //check the length
            loginName.inputLength(username);
        
        
    }


    @Override
    public void passWordLogin(String passWord, PasswordField loginPassField) {
        //this.password = passWord;
        //this.loginPassField = loginPassField;
        loginPassField loginPass = new loginPassField();
        loginPass.inputEmpty(passWord, loginPassField);
        loginPass.inputLength(passWord);
        
    }
    

    
    
}
