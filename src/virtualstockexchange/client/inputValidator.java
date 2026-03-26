
package virtualstockexchange.client;

import javafx.scene.control.TextField;


/**
 *
 * @author Tlotlanang
 */
public interface inputValidator {
    
    //Chjeck if the input is empty
    public void inputEmpty(String inputText, TextField inputTextField);
    
    //Check the length of the input
    public void inputLength(String inputText);
    
    //Send input
    public void sendInput(String inputText);
    
     
    
    
}
