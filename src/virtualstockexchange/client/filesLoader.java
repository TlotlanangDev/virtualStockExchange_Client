package virtualstockexchange.client;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author Tlotlanang
 */

 class filesLoader {
    @FXML
    private String fxmlStringLink;
    private Stage stage;
    private Scene scene;
    private Parent root;
    String fxmlTittleLink;
    String cssFileLink;
    
    
    //File tittle to be used when switching scenes.
    public String getFxmlTittleLink() {
        return fxmlTittleLink;
    }

    public void setFxmlTittleLink(String fxmlTittleLink) {
        this.fxmlTittleLink = fxmlTittleLink;
    }
    
    //CSS file name to be used when switching scenes.
    public String getCssFileLink() {
        return cssFileLink;
    }

    public void setCssFileLink(String cssFileLink) {
        this.cssFileLink = cssFileLink;
    }

        //FXML file name to be used when switching scenes.
    public String getFXMLFileLink() {
        return fxmlStringLink;
    }

    public void setFXMLFileLink(String fxmlStringLink) {
        this.fxmlStringLink = fxmlStringLink;
        
        
    }

    public Stage getMainStage() {
        return stage;
    }
    //Main stage setup
    public void setMainStage(Stage stage) {
        this.stage = stage;
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(VirtualStockExchangeClient.class.getResource("main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            String css = this.getClass().getResource("mainCss.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("SMALL BUSINESS STOCK EXCHANGE");
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.println("Failed to load FXML!!");

        }
    }
    //Switch scenes using this method
    public void switchWindow(ActionEvent e){
  
        try {
            
            root = FXMLLoader.load(getClass().getResource(this.fxmlStringLink));
            scene = new Scene(root);
            String css = this.getClass().getResource(this.cssFileLink).toExternalForm();
            scene.getStylesheets().add(css);
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.setTitle(this.fxmlTittleLink);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Cant open portfolio FXML!");
        } 
    }

    

     
}
