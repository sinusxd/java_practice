package practice8.TemplateMethod;

public abstract class Game {
    private int playersAmount;
    protected abstract void initializeGame();

    protected abstract void playGame();

    protected abstract void endGame();

    protected abstract void printWinner(String name);

    public final void playOneGame(int playersAmount, String name){
        setPlayersAmount(playersAmount);

        initializeGame();
        playGame();
        endGame();

        printWinner(name);
    }

    public void setPlayersAmount(int playersAmount){
        this.playersAmount = playersAmount;
    }

}
