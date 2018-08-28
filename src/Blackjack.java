// This is the main program for the blackjack game.
public class Blackjack
{
  // This method should:
  //  - Ask the user how many people want to play (up to 3, not including the dealer).
  //  - Create an array of players.
  //  - Create a Blackjack window.
  //  - Play rounds until the players want to quit the game.
  //  - Close the window.
  public static void main(String[] args)
  {
  
    // TODO Auto-generated method stub
    
    int numOfPlayers; //will hold the num of players the user would like to have
    int wage; //will hold the wager amount of each player
    
    //Asking for # of players, if more than 6 is inputed then ask for # of players again
     do {
      
      
      numOfPlayers = GIO.readInt("Enter number of players");//IO.readInt();
    } while (numOfPlayers > 6 || numOfPlayers < 1); //ensuring that no more than 6 players are accepted
    
    Player[] players = new Player[numOfPlayers]; //array of player objects made of size given by user
    BlackjackWindow obj;// = new BlackjackWindow(players);  
    
    Deck objectHere = new Deck(); //deck and card objects made
    //Card otherObjectHere = new Card(0, 1);
    Dealer dealerObject = new Dealer();
    
    //Asking for player names and balances (storing them with Player class methods)
    for (int i = 1; i <= numOfPlayers; i++) {
      int k = i - 1;
      
      String daName = GIO.readString("Enter the name of player " + i);
      
      players[k] = new Player(daName);
      
      int balance = GIO.readInt("Enter the balance of " + daName + ": player " + i);
      players[k].PlayerBalance(balance);
      k++;
    }
    
    
    
    
    
    
      boolean startGame = true;
        do {//starts first round!!!!
      
            for (int i = 0; i < players.length; i++) { //Ask for amount of money players would like to wager

                //String name = players[i];
                do {
          
                    
                    wage = GIO.readInt("How much would " + players[i] + " like to wager?");
                    players[i].PlayerWage(wage);

                } while (players[i].theWage > players[i].theBalance || players[i].theWage <= 0);
            }
      
            for (int i = 0; i < players.length; i++) {//set every player's score to integer ZERO
                players[i].score = 0;
        
                for (int secondScore = 0; secondScore < players.length; secondScore++) { //setting second Hand score to integer ZERO
                    players[i].secondScore = 0;
                    players[i].hasSecondHand = false;
          
                }
            }
      
      
      
            dealerObject.score = 0; //set dealer's score to integer ZERO
      
            //We get the standard non-shuffled deck
            objectHere.getDeck();
      
            //We shuffle the deck
            objectHere.shuffle();
            //int mark = 0;
            //Now we deal 2 cards face up to every player.
                  
            for (int p = 0; p < players.length; p++) {
                for (int i = 0; i < 2; i++) {
                    players[p].myHand[i] = objectHere.deal();
                     
                    players[p].PlayerScore(players[p].myHand[i].getValue());
                    players[p].myHand[i].turnFaceUp();
                    players[p].setHand();
                    //GIO.displayMessage("Player: " + players[p].theName + " has recieved: " + (players[p].myHand[i].getFaceStr() + " of " + (players[p].myHand[i].getSuitStr())));
                }
                
        
                    if ( players[p].myHand[1].getFaceStr() == players[p].myHand[0].getFaceStr()) {
                    
                    String split = GIO.readString(players[p].theName + " has the option to split, would you like to split?");
                    if (split.equalsIgnoreCase("YES") && (players[p].theWage * 2 <= players[p].theBalance)) {
                        if (players[p].theWage * 2 <= players[p].theBalance) {
                            GIO.displayMessage("You now have a second hand " + players[p].theName);
                            //GIO.displayMessage(players[p].myHand[1].getFaceStr() + " of " + players[p].myHand[1].getSuitStr() + " is now in a second hand!");
                            players[p].otherHand(); //giving player a second hand array of card
                            players[p].hasSecondHand = true; //boolean set to true to know which players have a second hand
                            players[p].secondHand[0] = players[p].myHand[1]; //putting the second card of the first hand into the second hand
                            players[p].myHand[1] = null; //setting the second card of the first hand to NULL
              players[p].secondHand[0].turnFaceUp();
                            //GIO.displayMessage(players[p].theName + " is now dealt a card for the second hand!");
              
                            players[p].secondHand[1] = objectHere.deal();
                            players[p].PlayerScore(players[p].secondHand[1].getValue());
                            //GIO.displayMe
              //ssage("Player: " + players[p].theName + " has recieved: " + (players[p].secondHand[1].getFaceStr() + " of " + (players[p].secondHand[1].getSuitStr())));
                            players[p].PlayerSecondHandScore(players[p].secondHand[1].getValue());
              
                              players[p].setHand();
              
                        } else {
                            GIO.displayMessage(players[p].theName + " does not have enough money to split!");
              
              
                        }
                        players[p].myHand[1] = objectHere.deal();
                        players[p].PlayerScore(players[p].myHand[1].getValue());
                        players[p].setHand();
                      //  GIO.displayMessage(players[p].theName + " has been dealt " + players[p].myHand[1] + " for their first hand!");
            
                    }
                }
                GIO.displayMessage(players[p].theName + " has " + players[p].score + " points for their first hand");
                if (players[p].hasSecondHand == true) {
                    GIO.displayMessage(players[p].theName + " has " + players[p].secondScore + " points on the second hand!");
                }
            }
      
      obj = new BlackjackWindow(players);  
                //obj.redraw();
             //obj.redraw();
      
            //Now we deal 2 cards to the dealer! One card must be face down and unseen to the players
            dealerObject.dealerHand[0] = objectHere.deal();
            dealerObject.dealerScore(dealerObject.dealerHand[0].getValue());
            dealerObject.dealerHand[0].turnFaceUp();
            dealerObject.dealerHand[1] = objectHere.deal();
            dealerObject.dealerScore(dealerObject.dealerHand[1].getValue());
            //obj.redraw();
           // GIO.displayMessage("The dealer has recieved " + dealerObject.dealerHand[0].getFaceStr() + " of " + dealerObject.dealerHand[0].getSuitStr());
            int size = numOfPlayers;
      GIO.displayMessage(size + "");
      Player[] newplayerswithdealer = new Player[numOfPlayers+1];
       for (int i = 1; i <= numOfPlayers; i++) {
        int k = i - 1;
        newplayerswithdealer[k] =players[k];
        }
      //     
            /*
            newplayerswithdealer[size] = new Player("Dealer");
            newplayerswithdealer[size-1].myHand = dealerObject.dealerHand;
            newplayerswithdealer[size-1].setHand();
            //newplayerswithdealer[numOfPlayers+1].score =  dealerObject.score;
            newplayerswithdealer[size-1].myHand[0].turnFaceUp();
            //newplayerswithdealer[numOfPlayers+1].myHand[1] = dealerObject.dealerHand[1];
            newplayerswithdealer[size-1].score =   dealerObject.score;
            
            obj = new  BlackjackWindow(   newplayerswithdealer );
      
            
              */
            obj.redraw();                                     
            // add insurance
            if(dealerObject.dealerHand[0].getFaceStr() =="ACE")
            {
                  for (int i = 0; i < players.length; i++) {
                    
                     String choice = GIO.readString("Would " + players[i].theName + " like to add insurance");
                     if(choice.equalsIgnoreCase("yes"))
                     {
                         players[i].hasInsurance = true;
                         
                          int insurance = GIO.readInt("what is amount of insurance ");
                          players[i].insurance = insurance;
                          players[i].theBalance =  players[i].theBalance - insurance;
                       
                     }
                  }
            }
            GIO.displayMessage("The card below will be hidden in the next milestone!");
            
            GIO.displayMessage("The dealer has recieved " + dealerObject.dealerHand[1].getFaceStr() + " of " + dealerObject.dealerHand[1].getSuitStr());
                   
            GIO.displayMessage("The dealer's second card is face down");
            GIO.displayMessage("Note for checking: Dealer current score is- " + dealerObject.score);
      
            //boolean hit = false;
            //int standCounter = 0;
      
            //int playerTurn = 0;

            for (int i = 0; i < players.length; i++) {
                //for (int k=2; hit==false; k++){
                  GIO.displayMessage (getHints(players[i],dealerObject,false));
                  
                String choice = GIO.readString("Would " + players[i].theName + " like to 'HIT' or 'STAND' or 'DOUBLE'  for their first hand?");
                if(choice.equalsIgnoreCase("DOUBLE"))
                {
                    players[i].doubledown = true;
                    
                    int wageincrease = GIO.readInt("How much would " + players[i].PlayerName() + " like to increase the wage " +   players[i].theWage + " ? ");
                    while(wageincrease > players[i].theWage)
                    {
                         GIO.displayMessage(" your wage increase cann't exceed " +  players[i].theWage);
                         
                         wageincrease = GIO.readInt("How much would " + players[i].PlayerName() + " like to increase the wage " +   players[i].theWage + " ? ");
                    }
                     wageincrease =  wageincrease + players[i].theWage;
                     players[i].PlayerWage(wageincrease);
                     GIO.displayMessage("your current wage  " +  players[i].theWage);
                     
                      
                      
                      choice = GIO.readString("Would " + players[i].theName + " like to 'HIT' or 'STAND'  for their first hand?");
                    
                }
                while (choice.equalsIgnoreCase("HIT")) {
                    for (int k = 0; k < 2; k++) {
                        players[i].myHand[k] = objectHere.deal();
                        GIO.displayMessage("Player: " + players[i].theName + " has recieved: " + (players[i].myHand[k].getFaceStr() + " of " + (players[i].myHand[k].getSuitStr())));
                        GIO.displayMessage(players[i].theName + " has " + players[i].PlayerScore(players[i].myHand[k].getValue()) + " points");
            
                        if (players[i].score > 21) {
                            GIO.displayMessage(players[i].theName + " HAS BUSTED !");
              
                            choice = "stand";
                            break;
                        }
                        GIO.displayMessage (getHints(players[i],dealerObject,false));        
                        
                        choice = GIO.readString("Would " + players[i].theName + " still like to 'HIT' or 'STAND' or 'DOUBLE' ?");
                        
               if(choice.equalsIgnoreCase("DOUBLE"))
                {
                    players[i].doubledown = true;
                    
                    int wageincrease = GIO.readInt("How much would " + players[i].PlayerName() + " like to increase the wage " +   players[i].theWage + " ? ");
                    while(wageincrease > players[i].theWage)
                    {
                         GIO.displayMessage(" your wage increase cann't exceed " +  players[i].theWage);
                         
                         wageincrease = GIO.readInt("How much would " + players[i].PlayerName() + " like to increase the wage " +   players[i].theWage + " ? ");
                    }
                     wageincrease =  wageincrease + players[i].theWage;
                     players[i].PlayerWage(wageincrease);
                     GIO.displayMessage("your current wage  " +  players[i].theWage);
                     
                        choice = GIO.readString("Would " + players[i].theName + " still like to 'HIT' or 'STAND' or 'DOUBLE' ?");
                }
                         
                        if (choice.equalsIgnoreCase("stand")) {
                            break;
                        }
            
                    }
                }
                if (players[i].hasSecondHand == true) {
                    
                    GIO.displayMessage(getHints(players[i],dealerObject,true));        
                    String otherChoice = GIO.readString("Would " + players[i].theName + " like to 'HIT' or 'STAND'  for their second hand?");
                    while (otherChoice.equalsIgnoreCase("HIT")) {
                        for (int k = 0; k < 2; k++) {
                            players[i].secondHand[k] = objectHere.deal();
                            GIO.displayMessage("Player: " + players[i].theName + " has recieved: " + (players[i].secondHand[k].getFaceStr() + " of " + (players[i].secondHand[k].getSuitStr())));
                            GIO.displayMessage(players[i].theName + " has " + players[i].PlayerSecondHandScore(players[i].secondHand[k].getValue()) + " points");
              
                            if (players[i].secondScore > 21) {
                                GIO.displayMessage(players[i].theName + " HAS BUSTED  on their SECOND hand!");

                                otherChoice = "stand";
                                break;
                            }
                            GIO.displayMessage(getHints(players[i],dealerObject,true));                
                            
                            otherChoice = GIO.readString("Would " + players[i].theName + " still like to 'HIT' or 'STAND' on their second hand?");
                            if (otherChoice.equalsIgnoreCase("stand")) {
                                break;
                            }

                        }
                    }
                }

                //}
            }
            for (int k = 0; dealerObject.score < 17; k++) {

                GIO.displayMessage("The dealer has HIT !");
                dealerObject.dealerHand[k] = objectHere.deal();
                GIO.displayMessage("The dealer has recieved " + dealerObject.dealerHand[k].getFaceStr() + " of " + dealerObject.dealerHand[k].getSuitStr());
                dealerObject.dealerScore(dealerObject.dealerHand[k].getValue());
                if(k==0 && dealerObject.dealerHand[0].getValue()==10)
                {
                     for (int i = 0; i < players.length; i++) {
                     
                     if(players[i].hasInsurance == true)
                     {
                        int insurancegain=  players[i].insurance  * 2  ;
                          players[i].theBalance = (players[i].theBalance +   insurancegain);
                          
                          GIO.displayMessage(players[i].theName + "'s new balance after Insurance bet is: " + players[i].theBalance);
                       
                     }
                  }
                }
                GIO.displayMessage("Note for checking: Dealer current score is- " + dealerObject.score);
                if (dealerObject.score > 21) {
                    dealerObject.bust = true;
                    GIO.displayMessage("The dealer has BUSTED ! ");
                }
            }
            if (dealerObject.bust == false) {
                GIO.displayMessage("The dealer has chosen to stand! He holds a score of... " + dealerObject.score);
            }

            for (int i = 0; i < players.length; i++) {

                if (players[i].score < 22 && dealerObject.score < 22 && players[i].score > dealerObject.score) { //win
                    GIO.displayMessage(players[i].theName + " has WON! ");
                    int winnings = players[i].theBalance + players[i].theWage;
                    players[i].theBalance = winnings;
                    GIO.displayMessage(players[i].theName + "'s new balance is: " + players[i].theBalance);

                } else if (players[i].score < 22 && dealerObject.score < 22 && players[i].score < dealerObject.score) { //lose
                    GIO.displayMessage(players[i].theName + " has LOST! ");
                    int losings = players[i].theBalance - players[i].theWage;
                    players[i].theBalance = losings;
                    GIO.displayMessage(players[i].theName + "'s new balance is: " + players[i].theBalance);

                } else if (!(players[i].score < 22) && dealerObject.score < 22) { //lose
                    GIO.displayMessage(players[i].theName + " has LOST! ");
                    int losings = players[i].theBalance - players[i].theWage;
                    players[i].theBalance = losings;
                    GIO.displayMessage(players[i].theName + "'s new balance is: " + players[i].theBalance);

                } else if (players[i].score < 22 && dealerObject.score >= 22) { //win
                    GIO.displayMessage(players[i].theName + " has WON! ");
                    int winnings = players[i].theBalance + players[i].theWage;
                    players[i].theBalance = winnings;
                    GIO.displayMessage(players[i].theName + "'s new balance is: " + players[i].theBalance);

                } else if (players[i].score >= 22 && dealerObject.score > 22) {
                    GIO.displayMessage("Both " + players[i].theName + " AND  the dealer have busted. Nobody gains or loses money and the wages are returned !");
                } else if (players[i].score < 22 && dealerObject.score < 22 && players[i].score == dealerObject.score) {
                    GIO.displayMessage("Both " + players[i].theName + " AND the Dealer have busted. Nobody gains or loses money and the wages are returned !");
                }
            }

            for (int i = 0; i < players.length; i++) {
                if (players[i].hasSecondHand == true) {
                    if (players[i].secondScore < 22 && dealerObject.score < 22 && players[i].secondScore > dealerObject.score) { //win
                        GIO.displayMessage(players[i].theName + " has WON with their second hand! ");
                        int winnings = players[i].theBalance + players[i].theWage;
                        players[i].theBalance = winnings;
                        GIO.displayMessage(players[i].theName + "'s new balance is: " + players[i].theBalance);

                    } else if (players[i].secondScore < 22 && dealerObject.score < 22 && players[i].secondScore < dealerObject.score) { //lose
                        GIO.displayMessage(players[i].theName + " has LOST with their second hand! ");
                        int losings = players[i].theBalance - players[i].theWage;
                        players[i].theBalance = losings;
                        GIO.displayMessage(players[i].theName + "'s new balance is: " + players[i].theBalance);

                    } else if (!(players[i].secondScore < 22) && dealerObject.score < 22) { //lose
                        GIO.displayMessage(players[i].theName + " has LOST with their second hand! ");
                        int losings = players[i].theBalance - players[i].theWage;
                        players[i].theBalance = losings;
                        GIO.displayMessage(players[i].theName + "'s new balance is: " + players[i].theBalance);
              
                    } else if (players[i].secondScore < 22 && dealerObject.score >= 22) { //win
                        GIO.displayMessage(players[i].theName + " has WON with their second hand! ");
                        int winnings = players[i].theBalance + players[i].theWage;
                        players[i].theBalance = winnings;
                        GIO.displayMessage(players[i].theName + "'s new balance is: " + players[i].theBalance);

                    } else if (players[i].secondScore >= 22 && dealerObject.score > 22) {
                        GIO.displayMessage("Both " + players[i].theName + " AND  the dealer have busted. Nobody gains or loses money and the wages are returned for their second hand !");
                    } else if (players[i].secondScore < 22 && dealerObject.score < 22 && players[i].secondScore == dealerObject.score) {
                        GIO.displayMessage("Both " + players[i].theName + " AND the Dealer have busted. Nobody gains or loses money and the wages are returned for their second hand!");
                    }
                }
            }
    
            String gameOn = GIO.readString("Would you like to play another round? Enter: 'YES' OR 'NO' ");
            if (gameOn.equalsIgnoreCase("YES")) {
                startGame = true;
            } else {
                startGame = false;
            }
      //obj.redraw();      
        } while (startGame == true);
         
        return; //stops running the game was the user has chosen to NOT play another round

    
  }
    
