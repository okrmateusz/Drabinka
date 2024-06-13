package pl.projectmvc.drabinka.view;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.projectmvc.drabinka.model.Player;

public class AddPlayerView {
    private final VBox root;

    private final TextField textFieldName;
    private final TextField textFieldRank;

    private final Button buttonAddPlayer;
    private final Button buttonDeletePlayer;
    private final Button buttonConfirm;
    private final Button buttonBack;

    private final TableView<Player> tableView;

    public AddPlayerView(){
        root = new VBox(10);

        HBox hBoxContainer = new HBox(10);
        VBox vBoxTableView = new VBox(10);
        VBox vBoxContainerElements = new VBox(10);
        HBox hBoxButtons = new HBox(10);

        textFieldName = new TextField();
        textFieldName.setPromptText("Nazwa");
        textFieldRank = new TextField();
        textFieldRank.setPromptText("Ranking");

        buttonAddPlayer = new Button("Dodaj");
        buttonDeletePlayer = new Button("Usuń");
        buttonConfirm = new Button("Zatwierdź");
        buttonBack = new Button("Wróć");

        tableView = new TableView<>();

        TableColumn<Player, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("namePlayer"));

        TableColumn<Player, Integer> rankColumn = new TableColumn<>("Rank");
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));

        tableView.getColumns().addAll(nameColumn, rankColumn);
        nameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(2)); // Divide table width into 2 columns
        rankColumn.prefWidthProperty().bind(tableView.widthProperty().divide(2)); // Divide table width into 2 columns
        nameColumn.setResizable(false);
        rankColumn.setResizable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        root.getChildren().addAll(hBoxContainer, hBoxButtons);
        hBoxContainer.getChildren().addAll(vBoxContainerElements, vBoxTableView);
        hBoxButtons.getChildren().addAll(buttonBack, buttonConfirm);
        vBoxContainerElements.getChildren().addAll(textFieldName, textFieldRank, buttonAddPlayer);
        vBoxTableView.getChildren().addAll(tableView, buttonDeletePlayer);
    }
    public VBox getRoot() {
        return root;
    }

    public Button getButtonAddPlayer(){
        return buttonAddPlayer;
    }

    public Button getButtonDeletePlayer(){
        return buttonDeletePlayer;
    }

    public Button getButtonBack(){
        return buttonBack;
    }

    public TextField getTextFieldName() {
        return textFieldName;
    }

    public TextField getTextFieldRank() {
        return textFieldRank;
    }

    public TableView<Player> getTableView() {
        return tableView;
    }

    public Button getButtonConfirm() {
        return buttonConfirm;
    }

}
