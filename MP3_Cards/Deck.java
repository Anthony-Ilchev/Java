import java.util.LinkedList;
import java.util.Random;
public class Deck extends Card{
    private LinkedList<Card> m_cards = new LinkedList<Card>(); // new linkedlist for the card deck
    Random rand = new Random(); 
    public Deck(){ 
        for (int j = 0; j < 4; j++) {
            for (int k = 1; k <= 13; k++) {
                if (j == 0) {
                    m_cards.add(new Card(k, Card.HEARTS));
                }
                if (j == 1) {
                    m_cards.add(new Card(k, Card.SPADES));
                }
                if (j == 2) {
                    m_cards.add(new Card(k, Card.CLUBS));
                }
                if (j == 3) {
                    m_cards.add(new Card(k, Card.DIAMONDS));
                }
            }
        }
    }
    public Deck(Deck deck){ // copy constructor
        for (int j = 0; j < 4; j++) {
            for (int k = 1; k <= 13; k++) {
                if (j == 0) {
                    m_cards.add(new Card(k, Card.HEARTS));

                }
                if (j == 1) {
                    m_cards.add(new Card(k, Card.SPADES));

                }
                if (j == 2) {
                    m_cards.add(new Card(k, Card.CLUBS));

                }
                if (j == 3) {
                    m_cards.add(new Card(k, Card.DIAMONDS));

                }
                this.m_cards = deck.m_cards; 
            }
        }

    }

    public String toString(){ //toString
        String result = "Cards in deck: " +"\n";
        for (int i = 0; i < m_cards.size() ; i++) {
            result = result +  "  " + (i+1) + ": " + m_cards.get(i).toString() + "\n";
        }
        return result; // gives the user a interface to work with using toString
    }

    public int Size(){
        return m_cards.size(); //return cards
    }



    public Card Deal(){ // randomly takes card out of the deck
        int rand_card = rand.nextInt((m_cards.size()-1))+1; //randomly assigns the 52 cards we have the in the deck 
        Card dealtCard =  m_cards.get(rand_card); 
        m_cards.remove(rand_card); 
        return dealtCard;
    }

}
