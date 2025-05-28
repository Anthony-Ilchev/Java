

// Import statement
import java.util.LinkedList;


public class Dealer {
    private Deck m_deck; //member variables 


    public Dealer() {
        m_deck = new Deck();
    }


    public String toString() {
        return m_deck.toString();
    }

 
    public LinkedList<Card> deals(int n) {   
        LinkedList<Card> dealtCards = new LinkedList<Card>(); //creates new linked list and check if deck is empty
        for(int i = 0; i < n; i++) { //if empty it breaks the loop, if it is not empty it calls the deal method 
            if(m_deck.getCards().isEmpty()) {
                break;
            }
            Card card = m_deck.deal();
            dealtCards.add(card);
        }
        return dealtCards;
    }


    public int size() {
        return m_deck.getCards().size(); //calls get cards and size ans returns the szie of the current deck
    }
}