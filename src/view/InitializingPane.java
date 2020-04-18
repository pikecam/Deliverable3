package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InitializingPane extends VBox {
	private int numberOfPlayers = 1;
	private int startingChips = 100;
	private Button btnOk = new Button("Ok");
	private Stage firstStage;
	private TextField txtPlayers = new TextField(""+numberOfPlayers);
	private TextField txtStartingChips = new TextField(""+startingChips);

	public InitializingPane() {
		Alert alert = new Alert(AlertType.INFORMATION);
		Label lblPlayers = new Label("How Many Players: ");
		Label lblStartChips = new Label("How many Starting Chips");

		txtPlayers.setPrefColumnCount(5);
		txtStartingChips.setPrefColumnCount(5);

		Button btnPlayersPlus = new Button("+");
		Button btnPlayersMinus = new Button("-");

		btnPlayersMinus.setOnAction(event -> {
			try {
				numberOfPlayers = Integer.parseInt(txtPlayers.getText());
			} catch (NumberFormatException ex) {

			}

			if (numberOfPlayers <= 1) {
				numberOfPlayers = 1;
				alert.setContentText("Cant have less than 1 player");
				alert.show();
			} else if(numberOfPlayers > 4) {
				numberOfPlayers = 4;
				alert.setContentText("Cant have more than 4 players");
				alert.show();
			} else {
				numberOfPlayers--;
			}
			txtPlayers.setText(numberOfPlayers + "");
		});

		btnPlayersPlus.setOnAction(event -> {
			try {
				numberOfPlayers = Integer.parseInt(txtPlayers.getText());
			} catch (NumberFormatException ex) {

			}
			if (numberOfPlayers < 1) {
				numberOfPlayers = 1;
				alert.setContentText("Cant have less than 1 player");
				alert.show();
			} else if(numberOfPlayers >= 4) {
				numberOfPlayers = 4;
				alert.setContentText("Cant have more than 4 players");
				alert.show();
			} else {
				numberOfPlayers++;
			}
			txtPlayers.setText(numberOfPlayers + "");
		});

		Button btnStartChipsPlus = new Button("+10");
		Button btnStartChipsMinus = new Button("10-");

		btnStartChipsMinus.setOnAction(event -> {
			try {
				startingChips = Integer.parseInt(txtStartingChips.getText());
			} catch (NumberFormatException ex) {

			}

			if (startingChips <= 0) {
				startingChips = 0;
				alert.setContentText("Cant have less than 0 chips");
				alert.show();
			} else {
				startingChips -= 10;
			}
			txtStartingChips.setText(startingChips + "");
		});

		btnStartChipsPlus.setOnAction(event -> {
			try {
				startingChips = Integer.parseInt(txtStartingChips.getText());
			} catch (NumberFormatException ex) {

			}
			if (startingChips < 0) {
				startingChips = 0;
				alert.setContentText("Cant have less than 0 chips");
				alert.show();
			} else {
				startingChips += 10;
			}
			txtStartingChips.setText(startingChips + "");
		});

		btnOk.setOnAction(event -> ok());
		btnOk.setPrefWidth(100);
		
		txtPlayers.setAlignment(Pos.CENTER);
		txtStartingChips.setAlignment(Pos.CENTER);
		
		FlowPane playersInput = new FlowPane(10, 10);
		playersInput.getChildren().addAll(btnPlayersMinus, txtPlayers, btnPlayersPlus);

		FlowPane startingChipsInput = new FlowPane(10, 10);
		startingChipsInput.getChildren().addAll(btnStartChipsMinus, txtStartingChips, btnStartChipsPlus);

		VBox players = new VBox();
		players.getChildren().addAll(lblPlayers, playersInput);
		players.setSpacing(10);
		players.setAlignment(Pos.CENTER);
		playersInput.setAlignment(Pos.CENTER);

		VBox startingChips = new VBox();
		startingChips.getChildren().addAll(lblStartChips, startingChipsInput);
		startingChips.setSpacing(10);
		startingChips.setAlignment(Pos.CENTER);
		startingChipsInput.setAlignment(Pos.CENTER);

		setAlignment(Pos.CENTER);
		getChildren().addAll(players, startingChips, btnOk);
		setSpacing(30);
		setPadding(new Insets(20));
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public int getStartingChips() {
		return startingChips;
	}

	public void passStage(Stage stage) {
		firstStage = stage;
	}

	private void ok() {
		Alert alert = new Alert(AlertType.ERROR);
		try {
			numberOfPlayers = Integer.parseInt(txtPlayers.getText());
			startingChips = Integer.parseInt(txtStartingChips.getText());
			firstStage.close();
		} catch (NumberFormatException ex) {
			alert.setContentText("Input not a number");
			alert.show();
		}
	}
}
