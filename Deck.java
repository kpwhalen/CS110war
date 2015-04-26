import java.util.*;
import java.util.ArrayList;
import java.util.List;
/**
   This class contains the deck of cards 
   Contains methods to shuffle
   and get an array of randomly selected cards
   @author Kyle Whalen 
 */
 
public class Deck
{

   private ArrayList<Card> deck;
 
   /**
		Constructor to create deck 
   */	    
   
   public Deck()
   {
     
     freshDeck();
    
   }
    
   /**
		Create the card deck  
   */	  
   
   public void freshDeck()
   {
      deck = new ArrayList<Card>();
         
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck.add(new Card(r,s));
         }
      }
   }
     
   public void add(Card aCard)
   {
      deck.add(aCard);
   }

   /**
      Returns the top card from the arraylist
      @return Card the top card.
   */

   public Card getTopCard()
   {
      return deck.remove(0);
   }   
   /**
      Returns deck arraylist
      @return deck of cards array list of cards. 
   */    
   public String toString()
   {
      return deck.toString();
   }
 	/**
      Returns the size of the deck of cards. Using the ArrayList method 
      @return size integer of number of cards in the deck. 
   */
   public int size()
   {
      return deck.size();
   }
   /**
      Empties the ArrayList - clears the deck.   
   */   
   public void clear()
   {
      deck.clear();
   }   
 
   /**
      Returns true if empty.  
      returns boolean -  true if empty.   
   */ 
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }

   /**
      Shuffle the cards using random numbers.   
   */    
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }        
}
