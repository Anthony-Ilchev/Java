
public class Card {
    private int m_value; //memember variables 
    private int m_suit;

    public static final int HEARTS = 0;
    public static final int SPADES = 1; //static 
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    public static final int JACK = 11;
    public static final int QUEEN = 12; //identifers 
    public static final int KING = 13;
    public static final int ACE = 14;


    public Card() {
        this.m_value = ACE;
        this.m_suit = SPADES;
    }


    public Card(int value, int suit) {
        this.m_value = value;
        this.m_suit = suit;
    }


    public Card(Card card) {
        this.m_value = card.getValue();
        this.m_suit = card.getSuit();
    }


    public String toString() { //tostring 
        String suit = "";
        switch(m_suit) {
            case 0:
                suit = "Hearts";
                break;

            case 1: 
                suit = "Spades";
                break;

            case 2:
                suit = "Clubs";
                break;

            case 3:
                suit = "Diamonds";
                break;

            default:
                suit = "[INVALID SUIT]";
                break;
        }
        
        String value = "";
        if(m_value > 10 || m_value == 1) {
            switch(m_value) {
                case JACK:
                    value = "Jack";
                    break;

                case QUEEN:
                    value = "Queen";
                    break;

                case KING:
                    value = "King";
                    break;

                case ACE:
                case 1:
                    value = "Ace";
                    break;

                default:
                    value = "[INVALID VALUE]";
                    break;
            }
        } else {
            value = Integer.toString(m_value);
        }

        return value + " of " + suit;
    }


    public boolean equals(Card otherCard) {   //equals method
        if(m_value == otherCard.getValue()) return true;

        return false;
    }


    public int getValue() {
        return m_value;
    }


    public int getSuit() {
        return m_suit;
    }


    public void setValue(int value) {
        m_value = value;
    }


    public void setSuit(int suit) {
        m_suit = suit;
    }


    public boolean isFaceCard() {
        return m_value >= JACK && m_value <= KING || m_value == 1;
    }
}