
import java.util.LinkedList;
import java.util.Random;


public class Game {
    private LinkedList<Player> m_players; //member variables
    private LinkedList<Card> m_pile;
    private Dealer m_dealer;

    private static final String[] PATTERNS = {"doubles", "top bottom", "sandwich"};

    public Game() {
        initializeGame(4);
    }


    public Game(int numOfPlayers) {
        initializeGame(numOfPlayers);
    }

    public void setPlayers(LinkedList<Player> players) { this.m_players = players; } //setters 
    public void setPile(LinkedList<Card> pile) { this.m_pile = pile; }
    public void setDealer(Dealer dealer) { this.m_dealer = dealer; }

    public LinkedList<Player> getPlayers() { return m_players; }
    public LinkedList<Card> getPile() { return m_pile; } //getters 
    public Dealer getDealer() { return m_dealer; }


    public void initializeGame(int numOfPlayers) {
        m_players = new LinkedList<Player>();
        m_pile = new LinkedList<Card>();
        m_dealer = new Dealer();

        Random rand = new Random();
        for(int i = 0; i < numOfPlayers; i++) {  //creates object named rand, iterartes through the number of player there are
            m_players.add(new Player(i + 1, m_dealer.deals(Deck.ALL_CARDS / numOfPlayers), PATTERNS[rand.nextInt(PATTERNS.length)]));
            System.out.println("Hand of Player: " + m_players.get(i).getPlayerNum() + ": " + m_players.get(i).getHand());
        }   //prints out the hand of each player and their hand of cards
    }


    public int play() {   //this code represents a round of gameplay
        Player currentPlayer = m_players.get(0);
        while(m_players.size() > 1) {    //loop continue if there is more then one player left
            Card playedCard = currentPlayer.playCard();

            if(playedCard == null) {    //if player card is null which means no cards, it will remove the player
                System.out.println("Player #" + currentPlayer.getPlayerNum() + " is out of cards. They lose!");
                m_players.remove(currentPlayer);
                if(m_players.size() > 0) {
                    currentPlayer = m_players.get(0);
                }
                continue;
            }

            System.out.println("\nPlayer: " + currentPlayer.getPlayerNum() + " plays a turn. Their card is the " + playedCard);

            m_pile.add(playedCard);

            if(playedCard.isFaceCard()) {
                handleFaceCard(currentPlayer, playedCard);
            } else if(currentPlayer.slaps(m_pile)) {
                System.out.println("Player #" + currentPlayer.getPlayerNum() + " slapped the pile! Their pattern was " + currentPlayer.getPattern().toUpperCase() + "!");
                currentPlayer.getHand().addAll(m_pile);
                m_pile.clear();
            }

            currentPlayer = nextPlayer(currentPlayer); //goes to next player
        }

        return m_players.get(0).getPlayerNum();
    }

 
    private Player nextPlayer(Player currentPlayer) {
        return m_players.get((m_players.indexOf(currentPlayer) + 1) % m_players.size()); //next player based on current player 
    }


    private boolean handleFaceCard(Player player, Card topCard) {
        boolean faceCardPlayed = false;
        int chances = 0;
        switch (topCard.getValue()) {
            case Card.JACK:
                chances = 1;
                break;
            case Card.QUEEN:
                chances = 2;
                break;
            case Card.KING:
                chances = 3;
                break;
            case Card.ACE:
            case 1:
                chances = 4;
                break;
            default:
                chances = 0;
                break;
        }

        if(chances > 0) {
            System.out.println("Player: " + player.getPlayerNum() + " placed down a face card, The next player has (" + chances + ") chances to also get a face card.");
        }

        player = nextPlayer(player);  //deals with the special mechanics of face cards
        for(int i = 0; i < chances; i++) {
            topCard = player.playCard();

            if(topCard == null) {
                System.out.println("Player: " + player.getPlayerNum() + " is out of cards");
                m_players.remove(player);
                break;
            } else {
                System.out.println("(" + (chances - i) + ") chances Left: " + "Player: " + player.getPlayerNum() + " plays a card. Their card is a " + topCard);
                m_pile.add(topCard);
            }

            if(topCard.isFaceCard()) {
                faceCardPlayed = true;
                System.out.println("Player:" + player.getPlayerNum() + " made it through this round... for now");
                break;
            }
        }

        if(!faceCardPlayed) {
            player.getHand().addAll(m_pile);
            m_pile.clear();

            System.out.println("Player: " + player.getPlayerNum() + " failed to place down a face card");
        }

        return faceCardPlayed;
    }


    public static boolean doubles(LinkedList<Card> pile) {  // checks if top cards form a pair
        if(pile.size() < 2) return false;
        return pile.get(pile.size() - 1).getValue() == pile.get(pile.size() - 2).getValue();
    }


    public static boolean topBottom(LinkedList<Card> pile) {
        if(pile.size() < 3) return false;
        return pile.get(pile.size() - 1).getValue() == pile.get(pile.size() - 3).getValue();
    } //checks if top and bottom cards are the same 


    public static boolean sandwich(LinkedList<Card> pile) {
        if(pile.size() < 2) return false;
        return pile.get(0).getValue() == pile.get(pile.size() - 1).getValue();
    } //checks if cards are sandwiched 
}