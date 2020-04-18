package view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PlayerCardPane extends HBox {
	private ArrayList<ImageView> cardList = new ArrayList<>();
	private Image cardDefault = new Image("file:C:\\Users\\camer\\Documents\\programs\\Java Programs\\Deliverable\\src\\cardImages\\b1fv.png");
	
	public PlayerCardPane() {
		setPadding(new Insets(15));
		setSpacing(10);
		setAlignment(Pos.CENTER);
		setStyle("-fx-border-width: 3; -fx-border-style: solid; -fx-border-radius: 20");
	}

	public ArrayList<ImageView> getCardList() {
		try {
			return cardList;
		} finally {
			updatePane();
		}
	}
	
	public void setCardList(ArrayList<ImageView> cardList) {
		this.cardList = cardList;
		updatePane();
	}

	public void updatePane() {
		getChildren().clear();
		for (ImageView imageView : cardList) {
			getChildren().add(imageView);
		}
	}
	
	public void addDefaultCard() {
		cardList.add(new ImageView(cardDefault));
		updatePane();
	}
	
	public void addDefaultCard(int multipleCards) {
		if(multipleCards<=0) {
			throw new IllegalArgumentException("multiples of cards can't be lower than zero");
		} else {
			for(int i = 0; i < multipleCards; i++) {
				addDefaultCard();
			}		
		}
	}
}
