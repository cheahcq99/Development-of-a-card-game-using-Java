import java.util.Scanner;//Needed for the scanner class

public class GameDemo 
{
	{
		//variable arguments
	}

	        
	  public static void main(String[] args)//main function
	        {
	          CardGame sl = new CardGame();

	          //main menu
	          System.out.println("Card Game");//Game name 
	          System.out.println("Player Options");//Game options
	          System.out.println("1. Start Game");
	          System.out.println();//skip a line
	          System.out.println("2. Exit Game");
	          System.out.print("Please provide your option : ");//Select options

	          int i = 1;

	          while (i != 0) //executes till it met its condition
	          {
	            Scanner in = new Scanner(System.in);
	            i = in.nextInt();

	            switch (i)//executes one statement from multiple conditions
	            {
	            
	            // Menu presented after start game is selected
	             case 1: //condition if user enters 1
	            	//only 2 to 4 players
	            	//Prompt the user to enter number of players
	                System.out.println("Provide the Number of Players( should be greater than 1 and less than 4) : ");
	                in = new Scanner(System.in);
	                i = in.nextInt();
	                sl.playGame(i);

	                sl.displayWinners();// display winner
	                break;

	             case 2: //condition if user enters 2
	            	//exit the game 
	                System.exit(0);
	           }

	           // to return to main menu after choosing stop game
	           System.out.println();
	           //Game name
	           System.out.println("Card Game");
	           //Options for user to select
	           System.out.println("Select User Options");
	           System.out.println("1. Start Game");
	           System.out.println("2. Exit Game");
	           //Prompt user to enter the option
	           System.out.print("Please provide your option : ");
	           
	           
	           }
	        }
}
