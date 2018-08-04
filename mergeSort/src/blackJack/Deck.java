package blackJack;

import java.util.List;
import java.util.Random;

public class Deck {
	
	public List<Card> cards;
	public Random random = new Random();
	
	public Deck() {
		
	}
	
	public void shuffle(List<Card> cards) {
		//reset card deck
		for(int i = 0; i < 52; i++) {
			int rand = random.nextInt(51 - i);
			Card m = cards.get(51 - i);
			Card n = cards.get(rand);
			cards.set(51 - i, n);
			cards.set(rand, n);
		}
	}
	
	public Card deal() {
		return cards.remove(0);
	}

}
