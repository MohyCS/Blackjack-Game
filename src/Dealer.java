
public class Dealer {

	Card[] dealerHand = new Card[13];
	int score=0;
	boolean bust = false;
	public void dealerScore(int a){
		
		score+= a;
	}
	
}