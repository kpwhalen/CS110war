/**
	A class for the War Card game.	
	@author Kyle Whalen 
*/


public class War
{
   private Deck cardDeck;
   private Deck p1Cards;
   private Deck p2Cards; 
   private Card p1TopCard, p2TopCard, p1FDCard, p2FDCard, p1UPCard, p2UPCard;
   private String winnerMsg;
   private boolean warFlag; 
   
   /**
		Constructor to create Deck of Cards and shuffle them..
   */	 
   
   public War()
   {
      cardDeck = new Deck();         
      cardDeck.shuffle();  
   }
   
   /**
		Returns the cardDeck
		@return cardDeck
	*/	
   		
   public Deck getHand()
   {
      return cardDeck;
   }
   
   /**
		Returns Player 1 hand of cards
		@return p1Cards
	*/	   
   
   public Deck getP1Hand()
   {
      return p1Cards;   
   }
   
   /**
		Returns Player 2 hand of cards
		@return p2Cards
	*/
   
   public Deck getP2Hand()
   {
      return p2Cards;
   }
   
   /**
		Deals the cards into hands p1Cards and p2Cards. 	
   */
   
   public void deal()
   {
      //Creates Player1's Card Pile
      p1Cards = new Deck();
      p1Cards.clear();
   
      //Creates Player2's Card Pile
      p2Cards  = new Deck();
      p2Cards.clear();
      
      //Takes the cardDeck and splits them up into 2 piles for Player1 and Player2
      for(int i = 0; i < 26; i++)
      {
         p1Cards.add(cardDeck.getTopCard());
         p2Cards.add(cardDeck.getTopCard());
      }
   }

   /**
		Takes the top card off of the deck arrays. 
   */
    
   public void flip()
   {
      p1TopCard = p1Cards.getTopCard();
      p2TopCard = p2Cards.getTopCard();
   }
     
   /**
		Get the card image for Player 1's top Card.
   	@return p1TopCard String representing card image filename. 
   */

   public String getP1TopCard()
   {
      return p1TopCard.toName();     
   }
    
   /**
		Get the card image for Player 2's top Card.
  	   @return p2TopCard String representing card image filename.
   */  
   
   public String getP2TopCard()
   {
     return p2TopCard.toName();  
   }

   /**
		Get the card image for Player 1's UP war Card.
  		@return p1UpCard String representing card image filename.
   */ 
 
   public String getP1UPCard()
   {
     return p1UPCard.toName();  
   }
   
   /**
		Get the card image for Player 2's UP war Card.
   	@return p2UpCard String representing card image filename. 
   */  
   
   public String getP2UPCard()
   {
      return p2UPCard.toName(); 
   }
   
   /**
		Get number of cards in Player 1's hand. 
      @return p1Cards Number (integer) of P1's cards. 
   */  
    
   public int getP1Count()
   {
      return p1Cards.size();
   }

   /**
		Get number of cards in Player 2's hand. 
      @return p2Cards Number (integer) of P2's cards. 
   */
   
   public int getP2Count()
   {
     return p2Cards.size();  
   }
   
   /**
		The logic for determining winner or war based on which players top card is higher.
   */

   public void winner()
   {
      if (p1TopCard.getValue() < (p2TopCard.getValue())) 
      {
         winnerMsg = "Player 2 Takes the Cards";
         p2Cards.add(p1TopCard);
         p2Cards.add(p2TopCard);
      }    
      else if (p1TopCard.getValue() > (p2TopCard.getValue()))          
      { 
         winnerMsg   = "Player 1 Takes the Cards";  
         p1Cards.add(p1TopCard);
         p1Cards.add(p2TopCard);        
      }
      else 
      {
         winnerMsg = "Card War!";
         warFlag = true;
      }               
   }
   
   /**
		War logic (top cards are equal)
   */
   
   public void cardWar()
   {
      //draw face down and face up cards
      p1FDCard = p1Cards.getTopCard(); 
      p2FDCard = p2Cards.getTopCard();
      p1UPCard = p1Cards.getTopCard();
      p2UPCard = p2Cards.getTopCard();
      
      //player 1 wins war      
      if (p1UPCard.getValue() > (p2UPCard.getValue())) 
      {
         winnerMsg = "Player 1 Wins the War";
         //player 1 adds all cards to their deck
         p1Cards.add(p1TopCard);
         p1Cards.add(p1FDCard);
         p1Cards.add(p1UPCard);
         p1Cards.add(p2TopCard);
         p1Cards.add(p2FDCard);
         p1Cards.add(p2UPCard);
         //set flag to false, war is over
         warFlag = false;
         //shuffle both decks
         p1Cards.shuffle();
         p2Cards.shuffle(); 
      }
      
      //player 2 wins war
      else if (p1UPCard.getValue() < (p2UPCard.getValue()) )         
      {
         winnerMsg = "Player 2 Wins the War";
         //player 2 adds all cards to their deck
         p2Cards.add(p1TopCard);
         p2Cards.add(p1FDCard);
         p2Cards.add(p1UPCard);
         p2Cards.add(p2TopCard);
         p2Cards.add(p2FDCard);
         p2Cards.add(p2UPCard);
         //set flag to false, war is over
         warFlag = false;
         //shuffle both decks
         p1Cards.shuffle();
         p2Cards.shuffle();

      } 
      else   
         winnerMsg = "Another War";                      
   }

   /**
		Get the flag indicating a Card war is on.
      &return warFlag Boolean flag.      
   */
   
   public boolean getWarFlag()
   {
      return warFlag;
   }

   /**
		Get the message indicating which player won the flip. 
      &return winnerMsg Winner message string.       
   */
 
   public String getWinnerMsg()
   {
      return winnerMsg;
   }   
}
