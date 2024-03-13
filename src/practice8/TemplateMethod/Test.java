package practice8.TemplateMethod;

public class Test {
    public static void main(String[] args) {
        Chess chess = new Chess();
        Monopoly monopoly = new Monopoly();
        Game game = chess;
        for(int i = 0; i < 2; ++i){
            game.initializeGame();
            game.playGame();
            game.endGame();
            game.printWinner("Senya");
            game = monopoly;
        }

    }
}
