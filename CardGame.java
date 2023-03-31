import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.List;
import java.util.Map;
import java.util.HashMap;



public class CardGame implements Game //used to implement the interface(Game)
{
	    //store the ordered collection for cards
		private List<Card> cards;
		//store the ordered collection for players
	    private List<Player> players = new ArrayList<Player>();
	    private Map<Player, List<Card>> cardsPlayerMap = new HashMap<Player, List<Card>>();
	    //declare data fields
	    private int currentPlayerIdx = 0;
	    //7 cards will be distributed to each player
	    private static final int numberOfCardsPerPlayer = 7;
	    //minimum number of players
	    private int numOfPlayers = 2;
	    public int getNumOfPlayers()  //to get number of players
	    {
	       return numOfPlayers;
	    }

	    public List<Player> getPlayers()
	    {
	       return players;
	    }
	    public CardGame()
	    {
	       cards = Card.getPackOfCards();
	    }

	    public void giveCardsForPlayers(List<Player> plys)
	    {
	    	   //mutator
	            this.players = plys;
	            //randomly reorders the cards
	            Card.shuffleCards(cards);
	            if (cardsPlayerMap.size() == 0)
	                    cardsPlayerMap.clear();
	            //data field for card
	            int m = 0;
	            for (Player pl : players)
	            {
	                    pl.setPoints(0);
	                    List<Card> cds = new ArrayList<Card>();
	                    //Maximum card limit is 7
	                    int cardLimit = m + numberOfCardsPerPlayer;
	                    for (int i = m; i < cardLimit; i++) //repetition
	                    {
	                      //add cards when condition met
	                      cds.add(cards.get(i));
	                    }
	                    m = cardLimit;
	                    cardsPlayerMap.put(pl, cds);
	            }
	    }

	    public void playGame(int numOfPlayers)
	    {
	            this.numOfPlayers = numOfPlayers;
	            createMultiUser(numOfPlayers);
	            int i = 0;
	            System.out.println("Game Started.....  ");
	            List<Card> selCards = new ArrayList<Card>();
	            Card maxCard = null;
	            Player maxPlayer = new Player(0);
	            giveCardsForPlayers(players);
	            //number of cards per player will be 7
	            for (int j = 0; j < numberOfCardsPerPlayer; j++)
	            {
	              int s = 0;
	                    do
	                    {
	                      //main menu for player
	                      Player player = getNextPlayer();
	                      System.out.println("1. Display cards available");
	                      System.out.println("2. Stop Game");
	                      System.out.println("Chance for Player..." + player.getPlayerId());
	                      System.out.print("Please provide your option : ");
	                      Scanner in = new Scanner(System.in);
	                      i = in.nextInt();

	                      switch (i) //executes one statement from multiple condition
	                            {
	                              case 1: //condition if user enters 1
	                                  displayCardsForPlayer(player);
	                                  //prompts user to enter an option(1/2)
	                                  System.out.println("Select your card number :");
	                                  
	                                  in = new Scanner(System.in);
	                                  int m = in.nextInt();
	                                  //Cards will be reduced by 1 after chosen a card
	                                  Card c = cardsPlayerMap.get(player).get(m - 1);
	                                  System.out.println("Card Selected -> " + c.toString());
	                                  cardsPlayerMap.get(player).remove(m - 1);
	                                  if (maxCard == null)
	                                  {
	                                      maxCard = c;
	                                      maxPlayer = player;
	                                  }
	                                  else
	                                  {
	                                      if (maxCard.compareTo(c) < 0)
	                                      {
	                                           maxCard = c;
	                                           maxPlayer = player;
	                                      }
	                                  }
	                                  selCards.add(c);

	                                  break;
	                              case 2: //condition if user enters 1
	                                  return;
	                                 
	                            }
	                            
	                            System.out.println();
	                            s++;
	                            
	                    } while (s < players.size());
	                    if (maxPlayer.getPlayerId() > 0)
	                    maxPlayer.setPoints((maxPlayer.getPoints()) + 1);
	                    maxCard = null;
	                    maxPlayer = null;
	                    displayScores();
	                    
	            }
	    }

	    private void displayScores() //displays the score
	    {
	            for (Player pl : players)
	            {
	               //player will get a point of every round won
	               System.out.println("Player " + pl.getPlayerId() + " Score -> " + pl.getPoints());
	            }

	    }

	    private void displayCardsForPlayer(Player pl) // displays player cards
	    {
	            int cards = cardsPlayerMap.get(pl).size();
	            for (int i = 0; i < cards;)
	            {
	                    System.out.print((++i) + " ");
	            }
	    }

	    public void displayWinners() //outputs the winner
	    {
	            Collections.sort(players);
	            //declare data field
	            int maxPoints = 0;
	            Map<String, List<Player>> playerPointsMap = new TreeMap<String, List<Player>>();
	            for (Player p : players)
	            {
	             maxPoints = p.getPoints();
	                    //else if condition
	                    if (playerPointsMap.get(maxPoints + "") != null)
	                    {
	                            List<Player> lst = playerPointsMap.get(maxPoints + "");
	                            lst.add(p);
	                            playerPointsMap.put(maxPoints + "", lst);
	                    }
	                    else
	                    {
	                            List<Player> lst = new ArrayList<Player>();
	                            lst.add(p);
	                            playerPointsMap.put(maxPoints + "", lst);
	                    }
	            }
	           
	            // if a draw occur between players
	            String pts = new Integer(players.get(players.size() - 1).getPoints()).toString();
	            //else if condition
	            if (playerPointsMap.get(pts) != null && playerPointsMap.get(pts).size() > 1)
	            {
	                    System.out.println("Its a draw among the following players ");
	                    for (Player p : players)
	                    {
	                    	    //outputs the final result of players
	                            System.out.println("Player -> " + p.getPlayerId());
	                    }
	            }
	            else if (playerPointsMap.get(pts) != null)
	            {
	            // if a winner is decided
	                    System.out.println("And the winner is :");
	                    System.out.println("Player -> " + playerPointsMap.get(pts).get(0).getPlayerId());
	            }
	    }

	    private void createMultiUser(int j)//create multiple player in card game
	    {
	            if (players.size() != 0)
	            {
	            	    //remove all players
	                    players.clear();
	            }

	            for (int i = 0; i < j; i++)//repetition
	            {
	                    int id = i + 1;
	                    Player usr = new Player(id);
	                    //add a player
	                    players.add(usr);
	            }
	            //distribute card to players
	            giveCardsForPlayers(players);
	    }
	    //pass to the next player
	    private Player getNextPlayer()
	    {

	            Player p = null;
	            if (currentPlayerIdx == players.size())
	            {
	                    currentPlayerIdx = 1;
	                    p = players.get(0);
	            }
	            else
	            {
	                    p = players.get(currentPlayerIdx);
	                    currentPlayerIdx++;
	            }

	            return p;
	     }
	

}
