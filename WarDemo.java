/**
  This class contains and demonstrates the GUI Driver for the Card Game War.
  @author Kyle Whalen
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class WarDemo extends JFrame 
{
   private War game;
   private final int WINDOW_WIDTH = 1000;
   private final int WINDOW_HEIGHT = 800;
   private String strCard1, strCard2;
   private ImageIcon back, face1, face2;
   private JLabel p1, p2, p1Up, p1Down, p2Up, p2Down, p1Play, p2Play;
   private JLabel pile1Msg, pile2Msg, winnerMsg, info;
   private int count1, count2;
   private JButton play, deal;
   private boolean reset;
      
   public WarDemo(String f)
   {
      //frame settings
      super(f);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setBackground(new Color(150,0,0) );
      //JFrame.setBackground(Color.red);
       
      //Opening page
       
      info = new JLabel("The Card Game of War");
      info.setVisible(true);
      info.setFont(new Font("Arial", Font.PLAIN, 20));
   
       
      //starting the game 
      game = new War();
    
      //Create start button    
      deal = new JButton("Start");
      deal.addActionListener(new Deal());
      deal.setPreferredSize(new Dimension(130,60));
         
         
   	//Create a label for the card counts
      pile1Msg = new JLabel(" ");
   	pile2Msg = new JLabel(" ");
   	pile1Msg.setVisible(false);
   	pile2Msg.setVisible(false);       
   	//Create a label to display winner
   	winnerMsg = new JLabel(" ");
   	winnerMsg.setVisible(false);
   	winnerMsg.setFont(new Font("Arial", Font.PLAIN, 25));
   	
   	       
      //Create play button    
      play = new JButton("Play");
      play.addActionListener(new Play());
      play.setPreferredSize(new Dimension(100,60));
      play.setVisible(false);
      
      JPanel bottomPanel = new JPanel();    
      JPanel westPanel = new JPanel();
      JPanel eastPanel = new JPanel();
      JPanel northPanel = new JPanel();
      JPanel centerPanel = new JPanel();
      westPanel.setPreferredSize(new Dimension(300, 300));
      eastPanel.setPreferredSize(new Dimension(300, 300));
      northPanel.setPreferredSize(new Dimension(300, 300));
      centerPanel.setPreferredSize(new Dimension(300, 300));
   
      //Add the play and deal buttons to the bottom panel
      bottomPanel.add(play);
      bottomPanel.add(deal);
          
      //Create the card piles and all the cards    
      back = new ImageIcon("cardPics/back.jpg");
      p1 = new JLabel(back);
      p2 = new JLabel(back);
      p1Up = new JLabel(back);
      p1Play = new JLabel(back);
      p2Play = new JLabel(back);
      p2Up = new JLabel(back);
      p1Down = new JLabel(back);
      p2Down = new JLabel(back);
         
      // Add the cards to the panel. 
      westPanel.add(p1);
      westPanel.add(pile1Msg);
      eastPanel.add(p2);
      eastPanel.add(pile2Msg);
      northPanel.add(p1Up);
      centerPanel.add(p1Down);
      centerPanel.add(p2Down); 
      northPanel.add(p1Play);
      northPanel.add(p2Play);
      northPanel.add(p2Up);
      centerPanel.add(winnerMsg);
      centerPanel.add(info);
       
      //Add the panels to the frame
      add(bottomPanel, BorderLayout.SOUTH);
      add(eastPanel, BorderLayout.EAST);
      add(westPanel, BorderLayout.WEST);    
      add(northPanel, BorderLayout.NORTH);
      add(centerPanel, BorderLayout.CENTER);
          
      //Make all "cards" except the invisible until either dealt or flipped;
      p1.setVisible(false); 
      p2.setVisible(false);
      p1Play.setVisible(false);
      p2Play.setVisible(false); 
      p1Up.setVisible(false);
      p2Up.setVisible(false);
      p1Down.setVisible(false); 
      p2Down.setVisible(false);
         
      setVisible(true);
   }
   
   /**
      Play button Action Listener.
   */
   
   class Play implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      { 
         //reset the flag 
         reset = false;
      
         //hide the facedown cards
         p1Down.setVisible(false); 
         p2Down.setVisible(false);
         
         //flip the top cards of the deck
         game.flip();  
        
         //set the player 1 card icons
         strCard1= game.getP1TopCard();
         face1 = new ImageIcon(strCard1);       
         p1Play.setIcon(face1);
         
         //set the player 2 card icons 
         strCard2 = game.getP2TopCard();
         face2 = new ImageIcon(strCard2);       
         p2Play.setIcon(face2);
        
         //set the card to display
         p1Play.setVisible(true);
         p2Play.setVisible(true);
         
         //Get the winner and display message
         game.winner();
         winnerMsg.setText(game.getWinnerMsg());
         winnerMsg.setVisible(true);
        
         //get the player deck sizes
         count1 = game.getP1Count();
         count2 = game.getP2Count();
        
         //Decide the winner
         if(count1 < 1 )
         {
            info.setText("Player 2 Wins!");
            info.setVisible(true);
            winnerMsg.setVisible(false); 
            p1.setVisible(false); 
            p2.setVisible(false);
            p1Play.setVisible(false);
            p2Play.setVisible(false); 
            p1Up.setVisible(false);
            p2Up.setVisible(false);
            p1Down.setVisible(false); 
            p2Down.setVisible(false);
            reset = true;
            play.setVisible(false);
            deal.setVisible(true);
         }
            
         else if(count2 < 1 )
         { 
            info.setText("PLAYER 1 WINS Game Over");
            info.setVisible(true);
            winnerMsg.setVisible(false); 
            p1.setVisible(false); 
            p2.setVisible(false);

            p1Play.setVisible(false);
            p2Play.setVisible(false); 
            p1Up.setVisible(false);
            p2Up.setVisible(false);
            p1Down.setVisible(false); 
            p2Down.setVisible(false);
            reset = true;
            play.setVisible(false);
            deal.setVisible(true);
         }  
                
         else
            info.setVisible(false);
   
         pile1Msg.setText("Player 1 Card Count: " + count1);
         pile2Msg.setText("Player 2 Card Count: " + count2);
         
         if (count1 > 0 || count2 > 0)    
         {       
            if(game.getWarFlag())
            {
               game.cardWar();          
               strCard1= game.getP1UPCard();
               face1 = new ImageIcon(strCard1);       
               p1Up.setIcon(face1);
               strCard2 = game.getP2UPCard();
               face2 = new ImageIcon(strCard2);       
               p2Up.setIcon(face2);
               p1Up.setVisible(true);
               p2Up.setVisible(true);
               p1Down.setVisible(true); 
               p2Down.setVisible(true);
            }
            else
            {  
               p1Down.setVisible(false); 
               p2Down.setVisible(false);
               p1Up.setVisible(false);
               p2Up.setVisible(false);       
            }
         }
         else if(count2 < count1)    
         {
            info.setText("PLAYER 1 WINS Game Over");
            info.setVisible(true);
         }
         
         else 
         {
            info.setText("PLAYER 2 WINS Game Over");
            info.setVisible(true);
         }
       
         pile1Msg.setText("Player 1 Card Count: " + count1);
         pile2Msg.setText("Player 2 Card Count: " + count2);
         winnerMsg.setText(game.getWinnerMsg());
         winnerMsg.setVisible(true);       
         }       
        
      }  
     
     
   /** 
      Deal - New Game button Action Listener.
   */ 
     
   class Deal implements ActionListener
   {
      public void actionPerformed(ActionEvent f)
      { 
         if(reset)
         { 
            winnerMsg.setVisible(false);
            game = new War();
            game.deal();
         }
         else
            game.deal();
       
         count1 = game.getP1Count();
         count2 = game.getP2Count();
         pile1Msg.setText("Player 1 Card Count: " + count1);
         pile2Msg.setText("Player 2 Card Count: " + count2);
         pile1Msg.setVisible(true);
         pile2Msg.setVisible(true);       
         p1.setVisible(true);
         p2.setVisible(true);
       
         deal.setVisible(false);
         play.setVisible(true);
         info.setVisible(false);
      }
   }               
  
   public static void main(String [] args)
   {
      new WarDemo("War Card Game");
   } 
       
}
