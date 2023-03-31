
public class Player implements Comparable<Player> 
{
	 //declare the data fields
    private int playerId;
    
    private String playerName;
    
    private int points;
    
    private String result;
    
    public Player(int id)
    {
	  //mutator
      this.playerId = id;
    }

    public int getPlayerId()
    {       
      //accessor
      return playerId;
    }

    public void setPlayerId(int playerId)
    {
      //mutator
      this.playerId = playerId;
    }

    public String getPlayerName()
    {       
      //accessor
      return playerName;
    }

    public void setPlayerName(String playerName)
    {
      //mutator
      this.playerName = playerName;
    }

    public int getPoints()
    {
      //accessor
      return points;
    }

    public void setPoints(int points)
    {
      //mutator
      this.points = points;
    }

    public String getResult()
    {
      //accessor
      return result;
    }

    public void setResult(String result)
    {
      //mutator
      this.result = result;
    }

    @Override //allows a subclass or child class to provide a specific implementation of a method
    //returns the hash code for the given inputs
    public int hashCode()
    {
            final int prime = 31;
            int result = 1;
            result = prime * result + playerId;
            return result;
    }

    @Override //allows a subclass or child class to provide a specific implementation of a method
    public boolean equals(Object obj)
    {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Player other = (Player) obj;
            if (playerId != other.playerId)
                    return false;
                    return true;
    }

    @Override //allows a subclass or child class to provide a specific implementation of a method
    public int compareTo(Player o)//compare player points
    {       
    	    //condition
            if (this.getPoints() == o.getPoints())//if points are equal
            {
                    return 0;
            }
            else if (this.getPoints() > o.getPoints())
            {
                    return 1;
            }
            else
                    return -1;
    }
}
