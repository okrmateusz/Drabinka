package pl.projectmvc.drabinka;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.projectmvc.drabinka.controller.*;
import pl.projectmvc.drabinka.view.AddPlayerView;
import pl.projectmvc.drabinka.view.BracketView;
import pl.projectmvc.drabinka.view.MenuView;
import pl.projectmvc.drabinka.view.LoginView;

/**
 * Główne okno aplikacji fxml mainView.fxml
 * Wyświetla fxml mainView.fxml
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {


        MenuView menuView = new MenuView();

        AddPlayerView addPlayerView = new AddPlayerView();

        BracketView bracketView = new BracketView();

        LoginView loginView = new LoginView();

        SceneController sceneController = new SceneController(
                addPlayerView,
                bracketView,
                menuView,
                loginView
        );

        stage.setScene(sceneController.getSceneMenuView());
        stage.setTitle("Menu");
        stage.show();

        // Create the controller and pass the necessary objects
        MenuViewController menuViewController = new MenuViewController(stage, sceneController, menuView);
        AddPlayerController addPlayerController = new AddPlayerController(stage, sceneController, addPlayerView);
        BracketController bracketController = new BracketController(stage, sceneController, bracketView);
        LoginController loginController = new LoginController(stage, sceneController, loginView);

    }
}
