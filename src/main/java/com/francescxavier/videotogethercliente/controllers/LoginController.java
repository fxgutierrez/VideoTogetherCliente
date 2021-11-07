package com.francescxavier.videotogethercliente.controllers;

import com.francescxavier.videotogethercliente.MainApplication;
import com.francescxavier.videotogethercliente.User;
import com.francescxavier.videotogethercliente.enums.ResponseType;
import com.francescxavier.videotogethercliente.utils.NetUtils;
import com.francescxavier.videotogethercliente.utils.WindowUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Label lblStatus;
    public TextField txtUser;
    public TextField txtPassword;

    public void btnLogin_Click(ActionEvent actionEvent) {

        lblStatus.setText("Conectándose al servidor...");
        String nombreUsuario = txtUser.getText();
        String contrasenya = txtPassword.getText();

        ResponseType responseType = NetUtils.login(nombreUsuario,contrasenya);

        switch (responseType){
            case OK:
                lblStatus.setText("¡Usuario logueado exitosamente! ");
                WindowUtils.switchScene("hub-view.fxml");
                break;
            case ALREADYLOGED:
                lblStatus.setText("Ha ocurrido un error al iniciar sesión.\nEl usuario ya ha iniciado sesión en el servidor.");

                break;
            case NO:
                lblStatus.setText("Ha ocurrido un error al iniciar sesión.\nRevise sus credenciales e inténtelo otra vez.");

                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblStatus.setText("");
    }
}