// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
  // define fields here
  
  int numOfCards = 52;
  //private int cardsPlayed;
  
  private Card[] deck;
  public int cardsDrawn;
  
  
  
  
  // This constructor builds a deck of 52 cards.
  public Deck()
  {
    this.deck = new Card[numOfCards];
    int index = 0;
    for (int i=0; i<4; i++) {
      for (int k = 1; k<14; k++) {
        this.deck[index] = new Card (i,k);
        index++;
      }  
    }
    
  }
  
  
  
  
  // This method takes the top card off the deck and returns it.
  public Card deal()
  {
      if (cardsDrawn == numOfCards) {
        System.out.println("We have run out of cards! The deck has been reset and reshuffled!");
        shuffle();
        cardsDrawn++;
    }
      cardsDrawn++;
      
      return deck[cardsDrawn - 1];
    
  }
  
  
  // this method returns true if there are no more cards to deal, false otherwise
  public boolean isEmpty()
  {
    if ( numOfCards == cardsDrawn) {
      return true;
    } else {
      return false;
    }
    //fill this method in
  }
  
  //this method puts the deck int some random order
  public void shuffle(){
    for (int i=numOfCards-1; i>0; i--) {
      int random = (int) (Math.random()*(1+i));
      Card temp = deck[i];
      deck[i] = deck[random];
      deck[random] = temp;
    }
    cardsDrawn = 0;
    //fill this method in
  }
  
  public Card[] getDeck(){
    return this.deck;
  }
  
}