
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card>
{
	private Card()
    {
    }

    public enum CardNumber //Card number 2 to 14
    {
            TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(
            14);

            private int ord;

            private CardNumber(int i)
            {
              //mutator
              this.ord = i;
            }

    
            public int getOrd()
            {
              //accessor
              return ord;
            }
    }
    //enumerated where all the data type consists of predefined values
    public enum CardType
    {
            CLUB, DIAMOND, HEARTS, SPADE;//card types
    }

    private CardNumber cdNumber;
    private CardType cdType;

    public CardNumber getCdNumber()
    {
    	   //get methods
            return cdNumber;
    }

    public CardType getCdType()
    {
    	    //get methods
            return cdType;
    }

    public static List<Card> getPackOfCards()
    {
            List<Card> crdLst = new ArrayList<Card>();

            for (CardType types : CardType.values())
            {
                    for (CardNumber cNums : CardNumber.values())
                    {
                            Card cd = new Card();
                            cd.cdNumber = cNums;
                            cd.cdType = types;
                            //add the cards of numbers and types into collection
                            crdLst.add(cd);
                    }
            }
            return crdLst;
    }

    public static void shuffleCards(List<Card> cards)
    {
   	     //randomly reorders the cards
            Collections.shuffle(cards);
    }

    @Override //allows a subclass or child class to provide a specific implementation of a method
    public int compareTo(Card o)//comparing card numbers
    {
            if (this.getCdNumber() == o.getCdNumber())//if card number is equal
            {
                    return 0;
            }
            else if (this.getCdNumber().getOrd() > o.getCdNumber().getOrd())
            {
                    return 1;
            }
            else
                    return -1;
    }

    @Override //allows a subclass or child class to provide a specific implementation of a method
    public String toString()
    {
   	     //return a randomly picked card number and card type
            return "Card [cdNumber=" + cdNumber + ", cdType=" + cdType + "]";
    }
	

}
