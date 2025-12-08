package com.tlotlanang.virtualstockexchange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class clientApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(clientApplication.class.getResource("clientGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 750);
        stage.setTitle("SMALL BUSINESS STOCK EXCHANGE");
        stage.setScene(scene);
        stage.show();
    }


}
