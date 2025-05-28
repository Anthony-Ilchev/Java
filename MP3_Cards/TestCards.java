public class TestCards{

    public static void main(String[] args) { //main class
        Card faceCard = new Card(); //default card
        Card numberedCard = new Card(8, Card.HEARTS); // new card

        System.out.println(faceCard); // checks that faceCard (default card) is printed
        System.out.println(numberedCard); // checks that numberedCard is printed
        System.out.println(faceCard.equals(numberedCard)); // checks that faceCard is not the same as numberedCard
        System.out.println(faceCard.equals(faceCard)); //checks that faceCard is the same as itself

        Dealer dealer = new Dealer(); //creates new dealer object
        System.out.println(dealer); // prints whole deck
        System.out.println(dealer.deals(5)); //removes 5 cards from the deck
        System.out.println(dealer.size()); // returns the size of the deck without the removed cards
        System.out.println(dealer); // prints the new deck
    }
}