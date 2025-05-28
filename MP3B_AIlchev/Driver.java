
public class Driver {
    public static void main(String[] args) {
        Game game = new Game(4); //creates games

        int winner = game.play(); //plays game

        System.out.println("\n The winner is Player: " + winner ); //prints winner
    }
}