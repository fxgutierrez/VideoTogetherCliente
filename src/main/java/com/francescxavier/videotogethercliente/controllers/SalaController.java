package com.francescxavier.videotogethercliente.controllers;

import com.francescxavier.videotogethercliente.Sala;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class SalaController implements Initializable {
    public TextArea txtChat;
    public ListView listUsuarios;
    Sala sala = Sala.CurrentSala;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (String usuario : Sala.CurrentSala.listaUsuarios){
            listUsuarios.getItems().add(usuario);
        }
        System.out.println(sala.getId());

    }
}
