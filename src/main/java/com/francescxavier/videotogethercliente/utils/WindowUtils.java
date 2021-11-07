package com.francescxavier.videotogethercliente.utils;

import com.francescxavier.videotogethercliente.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class WindowUtils {



    public static void switchScene(String fxmlFile){
        Parent newRoot = null;
        try {
            newRoot = FXMLLoader.load(MainApplication.class.getResource(fxmlFile),null, new JavaFXBuilderFactory());
            MainApplication.stage.setScene(new Scene(newRoot));
            MainApplication.stage.sizeToScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
