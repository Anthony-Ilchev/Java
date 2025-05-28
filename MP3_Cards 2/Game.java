import java.util.LinkedList;
import java.util.Random;

public class Game {
    private LinkedList<Player> players;
    private LinkedList<Card> pile;
    private Deck deck;
    private String[] patterns = {"doubles", "top bottom", "sandwich"};

    public Game(int numPlayers) {
        players = new LinkedList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i, new LinkedList<>(), patterns[new Random().nextInt(patterns.length)]));
        }
        deck = new Deck();
        deck.shuffle();
        dealCards();
        pile = new LinkedList<>();
    }

    public void play() {
        int currentPlayerIndex = 0;
        while (players.size() > 1) {
            Player currentPlayer = players.get(currentPlayerIndex);
            Card playedCard = currentPlayer.playCard();
            pile.add(playedCard);
            System.out.println(currentPlayer + " plays " + playedCard);

            if (isFaceCard(playedCard)) {
                handleFaceCard(currentPlayer, playedCard);
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); // Move to next player
            }

            if (pile.size() >= 2 && players.size() > 1) {
                Player slappingPlayer = findSlappingPlayer();
                if (slappingPlayer != null) {
                    System.out.println(slappingPlayer + " slaps the pile!");
                    takePile(slappingPlayer);
                }
            }
        }
        System.out.println("Game Over! Player " + players.getFirst().getPlayerNum() + " wins!");
    }

    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.getHand().add(deck.draw());
            }
        }
    }

    private boolean isFaceCard(Card card) {
        return card.getRank() >= Card.JACK && card.getRank() <= Card.ACE;
    }

    private void handleFaceCard(Player currentPlayer, Card playedCard) {
        int chances = playedCard.getRank() - Card.JACK + 1;
        while (chances > 0 && pile.size() >= 2) {
            Player nextPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());
            Card nextCard = nextPlayer.playCard();
            pile.add(nextCard);
            System.out.println(nextPlayer + " plays " + nextCard);
            chances--;

            if (isFaceCard(nextCard)) {
                currentPlayer = nextPlayer;
                playedCard = nextCard;
                chances = nextCard.getRank() - Card.JACK + 1;
            }
        }
        if (chances == 0) {
            System.out.println("No face card played. " + currentPlayer + " takes the pile.");
            takePile(currentPlayer);
        } else {
            System.out.println(currentPlayer + " played a face card successfully.");
        }
    }

    private Player findSlappingPlayer() {
        for (Player player : players) {
            if (player.slaps(pile)) {
                return player;
            }
        }
        return null;
    }

    private void takePile(Player player) {
        player.getHand().addAll(pile);
        pile.clear();
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public LinkedList<Card> getPile() {
        return pile;
    }

    public Deck getDeck() {
        return deck;
    }
