package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck(String deckName) {
		setDeckName(deckName);
		setCardsInDeck(new ArrayList<CardCounter>());
	}
	
	public void addCard(UnitCard newCard, int count) {
		if (count <= 0) {
			return;
		}
		if (existsInDeck(newCard)) {
			for (CardCounter c : cardsInDeck) {
				if (newCard.equals(c.getCard())) {
					c.setCount(c.getCount() + count);
					return;
				}

			}
		} else {
			CardCounter newCardCounter = new CardCounter(newCard, count);
			cardsInDeck.add(newCardCounter);
		}
	}
	
	public void removeCard(UnitCard toRemove, int count) {
		if (!existsInDeck(toRemove) || count <= 0) {
			return;
		}
		for (CardCounter c : cardsInDeck) {
			if (toRemove.equals(c.getCard())) {
				c.setCount(c.getCount() - count);
				if (c.getCount() <= 0) {
					cardsInDeck.remove(c);
				}
				return;
			}
		}
	}
	
	public int cardCount() {
		int count = 0;
		for (CardCounter c : cardsInDeck) {
			count += c.getCount();
		}
		return count;
	}
	
	public boolean existsInDeck (UnitCard card) {
		for (CardCounter c : cardsInDeck) {
			if (c.getCount() >= 1 && c.getCard().equals(card)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(UnitDeck other) {
		return this.deckName.equals(other.getDeckName());
	}
	
	public void setDeckName(String name) {
		if (name.isBlank()) {
			this.deckName = "Untitled Deck";
		} else {
			this.deckName = name;
		}
	}
	
	public String getDeckName() {
		return deckName;
	}
	
	public void setCardsInDeck(ArrayList<CardCounter> deck) {
		this.cardsInDeck = deck;
	}
	
	public ArrayList<CardCounter> getCardsInDeck(){
		return cardsInDeck;
	}
	
}
