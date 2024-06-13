package pl.projectmvc.drabinka.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import pl.projectmvc.drabinka.view.MenuView;

public class MenuViewController {
    private final Stage stage;
    private final SceneController sceneController;
    public MenuViewController(Stage stage, SceneController sceneController, MenuView view){
        this.stage = stage;
        this.sceneController = sceneController;

        view.getAddBracketButton().setOnAction(this::handleGetAddBracketButton);
        view.getLoginButton().setOnAction(this::handleGetLoginButton);
        view.getBracketButton().setOnAction(this::handelGetBracketButton);
    }

    private void handleGetAddBracketButton(ActionEvent actionEvent) {
        System.out.println("Clicked getAddBracketButton");
        stage.setScene(sceneController.getSceneAddPlayerView());
        stage.setTitle("Lista graczy");
    }

    private void handleGetLoginButton(ActionEvent event){
        System.out.println("Clicked getLoginButton");
        stage.setScene(sceneController.getSceneLoginView());
        stage.setTitle("Logowanie/Rejestracja");
    }
    private void handelGetBracketButton(ActionEvent event){
        System.out.println("Clicker getBracketButton");
        stage.setScene(sceneController.getSceneBracketView());
        stage.setTitle("Drabinka");
    }
}