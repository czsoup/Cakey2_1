module com.example.cakey {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;

    opens com.example.cakey to javafx.fxml;
    exports com.example.cakey;
    opens com.example.cakey.controleur to javafx.fxml;
    exports com.example.cakey.controleur;
}