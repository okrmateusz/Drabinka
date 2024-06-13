package pl.projectmvc.drabinka.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import pl.projectmvc.drabinka.model.Player;
import pl.projectmvc.drabinka.view.AddPlayerView;

public class AddPlayerController {
    private final Stage stage;
    private final AddPlayerView view;
    private final SceneController sceneController;
    public static ObservableList<Player> players = FXCollections.observableArrayList();

    public AddPlayerController(Stage stage, SceneController sceneController, AddPlayerView view) {
        this.stage = stage;
        this.sceneController = sceneController;
        this.view = view;

        view.getTableView().setItems(players);
        view.getButtonAddPlayer().setOnAction(this::handleAddPlayer);
        view.getButtonDeletePlayer().setOnAction(this::handleDeletePlayer);
        view.getButtonConfirm().setOnAction(this::handleConfirm);
        view.getButtonBack().setOnAction(this::handleBack);

    }

    private void handleAddPlayer(ActionEvent event) {
        String name = view.getTextFieldName().getText();
        int rank = Integer.parseInt(view.getTextFieldRank().getText());
        players.add(new Player(name, rank));

        view.getTextFieldName().clear();
        view.getTextFieldRank().clear();
    }

    private void handleDeletePlayer(ActionEvent event) {
        int selectedIndex = view.getTableView().getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            players.remove(selectedIndex);
        } else {
            System.out.println("Nie wybrano gracza do usunięcia.");
        }
    }

    private void handleConfirm(ActionEvent event) {
        System.out.println("Clicked getButtonConfirm");
        stage.setScene(sceneController.getSceneBracketView());
        stage.setTitle("Drabinka");
        sceneController.getMenuView().setBracketButtonDisabled(false);
    }

    private void handleBack(ActionEvent event) {
        System.out.println("Clicked getButtonBack");
        stage.setScene(sceneController.getSceneMenuView());
        stage.setTitle("Menu");

    }
}