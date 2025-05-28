public class Driver {
    public static void main(String[] args) {
        Game game = new Game(4); // You can change the number of players here
        System.out.println("Starting Egyptian Rat Screw Game!");
        System.out.println("Players and their hands:");
        for (Player player : game.getPlayers()) {
            System.out.println(player);
        }
        game.play();
    }
}