    // get hints for user
    public static String getHints(Player player,Dealer dealer, boolean secondhand)
    {
   String  hint=""; 
   
   if(secondhand==true)
   {    
       
           
    
        
        if(player.secondScore==8)
        {
            if(dealer.score==5 || dealer.score==6 )
            {
                hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }   
        }
        
        else if (player.secondScore== 9)
        {
            if( dealer.score>=2 && dealer.score<=6 )
            {
                hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        else if (player.secondScore== 11)
        {
           hint = "we recommend to Double in this play";
        }
        else if (player.secondScore== 10)
        {
            if( dealer.score>=2 && dealer.score<=9 )
            {
                hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        else if (player.secondScore== 12)
        {
            if( dealer.score>=4 && dealer.score <=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        else if (player.secondScore== 12)
        {
            if( dealer.score>=4 && dealer.score<=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        else if (player.secondScore>=13 && player.secondScore<=16)
        {
            if( dealer.score>=2 && dealer.score<=6 )
            {
                 hint = "we recommend to Stand in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        
        else if (player.secondScore>=17 && player.secondScore<=21)
        {
                hint = "we recommend to Stand in this play";
            
        }
         else if (player.secondScore>=12 && player.secondScore<=15)
        {
            if( dealer.score>=4 && dealer.score<=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        else if (player.secondScore>=16)
        {
            if( dealer.score>=2 && dealer.score<=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        else if (player.secondScore>=17)
        {
            if( dealer.score>=3 && dealer.score<=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else if( dealer.score==2 || dealer.score==7  || dealer.score==8 || dealer.score==10)
            {
                hint = "we recommend to Hit in this play";
            }
        }
        else if (player.secondScore>=18)
        {
            if( dealer.score==6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
         else if (player.secondScore==19)
        {
           
                hint = "we recommend to Stand in this play";
         }
        
        else if (player.secondScore==20)
        {
           
                hint = "we recommend to split in this play";
         }
        
    
   }
   else
   {
    if(player.score==8)
        {
            if(dealer.score==5 || dealer.score==6 )
            {
                hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }   
        }
        
        else if (player.score== 9)
        {
            if( dealer.score>=2 && dealer.score<=6 )
            {
                hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        else if (player.score== 11)
        {
           hint = "we recommend to Double in this play";
        }
        else if (player.score== 10)
        {
            if( dealer.score>=2 && dealer.score<=9 )
            {
                hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        else if (player.score== 12)
        {
            if( dealer.score>=4 && dealer.score <=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        else if (player.score== 12)
        {
            if( dealer.score>=4 && dealer.score<=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        else if (player.score>=13 && player.score<=16)
        {
            if( dealer.score>=2 && dealer.score<=6 )
            {
                 hint = "we recommend to Stand in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        
        else if (player.score>=17 && player.score<=21)
        {
                hint = "we recommend to Stand in this play";
            
        }
         else if (player.score>=12 && player.score<=15)
        {
            if( dealer.score>=4 && dealer.score<=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        else if (player.score>=16)
        {
            if( dealer.score>=2 && dealer.score<=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
        
        else if (player.score>=17)
        {
            if( dealer.score>=3 && dealer.score<=6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else if( dealer.score==2 || dealer.score==7  || dealer.score==8 || dealer.score==10)
            {
                hint = "we recommend to Hit in this play";
            }
        }
        else if (player.score>=18)
        {
            if( dealer.score==6 )
            {
                 hint = "we recommend to Double in this play";
            }
            else 
            {
                hint = "we recommend to Hit in this play";
            }
        }
         else if (player.score==19)
        {
           
                hint = "we recommend to Stand in this play";
         }
        
        else if (player.score==20)
        {
           
                hint = "we recommend to split in this play";
         }
    }
        
        return hint;
        
        
    
    


    }

}