package model;

import java.util.Random;

import javafx.scene.image.Image;

public class Card {
	CardNumber cardNumber;
	CardSuit cardSuit;

	public Card(CardNumber cardNumber, CardSuit cardSuit) {
		this.cardNumber = cardNumber;
		this.cardSuit = cardSuit;
	}

	public CardSuit getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}

	public CardNumber getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(CardNumber cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Image getImage() {
		String path = "cardImages/";
		
		switch (cardSuit) {
		case Spades: // If CardSuit is Spades
			switch (cardNumber) { //CardNumber Check
			case Ace:
				path += "1.png";
				break;
			case Two:
				path += "2.png";
				break;
			case Three:
				path += "3.png";
				break;
			case Four:
				path += "4.png";
				break;
			case Five:
				path += "5.png";
				break;
			case Six:
				path += "6.png";
				break;
			case Seven:
				path += "7.png";
				break;
			case Eight:
				path += "8.png";
				break;
			case Nine:
				path += "9.png";
				break;
			case TEN:
				path += "10.png";
				break;
			case Queen:
				path += "12.png";
				break;
			case King:
				path += "13.png";
				break;
			case Jack:
				path += "11.png";
				break;
			case Joker:
				path += "53.png";
				break;
			}
			break;
		case Diamonds: // If CardSuit is Diamonds
			switch (cardNumber) { // CardNumber Check
			case Ace:
				path += "27.png";
				break;
			case Two:
				path += "28.png";
				break;
			case Three:
				path += "29.png";
				break;
			case Four:
				path += "30.png";
				break;
			case Five:
				path += "31.png";
				break;
			case Six:
				path += "32.png";
				break;
			case Seven:
				path += "33.png";
				break;
			case Eight:
				path += "34.png";
				break;
			case Nine:
				path += "35.png";
				break;
			case TEN:
				path += "36.png";
				break;
			case Queen:
				path += "38.png";
				break;
			case King:
				path += "39.png";
				break;
			case Jack:
				path += "37.png";
				break;
			case Joker:
				path += "54.png";
				break;
			}
			break;
		case Hearts: // If Card Suit is Hearts
			switch (cardNumber) { // CardNumber Check
			case Ace:
				path += "14.png";
				break;
			case Two:
				path += "15.png";
				break;
			case Three:
				path += "16.png";
				break;
			case Four:
				path += "16.png";
				break;
			case Five:
				path += "18.png";
				break;
			case Six:
				path += "19.png";
				break;
			case Seven:
				path += "20.png";
				break;
			case Eight:
				path += "21.png";
				break;
			case Nine:
				path += "22.png";
				break;
			case TEN:
				path += "23.png";
				break;
			case Queen:
				path += "25.png";
				break;
			case King:
				path += "26.png";
				break;
			case Jack:
				path += "24.png";
				break;
			case Joker:
				path += "54.png";
				break;
			}
			break;
		case Clubs: //If Card Suit is Clubs
			switch (cardNumber) { // CardNumer Check
			case Ace:
				path += "40.png";
				break;
			case Two:
				path += "41.png";
				break;
			case Three:
				path += "42.png";
				break;
			case Four:
				path += "43.png";
				break;
			case Five:
				path += "44.png";
				break;
			case Six:
				path += "45.png";
				break;
			case Seven:
				path += "46.png";
				break;
			case Eight:
				path += "47.png";
				break;
			case Nine:
				path += "48.png";
				break;
			case TEN:
				path += "49.png";
				break;
			case Queen:
				path += "51.png";
				break;
			case King:
				path += "52.png";
				break;
			case Jack:
				path += "50.png";
				break;
			case Joker:
				path += "53.png";
				break;
			}
		}
		Image image = new Image(path);
		return image;
	}
	
	public Image getImage(boolean hidden) {
		if(hidden) {
			return new Image("file:cardImages/b1fv.png");
		} else {
			return getImage();
		}
		
	}
	
	public static Card randomCard() {
		Random r = new Random();
		int randomNumber = r.nextInt(CardNumber.values().length);
		int randomSuit = r.nextInt(CardSuit.values().length-1);
		CardNumber randomcardNumber = CardNumber.values()[randomNumber];
		CardSuit randomCardSuit = CardSuit.values()[randomSuit];
		return new Card(randomcardNumber,randomCardSuit);
	}
	
	public static int getValue(Card card) {
		int cardValue = 0;
		switch (card.getCardNumber()) { // CardNumer Check
		case Ace:
			cardValue = 1;
			break;
		case Two:
			cardValue = 2;
			break;
		case Three:
			cardValue = 3;
			break;
		case Four:
			cardValue = 4;
			break;
		case Five:
			cardValue = 5;
			break;
		case Six:
			cardValue = 6;
			break;
		case Seven:
			cardValue = 7;
			break;
		case Eight:
			cardValue = 8;
			break;
		case Nine:
			cardValue = 9;
			break;
		case TEN:
			cardValue = 10;
			break;
		case Queen:
			cardValue = 11;
			break;
		case King:
			cardValue = 12;
			break;
		case Jack:
			cardValue = 13;
			break;
		case Joker:
			cardValue = 14;
			break;
		}
		return cardValue;
	}
	
}
