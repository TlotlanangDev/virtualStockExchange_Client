
package virtualstockexchange.client;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Tlotlanang
 */
class InputValidator {
    private String userInputText;
    private TextField userInputTextField;
    private PasswordField userInputPassField;
    private TextArea userInputTextArea;
    Errors errors = new Errors();

    public String getUserInputText() {
        return userInputText + userInputTextField;
    }

    void setUserInputText(String userInputText, TextField userInputTextField) {
        this.userInputText = userInputText;
        this.userInputTextField = userInputTextField;
        if(userInputText.isEmpty()){
            errors.setFieldEmptyChecker(userInputText, userInputTextField);
            errors.getFieldEmptyChecker();
            
        }
    }

    public PasswordField getUserInputPassField() {
        return userInputPassField;
    }

    void setUserInputPassField(PasswordField userInputPassField) {
        this.userInputPassField = userInputPassField;
    }

    public String getUserInputTextArea() {
        return userInputText + userInputTextArea;
    }

    void setUserInputTextArea(String userInputText, TextArea userInputTextArea) {
        this.userInputTextArea = userInputTextArea;
        this.userInputText = userInputText;
        if(userInputText.isEmpty()){
            System.out.println("empty");
            //errors.setTextAreaEmptyError(userInputTextArea);
            //errors.getTextAreaEmptyError();
        }
    }
    
    
}

