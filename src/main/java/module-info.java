module com.francescxavier.videotogethercliente {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.francescxavier.videotogethercliente to javafx.fxml;
    exports com.francescxavier.videotogethercliente;
    exports com.francescxavier.videotogethercliente.controllers;
    opens com.francescxavier.videotogethercliente.controllers to javafx.fxml;
}