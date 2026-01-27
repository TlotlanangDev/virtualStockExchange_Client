/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtualstockexchange.client;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Tlotlanang
 */
public class Errors {
    
    private TextField textFieldError;
    private TextField textFieldErrorReset;
    private String textFieldEmpty;
    private TextArea textAreaError;
    private String phoneNumber;
    private String Email;
    
    //Point to the textfield when it is empty there
    void setTextFieldEmptyError(TextField textFieldError) {
        this.textFieldError = textFieldError;
        
            textFieldError.requestFocus();
            textFieldError.getStyleClass().add("textfield-error"); 
            
    }
    
    public void setTextAreaEmptyError(TextArea textAreaError) {
        
        this.textAreaError = textAreaError;
        textAreaError.requestFocus();
        textFieldError.getStyleClass().add("text-area-error"); 
    }
    
    void setFieldErrorReset(TextField textFieldErrorReset){
         this.textFieldErrorReset = textFieldErrorReset;
         textFieldErrorReset.getStyleClass().add("textfield-error-reverse");
    }
    
    void setEmailChecker(String Email){
        this.Email = Email;
        if(!Email.contains("@") | !Email.contains(".")){
            System.out.println("Invalid E mail Address");
        }
    
    }
    
    void setFieldEmptyChecker(String textFieldEmpty){
        this.textFieldEmpty = textFieldEmpty;
        while(textFieldEmpty.isEmpty()){
            System.out.println("Null null");
            return;
        }
        
    }
    public String getFieldEmptyChecker(){
        return textFieldEmpty;
    }
    public String getEmailChecker(){
        return Email;
    }
    
    public TextField getTextFieldEmptyError() {
        return textFieldError;
    }
    
    public TextField getFieldErrorReset(){
        return textFieldErrorReset;
    }
    
    public TextArea getTextAreaEmptyError() {
        return textAreaError;
    }
    
}
