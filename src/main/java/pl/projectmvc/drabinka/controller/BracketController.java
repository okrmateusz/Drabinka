package pl.projectmvc.drabinka.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.projectmvc.drabinka.model.Player;
import pl.projectmvc.drabinka.model.User;
import pl.projectmvc.drabinka.model.UserInfo;
import pl.projectmvc.drabinka.view.BracketView;

import java.util.ArrayList;
import java.util.List;

public class BracketController {
    Stage stage;
    BracketView view;
    SceneController sceneController;
    private int currentRound = 0;
    ObservableList<Player> players = AddPlayerController.players;

    public BracketController(Stage stage, SceneController sceneController, BracketView view) {
        this.stage = stage;
        this.view = view;
        this.sceneController = sceneController;

        view.getButtonNextRound().setOnAction(this::generateNextRound);
        view.getButtonBack().setOnAction(this::handleBackButton);
    }

    public void generateNextRound(ActionEvent event) {
        System.out.println("Current players: " + players);
        System.out.println("Number of players: " + players.size());

        List<TextField> scores = view.getScores();
        List<Button> dqButtons = view.getDqButtons();

        if (currentRound > 0) {
            for (TextField textField : scores) {
                textField.setDisable(true);
            }

            for (Button dqButton : dqButtons) {
                dqButton.setDisable(true);
            }

            List<Player> winners = new ArrayList<>();
            List<Integer> points = new ArrayList<>();

            for (TextField textField : scores) {
                try {
                    points.add(Integer.parseInt(textField.getText()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid score: " + textField.getText());
                }
            }
            System.out.println("Scores: " + points);

            for (int i = 0; i < points.size(); i += 2) {
                if (i + 1 < points.size()) {
                    if (points.get(i) == -1 && points.get(i + 1) == -1) {
                        winners.add(new Player("BRAK", -1));
                    } else if (points.get(i) > points.get(i + 1)) {
                        winners.add(players.get(i));
                    } else {
                        winners.add(players.get(i + 1));
                    }
                } else {
                    winners.add(players.get(i));
                }
            }
            System.out.println("Winners: " + winners);

            players.setAll(winners);
            scores.clear();
            dqButtons.clear();
        }

        System.out.println("Updated players: " + players);

        int playersCount = players.size();
        if (playersCount > 1) {
            VBox roundColumnVBox = new VBox();
            view.getRoundsHbox().getChildren().add(roundColumnVBox);

            view.printLabel(currentRound, roundColumnVBox);

            for (int j = 0; j < playersCount; j += 2) {
                if (j + 1 < playersCount) {
                    roundColumnVBox.getChildren().add(view.createSchedule(players.get(j), players.get(j + 1)));
                }
            }

            currentRound++;
        } else if (playersCount == 1) {
            Label winnerLabel = new Label("Winner: " + players.getFirst().getNamePlayer());
            winnerLabel.setStyle("-fx-font-size: 16px; -fx-alignment: center;");
            view.getRoundsHbox().getChildren().add(winnerLabel);
        }
    }

    private void handleBackButton(ActionEvent event) {
        System.out.println("Clicked getBackButton");
        User loggedInUser = UserInfo.getLoggedInUser();
        if ("Sędzia".equals(loggedInUser.getRole())) {
            stage.setScene(sceneController.getSceneMenuView());
            stage.setTitle("Menu");
        } else {
            stage.setScene(sceneController.getSceneAddPlayerView());
            stage.setTitle("Lista graczy");
        }
    }
}
