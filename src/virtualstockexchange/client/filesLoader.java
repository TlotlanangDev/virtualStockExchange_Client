package virtualstockexchange.client;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Tlotlanang
 */

 class filesLoader {
    @FXML
    private AnchorPane mainrootpane;

    public AnchorPane getMainrootpane() {
        return mainrootpane;
    }

     void setMainrootpane(AnchorPane mainrootpane) {
        this.mainrootpane = mainrootpane;
        try {
                //System.out.println(userName + " " + password);
                AnchorPane pane;
            pane = FXMLLoader.load(getClass().getResource("portfolio.fxml"));
                mainrootpane.getChildren().setAll(pane);
            } catch (IOException ex) {
                System.out.println("Failed to load Portfolio...");
                
            }
    }
    
    
    
    
}
