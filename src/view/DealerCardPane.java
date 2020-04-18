package view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DealerCardPane extends HBox {
	private Image cardDefault = new Image("file:cardImages/b1fv.png");
	private ImageView card1 = new ImageView(cardDefault);
	private ArrayList<ImageView> dealerCards = new ArrayList<>();

	public DealerCardPane() {
		super();
		setPrefWidth(200);
		setPadding(new Insets(15));
		setSpacing(10);
		setAlignment(Pos.CENTER);
//		dealerCards.add(new ImageView(cardDefault));
//		dealerCards.add(new ImageView(cardDefault));
		for (ImageView imageView: dealerCards) {
			getChildren().add(imageView);
		}
		setStyle("-fx-border-width: 3; -fx-border-style: solid; -fx-border-radius: 20");
		
	}

	public ArrayList<ImageView> getCards() {
		return dealerCards;
	}
	
	public void getCards(ArrayList<ImageView> dealerCards) {
		this.dealerCards = dealerCards; 
	}
	
	public void updatePane() {
		getChildren().clear();
		for (ImageView imageView : dealerCards) {
			getChildren().add(imageView);
		}
	}
}
