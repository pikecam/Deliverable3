package view;

import java.util.ArrayList;

import model.Card;
import model.DealerHand;
import model.PlayerHand;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class BlackJackDriver extends Application {
	int numberOfPlayers;
	int startingChips;
	InitializingPane initializePane = new InitializingPane();
	PlayerHand[] playerHands;
	PlayerPane playerPane = new PlayerPane();
	DealerPane dealerPane = new DealerPane();
	ArrayList<ImageView> playerCardList;
	Console console = new Console();
	InfoPane infoPane = new InfoPane();
	int playerIndex = 0;
	DealerHand dealerHand = new DealerHand();
	ObservableList<String> bettingList = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {
		Stage initializeGame = new Stage();
		Scene initializeScene = new Scene(initializePane);
		initializePane.passStage(initializeGame);
		initializeGame.setScene(initializeScene);
		initializeGame.showAndWait();

		HBox root = new HBox();
		VBox handPanes = new VBox();

		VBox.setVgrow(infoPane, Priority.ALWAYS);

		handPanes.getChildren().addAll(dealerPane, playerPane);
		handPanes.setAlignment(Pos.CENTER_LEFT);
		handPanes.setSpacing(130);

		root.getChildren().addAll(handPanes, infoPane);
		root.setPadding(new Insets(10));
		root.setSpacing(100);

		Scene scene = new Scene(root, 830, 520);
		primaryStage.setScene(scene);
		primaryStage.show();

		startGame();

		dealerPane.getBtnActions()[0].setOnAction(event -> hit());
		dealerPane.getBtnActions()[1].setOnAction(event -> stand());
		infoPane.getBtnLockBet().setOnAction(event -> lockBet());
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void startGame() {
		for (int i = 0; i < numberOfPlayers; i++) {
			playerHands[i].setCanPlay(true);
		}

		numberOfPlayers = initializePane.getNumberOfPlayers();
		startingChips = initializePane.getStartingChips();
		playerHands = new PlayerHand[numberOfPlayers];

		for (int i = 0; i < numberOfPlayers; i++) {
			playerHands[i] = new PlayerHand();
			playerHands[i].getCardHand().add(Card.randomCard());
			playerHands[i].getCardHand().add(Card.randomCard());
		}

		playerCardList = new ArrayList<>();

		for (int i = 0; i < playerHands[0].getCardHand().size(); i++) {
			playerCardList.add(new ImageView(playerHands[0].getCardHand().get(i).getImage()));
		}
		playerHands[playerIndex].setPlaying(true);
		playerPane.getPlayerCardPane().setCardList(playerCardList);
		playerPane.getPlayerCardPane().updatePane();

		dealerCards();
		updateButtonDisable();
		initializePlayerButtons();
		initializeBetting();
	}

	public void hit() {
		Alert alert = new Alert(AlertType.INFORMATION);

		if (playerHands[playerIndex].getCardHand().size() >= 5) {
			alert.setContentText("Max of 5 cards for hit");
			alert.show();
			console.log("Max of 5 cards for Player 1");
		} else {
			playerHands[playerIndex].getCardHand().add(Card.randomCard());
			playerCardList.clear();
			for (int i = 0; i < playerHands[playerIndex].getCardHand().size(); i++) {
				playerCardList.add(new ImageView(playerHands[playerIndex].getCardHand().get(i).getImage()));
			}
			playerPane.getPlayerCardPane().setCardList(playerCardList);
			playerPane.getPlayerCardPane().updatePane();
		}
		updateLog();

	}

	public void stand() {

		console.log("Player " + (playerIndex + 1) + " has chosen Stand.\nNext Player");
		int previousIndex = playerIndex++;
		if (playerIndex >= numberOfPlayers) {
			playerIndex = 0;
		}
		
		playerHands[playerIndex].setPlaying(true);
		playerHands[previousIndex].setPlaying(false);
		playerCardList.clear();
		playerPane.getLblPlayerHand().setText("Player " + (playerIndex + 1) + " hand");

		for (int i = 0; i < playerHands[playerIndex].getCardHand().size(); i++) {
			playerCardList.add(new ImageView(playerHands[playerIndex].getCardHand().get(i).getImage()));
		}
		playerPane.getPlayerCardPane().setCardList(playerCardList);
		playerPane.getPlayerCardPane().updatePane();

		System.out.println(playerIndex);
		System.out.println(previousIndex);
		
		updateLog();
		winningConditions();
		unlockBet();
		updateButtonDisable();
	}

	public boolean checkWin() {
		System.out.println("checkWin Called");
		Alert alert = new Alert(AlertType.INFORMATION);
		int totalCardScore = 0;
		int dealerTotalScore = 0;

		for (int i = 0; i < playerHands[playerIndex].getCardHand().size(); i++) {
			totalCardScore += Card.getValue(playerHands[playerIndex].getCardHand().get(i));
		}
		for (int i = 0; i < dealerHand.getCardHand().size(); i++) {
			dealerTotalScore += Card.getValue(dealerHand.getCardHand().get(i));
		}
		if ((totalCardScore < 21) && (dealerTotalScore < 21)) {
			if (totalCardScore > dealerTotalScore) {
				alert.setContentText("Player has higher cards, Player wins double");
				alert.show();
				return true;
			} else {
				alert.setContentText("Dealer has higher cards, Player looses bet");
				alert.show();
				return false;
			}
		} else if (totalCardScore > 21) {
			alert.setContentText("Player Cards Over 21, Player looses bet");
			alert.show();
			return false;
		} else if (dealerTotalScore > 21) {
			alert.setContentText("Dealer Cards Over 21, Player wins double");
			alert.show();
			return true;
		} else {
			return false;
		}
	}

	public void dealerCards() {
		dealerHand.getCardHand().add(Card.randomCard());
		dealerHand.getCardHand().add(Card.randomCard());

		dealerPane.getDealerCardPane().getCards().clear();
		for (int i = 0; i < dealerHand.getCardHand().size(); i++) {
			dealerPane.getDealerCardPane().getCards().add(new ImageView(dealerHand.getCardHand().get(i).getImage()));
		}
		dealerPane.getDealerCardPane().updatePane();

	}

	public void initializePlayerButtons() {
		for (int i = 0; i < playerPane.getBtnPlayers().length; i++) {
			playerPane.getBtnPlayers()[i].setDisable(true);
		}
		for (int i = 0; i < numberOfPlayers; i++) {
			playerPane.getBtnPlayers()[i].setDisable(false);
		}
		for (int i = 0; i < playerPane.getBtnPlayers().length; i++) {
			playerPane.getBtnPlayers()[i].setOnAction(event -> {
				if (event.getSource() == playerPane.getBtnPlayers()[0]) {
					playerIndex = 0;
				} else if (event.getSource() == playerPane.getBtnPlayers()[1]) {
					playerIndex = 1;
				} else if (event.getSource() == playerPane.getBtnPlayers()[2]) {
					playerIndex = 2;
				} else if (event.getSource() == playerPane.getBtnPlayers()[3]) {
					playerIndex = 3;
				}
				updateButtonDisable();
				updateCurrentBetText();
				playerCardList.clear();
				playerPane.getLblPlayerHand().setText("Player " + (playerIndex + 1) + " hand");
				for (int x = 0; x < playerHands[playerIndex].getCardHand().size(); x++) {
					playerCardList.add(new ImageView(playerHands[playerIndex].getCardHand().get(x).getImage()));
				}
				playerPane.getPlayerCardPane().setCardList(playerCardList);
				playerPane.getPlayerCardPane().updatePane();
			});
		}
	}

	public void initializeBetting() {
		for (int i = 0; i < numberOfPlayers; i++) {
			playerHands[i].setChipsTotal(startingChips);
			bettingList.add("Player " + (i + 1) + " chips:\n" + playerHands[i].getChipsTotal());
		}

		infoPane.getPlayerBets().setItems(bettingList);
	}

	public void lockBet() {
		Alert alert = new Alert(AlertType.ERROR);
		if (playerHands[playerIndex].isPlaying()) {
			try {
				if (Integer.parseInt(infoPane.getTxtCurrentBid().getText()) > 0) {
					playerHands[playerIndex].setChipsBet(Integer.parseInt(infoPane.getTxtCurrentBid().getText()));
					infoPane.getTxtCurrentBid().setText(playerHands[playerIndex].getChipsBet() + "");
					infoPane.getTxtCurrentBid().setEditable(false);
					infoPane.getBtnLockBet().setDisable(true);
					int playerChipsBet = playerHands[playerIndex].getChipsBet();
					int playerChipsTotal = playerHands[playerIndex].getChipsTotal();
					int playerChipsUpdated = (playerChipsTotal - playerChipsBet);
					playerHands[playerIndex].setChipsTotal(playerChipsUpdated);
					updateButtonDisable();
					updatePlayerBets();
				}
			} catch (NumberFormatException ex) {
				alert.setContentText("Chips bet is not a number");
				alert.show();
			}
		} else {
			alert.setAlertType(AlertType.INFORMATION);
			alert.setContentText("Not Player " + (playerIndex + 1) + " turn yet");
			alert.show();
		}
	}

	public void unlockBet() {
		infoPane.getTxtCurrentBid().setEditable(true);
		infoPane.getBtnLockBet().setDisable(false);
		infoPane.getTxtCurrentBid().setText(playerHands[playerIndex].getChipsBet() + "");
	}

	public void updatePlayerBets() {
		bettingList.clear();
		for (int i = 0; i < numberOfPlayers; i++) {
			bettingList.add("Player " + (i + 1) + " chips:\n" + playerHands[i].getChipsTotal());
		}
		infoPane.getPlayerBets().setItems(bettingList);
	}

	public void updateLog() {
		infoPane.getLog().setItems(console.getList());
	}

	public void updateCurrentBetText() {
		infoPane.getTxtCurrentBid().setText(playerHands[playerIndex].getChipsBet() + "");
	}

	public void updateButtonDisable() {
		if (playerHands[playerIndex].getChipsBet() > 0) {
			if (playerHands[playerIndex].isPlaying()) {
				for (int i = 0; i < dealerPane.getBtnActions().length; i++) {
					dealerPane.getBtnActions()[i].setDisable(false);
				}
			} else {
				for (int i = 0; i < dealerPane.getBtnActions().length; i++) {
					dealerPane.getBtnActions()[i].setDisable(true);
				}
			}
		} else {
			for (int i = 0; i < dealerPane.getBtnActions().length; i++) {
				dealerPane.getBtnActions()[i].setDisable(true);
			}
		}
	}

	public void winningConditions() {
		if (checkWin()) {
			int playerBet = playerHands[playerIndex].getChipsBet() * 2;
			playerHands[playerIndex].setChipsBet(0);
			int newTotal = playerHands[playerIndex].getChipsTotal() + playerBet;
			playerHands[playerIndex].setChipsTotal(newTotal);
		} else {
			playerHands[playerIndex].setChipsBet(0);
//			if (playerHands[playerIndex].getChipsTotal() <= 0) {
//				playerHands[playerIndex].setCanPlay(false);
//			}
		}
		infoPane.getTxtCurrentBid().setText("0");
		updatePlayerBets();
	}
}
