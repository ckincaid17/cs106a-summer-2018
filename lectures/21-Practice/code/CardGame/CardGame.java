import acm.program.ConsoleProgram;

public class CardGame extends ConsoleProgram{

	public void run() {
		Deck cardDeck = new Deck();
		cardDeck.shuffle();
		
		for(int i = 0; i < 52; i++) {
			String card = cardDeck.getTopCard();
			println(card);
		}
	}
	
	public void init() {
		setFont("Courier-36");
	}
	
}
