package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InfoPane extends VBox {

	private Label lblCurrentBid = new Label("Current Bid: ");
	private TextField txtCurrentBid = new TextField();
	private Button btnLockBet = new Button("Lock Bet");
	private ListView<String> listViewLog = new ListView<String>();
	private Label lblLog = new Label("Log: ");
	private ListView<String> listViewPlayerBets = new ListView<String>();

	public InfoPane() {
		txtCurrentBid.setPrefColumnCount(5);

		VBox playerBids = new VBox();
		HBox bidInputPane = new HBox();

		bidInputPane.setSpacing(30);
		bidInputPane.getChildren().addAll(txtCurrentBid, btnLockBet);
		bidInputPane.setAlignment(Pos.CENTER);

		playerBids.getChildren().add(listViewPlayerBets);
		playerBids.setStyle("-fx-border-width: 3; -fx-border-style: solid; -fx-border-radius: 20");
		playerBids.setPadding(new Insets(10));

		setMaxWidth(200);
		setStyle("-fx-border-width: 3; -fx-border-style: solid; -fx-border-radius: 20");
		setPadding(new Insets(10));
		
		setSpacing(10);
		getChildren().addAll(lblCurrentBid, bidInputPane, playerBids, lblLog, listViewLog);
	}

	public Label getLblCurrentBid() {
		return lblCurrentBid;
	}

	public TextField getTxtCurrentBid() {
		return txtCurrentBid;
	}

	public Button getBtnLockBet() {
		return btnLockBet;
	}

	public ListView<String> getLog() {
		return listViewLog;
	}

	public ListView<String> getPlayerBets(){
		return listViewPlayerBets;
	}
	
	public Label getLblLog() {
		return lblLog;
	}
}
