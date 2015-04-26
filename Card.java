/**
	A Card class for the Card game.	
	@author Kyle Whalen 
*/

public class Card 
{
   //constants
   
   //suits
   public final static int SPADES = 0;
   public final static int HEARTS = 1;
   public final static int DIAMONDS = 2;
   public final static int CLUBS = 3;
   
   //ranks
   //cards 2-9 have face value
   public final static int ACE = 1;
   public final static int JACK = 11;
   public final static int QUEEN = 12;
   public final static int KING = 13;
   
   //instance variables 
   private int suit;
   
   private int rank;
   
   /**
      Constructor to create cards and shuffle them
      
   */
   
   public Card(int rank, int suit)
   {
      this.rank = rank;
      this.suit = suit;
   }
   
   /**
      Method returns card value
      @return card suit as a value
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**
      Method returns card value
      @return cards rank as a value
   */
   public int getValue()
   {
      return rank;
   }
   
   /**
      Method returns a description of the card
      @return the suit value of a card as a string
   */
   public String getSuitAsString() 
   {
      // Return a String representing the card's suit.
      // (If the card's suit is invalid, "Invalid" is returned.)
      switch ( suit )
      {
         case 0:   
            return "s";
         case 1:   
            return "h";
         case 2:  
            return "d";
         case 3:    
            return "c";
         default:       
            return "Invalid";
      }
   }
   
   /**
      Return a description of the card
      @return the rank value of a card as a string
   */   
   public String getRankAsString()   
   {
      switch (rank)
      {
         case 1:
            return "ace";
         case 2:
            return "2";
         case 3:
            return "3";
         case 4:
            return "4";
         case 5:
            return "5";
         case 6:
            return "6";
         case 7:
            return "7";
         case 8:
            return "8";
         case 9:
            return "9";
         case 10:
            return "10";
         case 11:
            return "jack";
         case 12:
            return "queen";
         case 13:
            return "king";
         default:
            return "";
      
      }
   }
   
   /**
      Returns a description of this card.
      @return name the name of the card.
   */
   
   public String toString()
   {
      return getRankAsString() + " of " + getSuitAsString(); 
   }
   
   
   /**
      Returns a description of this card
      @return filename of image of the card
   */
   public String toName()
   {
      return "cardPics/" + getRankAsString()+ getSuitAsString()+".jpg";
   }
   
   /**
      Compares two cards to determine if they have the same value.
      @param card the other card
      @return true if the two cards have the same rank and suitvalues,
      falseotherwise.
   */
   public boolean equals(Card otherCard ) 
   {
      if ( ( rank != otherCard.rank ) || ( suit != otherCard.suit ) )
         return false;
      else
         return true;
   }
}
