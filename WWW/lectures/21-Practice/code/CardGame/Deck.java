import java.util.ArrayList;

import java.util.Collections;

import acm.util.RandomGenerator;

public class Deck {

	// some constants
	private static final String ROYALS = "JQKA";
	private static final String SUITS = "CDHS";

	// every deck "has a" list of cards
	private ArrayList<String> cards = new ArrayList<String>();

	public Deck() {
		// make cards with value 1 -> 10
		for(int i = 1; i <= 10; i++) {
			for(int j = 0; j < SUITS.length(); j++) {
				String card = "" + i + SUITS.charAt(j);
				cards.add(card);
			}
		}
		// make cards with value J -> A
		for(int i = 0; i < ROYALS.length(); i++) {
			for(int j = 0; j < SUITS.length(); j++) {
				String card = "" + ROYALS.charAt(i) + SUITS.charAt(j);
				cards.add(card);
			}
		}
	}

	public void shuffle() {
		RandomGenerator rg = RandomGenerator.getInstance();
		ArrayList<String> shuffle = new ArrayList<String>();
		while(!cards.isEmpty()) {
			int index = rg.nextInt(cards.size());
			String card = cards.get(index);
			cards.remove(index);
			shuffle.add(card);
		}
		cards = shuffle;
	}

	public String getTopCard() {
		String card = cards.get(cards.size() - 1);
		cards.remove(cards.size() - 1);
		return card;
	}

}
