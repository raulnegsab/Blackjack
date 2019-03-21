//provided by Raul Cuevas.

package proyecto;

import java.util.Random;
import java.util.Stack;

public class Deck {
	Stack<Cards> cards;
	int numberOfDecks;

	public Deck() {
		super();
		this.cards = new Stack<Cards>();
		for(Cards c: Cards.values()){
			if(this.cards.isEmpty()){
				this.cards.push(c);
			}
			else{
				this.cards.add(new Random().nextInt(this.cards.size() + 1), c);
			}
		}
	}

	public Deck(int numOfDecks) {
		super();
		this.numberOfDecks = numOfDecks;
		this.cards = new Stack<Cards>();
		if(numOfDecks > 0){
			for(int i = 0; i < this.numberOfDecks; i++){
				for(Cards c: Cards.values()){
					if(this.cards.isEmpty()){
						this.cards.push(c);
					}
					else{
						this.cards.add(new Random().nextInt(this.cards.size() + 1), c);
					}
				}
			}
		}
	}

	public Cards DrawTopCard() throws EmptyDeckException{
		if(this.cards.isEmpty())
			throw new EmptyDeckException();
		return this.cards.pop();
	}
	
	@SuppressWarnings("serial")
	public class EmptyDeckException extends Exception {
		public EmptyDeckException() {
			super("The deck is empty.");
		}

		public EmptyDeckException(String msg) {
			super(msg);
		}
	}

	@Override
	public String toString() {
		String cardsString = "";
		for(int i = 0; i < cards.size(); i++){
			cardsString += cards.get(i) + ",\n";				
		}
		return "Deck [cards=\n" + cardsString + "number of decks = " + numberOfDecks + "]";
	}
}
