module com.example.pp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires java.xml;
    requires com.google.gson;
    // requires javafx.web;

   // requires org.controlsfx.controls;
    //requires com.dlsc.formsfx;
    //requires net.synedra.validatorfx;
    //requires org.kordamp.ikonli.javafx;
   // requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    //requires com.almasb.fxgl.all;
   // requires com.google.gson;
    //requires json.simple;

    opens com.example.pp1 to javafx.fxml;
    exports com.example.pp1;
}