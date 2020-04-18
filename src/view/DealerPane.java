package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DealerPane extends HBox {
	Button[] btnActions = {
				new Button("Hit"),
				new Button("Stand")
		};
	DealerCardPane dealerCardPane = new DealerCardPane();
	
	public DealerPane() {
		Label lblDealerHand = new Label("Dealer's Hand: ");
		
		VBox dealerCards = new VBox();
		dealerCards.getChildren().addAll(lblDealerHand, dealerCardPane);
		dealerCards.setSpacing(10);
		
		VBox actionButtons = new VBox();
		for (Button actButton : btnActions) {
			actionButtons.getChildren().add(actButton);
			actButton.setPrefWidth(80);
		}
		actionButtons.setSpacing(30);
		actionButtons.setAlignment(Pos.CENTER);
		getChildren().addAll(dealerCards, actionButtons);
		setSpacing(100);
		setPadding(new Insets(20, 60, 20, 80));
		setAlignment(Pos.CENTER);
	}

	public Button[] getBtnActions() {
		return btnActions;
	}

	public DealerCardPane getDealerCardPane() {
		return dealerCardPane;
	}
	
}
