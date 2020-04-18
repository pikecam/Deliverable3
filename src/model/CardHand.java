package model;

import java.util.ArrayList;
import java.util.Random;

public class CardHand {
	public ArrayList<Card> cardHand = new ArrayList<>();

	public CardHand() {

	}

	public ArrayList<Card> getCardHand() {
		return cardHand;
	}

	public void shuffle() {
		Random r = new Random();
		int min = 1;
		int max = 54;
		int randomIndex1 = r.nextInt((max - min) + 1) + min;
		int randomIndex2 = r.nextInt((max - min) + 1) + min;
		int randomShuffleIterate = 52;
		for (int i = 0; i < randomShuffleIterate; i++) {
			Card temp = cardHand.get(randomIndex1);
			cardHand.set(randomIndex1, cardHand.get(randomIndex2));
			cardHand.set(randomIndex2, temp);
		}
	}

	public void shuffle(int rounds) {
		if (rounds <= 0) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < rounds; i++) {
				shuffle();
			}
		}
	}

	
}
