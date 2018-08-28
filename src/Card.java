// This class represents one playing card.
public class Card
{
  // Card suits (provided for your convenience - use is optional)
  public static final int SPADES   = 0;
  public static final int HEARTS   = 1;
  public static final int CLUBS    = 2;
  public static final int DIAMONDS = 3;
  
  // Card faces (provided for your convenience - use is optional)
  
  public static final int ACE      = 1;
  public static final int TWO      = 2;
  public static final int THREE    = 3;
  public static final int FOUR     = 4;
  public static final int FIVE     = 5;
  public static final int SIX      = 6;
  public static final int SEVEN    = 7;
  public static final int EIGHT    = 8;
  public static final int NINE     = 9;
  public static final int TEN      = 10;
  public static final int JACK     = 11;
  public static final int QUEEN    = 12;
  public static final int KING     = 13;
  
  
  
  
  // define fields here
  int suit;
  int face;
  
  boolean isfaceup = false;
  
  // This constructor builds a card with the given suit and face, turned face down.
  public Card(int cardSuit, int cardFace)
  {
    suit = cardSuit;
    face = cardFace;
    //fill in this method
  }
  
  // This method retrieves the suit (spades, hearts, etc.) of this card.
  public String getSuitStr()
  {
    if (suit == 0) {
      return ("SPADES");
      
    } else if (suit == 1) {
      return ("HEARTS");
    } else if (suit == 2) {
      return ("CLUBS");
    } else if ( suit == 3) {
      return ("DIAMONDS");
    }
    return null;
  }
  
  // This method retrieves the face (ace through king) of this card.
  public String getFaceStr()
  {
    if (face == 1 || face == 0) {
      return ("ACE");
    } else if (face == 2){
      return ("TWO");
    } else if (face == 3){
      return ("THREE");
    } else if (face == 4){
      return ("FOUR");
    } else if (face == 5){
      return ("FIVE");
    } else if (face == 6){
      return ("SIX");
    } else if (face == 7){
      return ("SEVEN");
    } else if (face == 8){
      return ("EIGHT");
    } else if (face == 9){
      return ("NINE");
    } else if (face == 10){
      return ("TEN");
    }
    return "TEN";
    
  }
  
  // This method retrieves the numerical value of this card
  // (usually same as card face, except 1 for ace and 10 for jack/queen/king)
  public int getValue()
  {
    if (face == KING || face == QUEEN || face == JACK) {
      face = 10;
      return face;
    } else if (face == ACE){
      face = 1;
      return face;
    } else {
      return face;
    }
    
    
  }
  
  
  
  // This method retrieves the suit (spades, hearts, etc.) of this card.
  public int getSuit()
  {
      return suit; // replace this line with your code
  }
  
  // This method retrieves the face (ace through king) of this card.
  public int getFace()
  {
      return face; // replace this line with your code
  }
  
  // This method determines whether the front of the card should be visible.
  public boolean isFaceUp()
  {
      return isfaceup; // replace this line with your code
  }
  
  // This method records that the front of the card should be visible.
  public void turnFaceUp()
  {
    isfaceup = true;
      // complete this method
  }
  
  // This method records that only the back of the card should be visible.
  public void turnFaceDown()
  {
    isfaceup = false;    
  // complete this method
    }
  
  
  public String toString(){
    return face + " " + suit;
  }
}