package pl.projectmvc.drabinka.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import pl.projectmvc.drabinka.model.Player;

import java.util.ArrayList;
import java.util.List;

public class BracketView {
    Button buttonNextRound;
    Button buttonBack;
    VBox root;
    HBox roundsHbox;
    HBox buttonsHbox;
    List<TextField> scores = new ArrayList<>();
    List<Button> dqButtons = new ArrayList<>();


    public BracketView() {
        root = new VBox(10);
        roundsHbox = new HBox(10);
        buttonsHbox = new HBox(10);
        buttonNextRound = new Button("Następna runda");
        buttonBack = new Button("Wróć");

        root.getChildren().addAll(roundsHbox, buttonsHbox);
        buttonsHbox.getChildren().addAll(buttonBack, buttonNextRound);
    }

    public Button getButtonNextRound() {
        return buttonNextRound;
    }

    public VBox getRoot() {
        return root;
    }

    public List<TextField> getScores() {
        return scores;
    }

    public List<Button> getDqButtons() {
        return dqButtons;
    }

    public HBox getRoundsHbox() {
        return roundsHbox;
    }

    public HBox getButtonsHbox() {
        return buttonsHbox;
    }

    public Button getButtonBack(){
        return buttonBack;
    }

    public HBox createSchedule(Player player1, Player player2) {
        String playerName1 = player1.getNamePlayer();
        String playerName2 = player2.getNamePlayer();
        String playerRank1 = String.valueOf(player1.getRank());
        String playerRank2 = String.valueOf(player2.getRank());

        Label labelPlayer1 = new Label(playerName1 + " [" + playerRank1 + "]");
        Label labelPlayer2 = new Label("[" + playerRank2 + "] " + playerName2);
        TextField pointsPlayer1TextField = new TextField("0");
        TextField pointsPlayer2TextField = new TextField("1");
        Button disqualifyButton1 = new Button("DQ");
        disqualifyButton1.setId("1");
        disqualifyButton1.getId();
        Button disqualifyButton2 = new Button("DQ");

        pointsPlayer1TextField.setPrefSize(30, 25);
        pointsPlayer2TextField.setPrefSize(30, 25);

        disqualifyButton1.setOnAction(e -> disqualifyPlayer(pointsPlayer1TextField));
        disqualifyButton2.setOnAction(e -> disqualifyPlayer(pointsPlayer2TextField));

        scores.add(pointsPlayer1TextField);
        scores.add(pointsPlayer2TextField);
        dqButtons.add(disqualifyButton1);
        dqButtons.add(disqualifyButton2);

        HBox hbox = new HBox(10);
        Text text = new Text(" - ");
        hbox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(
                pointsPlayer1TextField,
                disqualifyButton1,
                labelPlayer1,
                text,
                labelPlayer2,
                disqualifyButton2,
                pointsPlayer2TextField);
        return hbox;
    }

    private void disqualifyPlayer(TextField pointsTextField) {
        pointsTextField.setText("-1");
        pointsTextField.setDisable(true);
        pointsTextField.setStyle("-fx-background-color: lightgray;");
    }

    public void printLabel(int currentRound, VBox roundColumnVBox) {
        Label roundLabel = new Label("Runda: " + currentRound);
        roundLabel.setStyle("-fx-font-size: 16px; -fx-alignment: center;");
        roundColumnVBox.getChildren().add(roundLabel);
    }
}
