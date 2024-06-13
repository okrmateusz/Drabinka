module pl.projectmvc.drabinka {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.projectmvc.drabinka to javafx.fxml;
    exports pl.projectmvc.drabinka;
    exports pl.projectmvc.drabinka.model;
    opens pl.projectmvc.drabinka.model to javafx.fxml;
    exports pl.projectmvc.drabinka.controller;
    opens pl.projectmvc.drabinka.controller to javafx.fxml;
    exports pl.projectmvc.drabinka.view;
    opens pl.projectmvc.drabinka.view to javafx.fxml;
}