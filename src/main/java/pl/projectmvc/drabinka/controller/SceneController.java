package pl.projectmvc.drabinka.controller;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.projectmvc.drabinka.view.AddPlayerView;
import pl.projectmvc.drabinka.view.BracketView;
import pl.projectmvc.drabinka.view.MenuView;
import pl.projectmvc.drabinka.view.LoginView;

public class SceneController {
    private final AddPlayerView addPlayerView;
    private final BracketView bracketView;
    private final MenuView menuView;
    private final LoginView loginView;

    public SceneController(AddPlayerView addPlayerView, BracketView bracketView, MenuView menuView, LoginView loginView){
        this.addPlayerView = addPlayerView;
        this.bracketView = bracketView;
        this.menuView = menuView;
        this.loginView = loginView;
    }

    public Scene getSceneAddPlayerView(){
        return new Scene(new VBox(addPlayerView.getRoot()), 600, 400);
    }

    public Scene getSceneLoginView() {
        return new Scene(new VBox(loginView.getRoot()), 600, 400);
    }

    public Scene getSceneBracketView() {
        return new Scene(new VBox(bracketView.getRoot()), 600, 400);
    }

    public Scene getSceneMenuView() {
        return new Scene(new VBox(menuView.getRoot()), 600, 400);
    }

    public MenuView getMenuView() {
        return menuView;
    }

}
