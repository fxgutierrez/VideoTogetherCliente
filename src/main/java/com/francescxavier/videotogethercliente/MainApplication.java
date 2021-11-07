package com.francescxavier.videotogethercliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;

public class MainApplication extends Application {

    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {

        MainApplication.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Inicie sesión en el servidor.");
        stage.setWidth(270);
        stage.setHeight(360);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}