module com.tlotlanang.virtualstockexchange {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.logging;
    requires annotations;
    requires javafx.graphics;

    opens com.tlotlanang.virtualstockexchange to javafx.fxml;
    exports com.tlotlanang.virtualstockexchange;
}