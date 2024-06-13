package pl.projectmvc.drabinka.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import pl.projectmvc.drabinka.model.User;
import pl.projectmvc.drabinka.model.UserInfo;
import pl.projectmvc.drabinka.view.LoginView;

import java.util.List;

public class LoginController {
    private final Stage stage;
    private final LoginView view;
    private final SceneController sceneController;

    public LoginController(Stage stage, SceneController sceneController, LoginView view) {
        this.stage = stage;
        this.view = view;
        this.sceneController = sceneController;

        view.getBackButton().setOnAction(this::handleGetButtonBack);
        view.getLoginButton().setOnAction(this::handleGetButtonLogin);
        view.getRegisterButton().setOnAction(this::handleGetButtonRegister);
    }

    private void handleGetButtonBack(ActionEvent event) {
        System.out.println("Clicked getBackButton");
        stage.setScene(sceneController.getSceneMenuView());
        stage.setTitle("Menu");
        view.getLoginTextField().clear();
        view.getPasswordTextField().clear();
    }

    private void handleGetButtonLogin(ActionEvent event) {
        String name = view.getLoginTextField().getText();
        String password = view.getPasswordTextField().getText();

        List<User> users = User.readFromFile();
        User loggedInUser = users.stream()
                .filter(user -> user.getName().equals(name) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (loggedInUser != null) {
            String role = loggedInUser.getRole();
            sceneController.getMenuView().setUserInfoLabel(name, role);
            System.out.println("Logged in successfully!");
            view.getInfoAlertLabel().setText("Logged in successfully!");
            stage.setScene(sceneController.getSceneMenuView());
            stage.setTitle("Menu");

            UserInfo.setLoggedInUser(loggedInUser);

            if ("Sędzia".equals(role)) {
                sceneController.getMenuView().setAddBracketButtonDisabled(true);
            } else {
                sceneController.getMenuView().setAddBracketButtonDisabled(false);
            }
        } else {
            System.out.println("Invalid credentials!");
            view.getInfoAlertLabel().setText("Invalid credentials!");
        }

        view.getLoginTextField().clear();
        view.getPasswordTextField().clear();
    }

    private void handleGetButtonRegister(ActionEvent event) {
        String name = view.getLoginTextField().getText();
        String password = view.getPasswordTextField().getText();
        String role = view.getRoleChoiceBox().getValue();

        User newUser = new User(name, password, role);
        newUser.saveToFile();

        System.out.println("Registered successfully!");
        view.getInfoAlertLabel().setText("Registered successfully!");

        view.getLoginTextField().clear();
        view.getPasswordTextField().clear();
    }
}
