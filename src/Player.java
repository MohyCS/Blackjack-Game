
public class Player {
  
  String theName;
  int theBalance;
  int theWage;
  int score=0;
  boolean stand = false;
  boolean doubledown = false;
  boolean hasSecondHand = false;
  Card[] myHand = new Card[12];
  int insurance=0;
  boolean hasInsurance = false;
  Hand currenthand ;
  
  Card[] secondHand;
  int secondScore = 0;
  
  public Player(String name){
    theName = name;
  }
  public String PlayerName(){
    return theName;
    
  }
  
  public String getName(){
    return theName;
    
  }
  
  public void setHand()
  {
    currenthand = new Hand(myHand); 
  }
  
  public Hand getHand()
  {
    return currenthand; // replace this line with your code
    
  }
  
  
  public int PlayerBalance(int balance){
    theBalance = balance;
    return theBalance;
  }
  
  public int PlayerWage (int wage) {
    
    theWage = wage;
    return theWage;
    
  } 
  
  public String toString(){
    return theName + " [balance: " + theBalance + "]";
  }
  
  public int PlayerScore(int card){
    score += card;
    return score;
  }
  
  public int PlayerSecondHandScore(int card){
    secondScore += card;
    return secondScore;
  }
  
  public void Stand(boolean a){
    stand = a;
  }
  
  public void otherHand(){
    this.secondHand=new Card[12];
    
    
  }
  
  
  
}