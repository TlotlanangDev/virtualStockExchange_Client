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
    private String urlLink;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
        //urlLink = "main.fxml";
        
    }

    public Stage getMainStage() {
        return stage;
    }

    public void setMainStage(Stage stage) {
        this.stage = stage;
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(VirtualStockExchangeClient.class.getResource(this.urlLink));
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

    public Stage getSwitchStage() {
        return stage;
    }

    public void setSwitchStage(Stage stage) {
        try {
            //Parent root = new Parent();
            root = FXMLLoader.load(getClass().getResource(this.urlLink));
            ActionEvent e = new ActionEvent();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
             
            scene = new Scene(root);
            String css = this.getClass().getResource("mainCss.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("PORTFOLIO");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Cannot load portfolio...");
        }
        
    }

    public Scene getSwitchScene() {
        return scene;
    }

    public void setSwitchScene(Scene scene) {
        this.scene = scene;
        scene = new Scene(root);
        String css = this.getClass().getResource("mainCss.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        
    }

    public Parent getSwitchRoot() {
        return root;
    }

    public void setSwitchRoot(Parent root) {
        try {
            this.root = root;
            root = FXMLLoader.load(getClass().getResource(this.urlLink));
        } catch (IOException ex) {
            System.out.println("Root does not exist!!");
        }
    }
    
    

    
    
    
    
    
    
}
