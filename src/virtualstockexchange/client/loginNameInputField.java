
package virtualstockexchange.client;

import javafx.scene.control.TextField;

/**
 *
 * @author Tlotlanang
 */
public class loginNameInputField implements inputValidator{

    @Override
    public void inputEmpty(String inputText, TextField inputTextField) {
        inputText = inputTextField.getText();
        while(inputText.isEmpty()){
            System.out.println("Enter Username...");
            return;
        }
        
        
    }

    @Override
    public void inputLength(String inputText) {
        while(inputText.length() < 5){
            System.out.println("Name too short");
            return;
        }
        sendInput(inputText);
    }

    @Override
    public void sendInput(String inputText) {
        System.out.println("Send input: " + inputText);
    }

    
   
           
}
