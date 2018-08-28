// This class represents the set of cards held by one player (or the dealer).
public class Hand
{
  // define fields here
  Card[] myHand; 
  // This constructor builds a hand (with no cards, initially).
  public Hand(Card[] TheHand)
  {
    myHand  =  TheHand;
    // complete this method
  }
  
  // This method retrieves the size of this hand.
  public int getNumberOfCards()
  {
    return myHand.length; // replace this line with your code
  }
  
  // This method retrieves a particular card in this hand.  The card number is zero-based.
  public Card getCard(int index)
  {
    return myHand[index]; // replace this line with your code
  }
  
  // This method takes a card and places it into this hand.
  public void addCard(Card newcard)
  {
    // complete this method
  }
  
  // This method computes the score of this hand.
  public int getScore()
  {
    return 0; // replace this line with your code
  }
  
  // This methods discards all cards in this hand.
  public void discardAll()
  {
    // complete this method
  }
}