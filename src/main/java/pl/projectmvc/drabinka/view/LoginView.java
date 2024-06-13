package pl.projectmvc.drabinka.view;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;

public class LoginView {

    private final VBox root;

    private final Label infoAlertLabel;

    private final TextField loginTextField;
    private final TextField passwordTextField;

    private final ChoiceBox<String> roleChoiceBox;

    private final Button buttonLogin;
    private final Button buttonRegister;
    private final Button buttonBack;

    public LoginView() {
        root = new VBox(10);
        VBox textFieldsVbox = new VBox(10);
        HBox buttonsHbox = new HBox(10);
        HBox navigationHbox = new HBox();

        infoAlertLabel = new Label("Wpisz login i hasło");

        loginTextField = new TextField();
        loginTextField.setPromptText("Login");

        passwordTextField = new TextField();
        passwordTextField.setPromptText("Password");

        roleChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList("Sędzia", "Organizator"));
        roleChoiceBox.setValue("Sędzia"); // default value

        buttonLogin = new Button("Zaloguj");
        buttonRegister = new Button("Zarejestruj");
        buttonBack = new Button("Wróć");

        root.getChildren().addAll(textFieldsVbox, buttonsHbox, navigationHbox);
        textFieldsVbox.getChildren().addAll(infoAlertLabel, loginTextField, passwordTextField);
        buttonsHbox.getChildren().addAll(buttonLogin, buttonRegister, roleChoiceBox);
        navigationHbox.getChildren().addAll(buttonBack);
    }

    public VBox getRoot() {
        return root;
    }

    public Label getInfoAlertLabel() {
        return infoAlertLabel;
    }

    public TextField getLoginTextField() {
        return loginTextField;
    }

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public ChoiceBox<String> getRoleChoiceBox() {
        return roleChoiceBox;
    }

    public Button getLoginButton() {
        return buttonLogin;
    }

    public Button getRegisterButton() {
        return buttonRegister;
    }

    public Button getBackButton(){
        return buttonBack;
    }
}
