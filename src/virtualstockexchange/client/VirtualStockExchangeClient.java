
package virtualstockexchange.client;

/**
 *
 * @author Tlotlanang
 */
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VirtualStockExchangeClient extends Application {
    filesLoader loadFile = new filesLoader();

    /**
     *
     * @param stage
     */
    @Override
    public void start(Stage stage){
        /*
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("mainCss.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("SMALL BUSINESS STOCK EXCHANGE");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Can't load Main FXML..");
        }
                }

        
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

    } */
        String fxmlStringLink = "main.fxml";
        loadFile.setFXMLFileLink(fxmlStringLink);
        loadFile.getFXMLFileLink();
        loadFile.setMainStage(stage);
        loadFile.getMainStage();
        
    }

    public static void main(String[] args) {
        launch(VirtualStockExchangeClient.class,args);
    }
}
