package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PlayerPane extends HBox {
	Button[] btnPlayers = { 
			new Button("Player 1"),
			new Button("Player 2"), 
			new Button("Player 3"),
			new Button("Player 4") 
			};
	PlayerCardPane playerCardPane = new PlayerCardPane();
	Label lblPlayerHand = new Label("Player 1 Hand: ");

	public PlayerPane() {
		VBox playerCards = new VBox();

		playerCards.getChildren().addAll(lblPlayerHand, playerCardPane);
		playerCards.setSpacing(10);

		VBox playersButton = new VBox(10);
		for (Button switchPlayers : btnPlayers) {
			playersButton.getChildren().add(switchPlayers);
			switchPlayers.setStyle("");
		}
		playersButton.setAlignment(Pos.CENTER);
		getChildren().addAll(playersButton, playerCards);
		HBox.setHgrow(playerCards, Priority.ALWAYS);
		setSpacing(20);
		setAlignment(Pos.CENTER);
	}

	public Button[] getBtnPlayers() {
		return btnPlayers;
	}

	public PlayerCardPane getPlayerCardPane() {
		return playerCardPane;
	}

	public Label getLblPlayerHand() {
		return lblPlayerHand;
	}
}
