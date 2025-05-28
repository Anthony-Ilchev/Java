
import java.util.LinkedList;
import java.util.Random;


public class Deck {
    private LinkedList<Card> m_cards = new LinkedList<Card>(); //declares m_cards to a new linked list

    public static final int ALL_CARDS = 52;

    public Deck() {    //constructor for deck class
        for(int suit = 0; suit < 4; suit++) {   //iterates over 4 suits 
            for(int value = 1; value < 14; value++) {
                this.m_cards.add(new Card(value, suit));
            }
        }
    }


    public Deck(Deck deck) {
        this.m_cards = deck.getCards();
    }


    public String toString() {  //overrides tostring method 
        return m_cards.toString();
    }


    public LinkedList<Card> getCards() { //method retruns a list of cards in the deck
        return m_cards;
    }


    public Card deal() {
        Random randy = new Random();
        int index = randy.nextInt(m_cards.size());
        return m_cards.remove(index);
    }
}