import java.util.LinkedList;

public class Player {
    private int playerNum;
    private LinkedList<Card> hand;
    private String pattern;

    public Player(int playerNum, LinkedList<Card> hand, String pattern) {
        this.playerNum = playerNum;
        this.hand = hand;
        this.pattern = pattern;
    }

    public Card playCard() {
        return hand.removeFirst();
    }

    public boolean slaps(LinkedList<Card> pile) {
        switch (pattern) {
            case "doubles":
                return Game.doubles(pile);
            case "top bottom":
                return Game.topBottom(pile);
            case "sandwich":
                return Game.sandwich(pile);
            default:
                return false; // Invalid pattern
        }
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "Player " + playerNum + " - Pattern: " + pattern + ", Hand: " + hand.toString();
    }
}