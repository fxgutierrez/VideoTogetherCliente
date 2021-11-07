package com.francescxavier.videotogethercliente.controllers;

import com.francescxavier.videotogethercliente.MainApplication;
import com.francescxavier.videotogethercliente.Sala;
import com.francescxavier.videotogethercliente.utils.NetUtils;
import com.francescxavier.videotogethercliente.utils.WindowUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HubController {
    public Button btnJoinSala;
    public TextField txtCodigoSala;

    public void btnJoinSala_Click(ActionEvent actionEvent) {
        Sala sala = NetUtils.joinSala(txtCodigoSala.getText());

        if (sala != null){
            Sala.CurrentSala = sala;
            WindowUtils.switchScene("sala-view.fxml");
        } else {

        }
    }

    public void btnCrearSala_Click(ActionEvent actionEvent) {
        Sala sala = NetUtils.createSala();
        Sala.CurrentSala = sala;

        if (sala != null){
            WindowUtils.switchScene("sala-view.fxml");
        }


    }
}
