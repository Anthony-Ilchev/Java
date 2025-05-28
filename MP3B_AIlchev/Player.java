
import java.util.LinkedList;

public class Player {
    private int m_playerNum;
    private LinkedList<Card> m_hand;
    private String m_pattern;

   
    public Player(int playerNum, LinkedList<Card> hand, String pattern) {
        this.m_playerNum = playerNum;
        this.m_hand = hand;
        this.m_pattern = pattern;
    }

    // Accessors for member variables
    public void setPlayerNum(int playerNum) { m_playerNum = playerNum; }
    public void setHand(LinkedList<Card> hand) { m_hand = hand; }
    public void setPattern(String pattern) { m_pattern = pattern; }

    // Mutators for member variables
    public int getPlayerNum() { return m_playerNum; }
    public LinkedList<Card> getHand() { return m_hand; }
    public String getPattern() { return m_pattern; }

    public String toString() {
        return "Player #" + m_playerNum + "\nPattern: " + m_pattern + "\nHand: " + m_hand.toString();
    }

    public Card playCard() {
        if(!m_hand.isEmpty()) {
            return m_hand.removeFirst();
        } else {
            return null;
        }
    }

    public boolean slaps(LinkedList<Card> pile) {
        switch (m_pattern) {
            case "doubles":
                return Game.doubles(pile);

            case "top bottom":
                return Game.topBottom(pile);
        
            case "sandwich":
                return Game.sandwich(pile);

            default:
                return false;
        }
    }
}