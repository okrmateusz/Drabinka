package pl.projectmvc.drabinka.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuView {
    private final HBox hBoxListBracket;
    private final VBox vBoxListView;
    private final VBox vBoxButtons;

    private final Button addBracketButton;
    private final Button loginButton;
    private final Button bracketButton;

    private final Text nameText;
    private final Text roleText;

    private final ListView<String> bracketListView;

    private final HBox infoUserLabel;

    public MenuView() {
        hBoxListBracket = new HBox(10);
        hBoxListBracket.setPadding(new Insets(10));

        vBoxListView = new VBox(10);
        vBoxButtons = new VBox(10);

        addBracketButton = new Button("Dodaj");
        addBracketButton.setDisable(true);
        bracketButton = new Button("Drabinka");
        bracketButton.setDisable(true);

        loginButton = new Button("Zaloguj");


        nameText = new Text("Użytkownik niezalogowany: <nazwa>");
        roleText = new Text(", <rola>");

        bracketListView = new ListView<>();

        infoUserLabel = new HBox();

        hBoxListBracket.getChildren().addAll(vBoxListView, vBoxButtons);
        vBoxButtons.getChildren().addAll(infoUserLabel, addBracketButton, bracketButton, loginButton);
        infoUserLabel.getChildren().addAll(nameText, roleText);
    }


    public Button getAddBracketButton() {
        return addBracketButton;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getBracketButton() {
        return bracketButton;
    }

    public void setUserInfoLabel(String name, String role) {
        nameText.setText("Zalogowany użytkownik: " + name);
        roleText.setText(", " + role);
    }

    public void setAddBracketButtonDisabled(boolean disabled) {
        addBracketButton.setDisable(disabled);
    }
    public void setBracketButtonDisabled(boolean disabled){
        bracketButton.setDisable(disabled);
    }

    public HBox getRoot() {
        return hBoxListBracket;
    }
}
