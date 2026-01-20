/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtualstockexchange.client;


import javafx.scene.control.TextField;



/**
 *
 * @author Tlotlanang
 */

class User {
    private String userName;
    private String passWord;
    private TextField textFieldError;
    private TextField textFieldErrorReset;
    
    filesLoader filesloader = new filesLoader();

    
    
    //get userName
public String getUserNameAndPass() {
        return userName + passWord;
    }

    public TextField getTextFieldEmptyError() {
        return textFieldError;
    }
    
    public TextField getFieldErrorReset(){
        return textFieldErrorReset;
    }
    
    //Point to the textfield when it is empty there
    void setTextFieldEmptyError(TextField textFieldError) {
        this.textFieldError = textFieldError;
        
            textFieldError.requestFocus();
            textFieldError.getStyleClass().add("textfield-error"); 
    }
    
    void setFieldErrorReset(TextField textFieldErrorReset){
         this.textFieldErrorReset = textFieldErrorReset;
         textFieldErrorReset.getStyleClass().add("textfield-error-reverse");
    }

    void setUserNameAndPass(String userName, String passWord) {
        String myName = "Tlotlanang";
        String password = "password";
        this.userName = userName;
        this.passWord = passWord;
        if(!userName.equals(myName)){
            
            System.out.println("Enter Correct Username!");
           
            
        }else if(!passWord.equals(password)){
            
            System.out.println("Enter Correct PassWord!");   
        }else{
            System.out.println(userName + " " + passWord);
        }
    }
    
   
}

    
