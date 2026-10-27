module cl.duoc.ticketpro {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens cl.duoc.ticketpro to javafx.fxml;
    exports cl.duoc.ticketpro;
    exports cl.duoc.ticketpro.controller;
    opens cl.duoc.ticketpro.controller to javafx.fxml;
}