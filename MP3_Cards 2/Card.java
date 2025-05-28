
class Card{
    
    private int rank;
    private int suit;
//assigning the 'power' of each card
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    public Card(){
        this.rank = 14;
        this.suit = 1;
    }

    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;

    }

    public Card(Card b){
        this.rank = b.rank;
        this.suit = b.suit;
    }

    public String toString() { //toString that prints the 'rank of cards in the game'
        String result = "";
        if  (rank == 11){
            result = result + "Jack of ";
        }
        else if  (rank == 12){
            result = result + "Queen of ";
        }
        else if  (rank == 13){
            result = result + "King of ";
        }
        else if  (rank == 14){
            result = result + "Ace of ";
        }
        else {
            result = result + rank + " of ";
        }
        if (suit == 0){
            result = result + "Hearts";
        }
        else if (suit == 1){
            result = result + "Spades";
        }
        else if (suit == 2){
            result = result + "Clubs";
        }
        else if (suit == 3) {
            result = result + "Diamonds";
        }
        return result;
    }

//equals method
    public boolean equals(Card otherCard){
        return this.toString().equals(otherCard.toString());
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public void setSuit(int suit){
        this.suit = suit;
    }

    public int getRank(){
        return rank;
    }

    public int getSuit(){
        return suit;
    }
        
}

