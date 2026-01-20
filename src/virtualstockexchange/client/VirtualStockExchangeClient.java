/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception{
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


    public static void main(String[] args) {
        launch(VirtualStockExchangeClient.class,args);
    }
}
