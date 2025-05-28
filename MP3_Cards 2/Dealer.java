import java.util.LinkedList;
public class Dealer {
    private Deck m_deck;

    public Dealer(){
        m_deck = new Deck(); // default constructor 
    }

    public LinkedList<Card> deals(int n) { 
        LinkedList<Card> newDeck = new LinkedList<Card>(); // LinkedList called newDeck 
        for (int i = 0; i < n; i++) {
            newDeck.add(m_deck.Deal()); k
        }
        return newDeck; 
    }

    public Deck getDeck()
    {
        return m_deck;
    }


    public int size(){
        return m_deck.Size();
    }

    public String toString(){
        return m_deck.toString(); //calls toString 
    }
}
