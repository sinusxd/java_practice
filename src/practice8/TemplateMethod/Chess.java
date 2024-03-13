package practice8.TemplateMethod;

public class Chess extends Game{
    @Override
    protected void initializeGame() {
        System.out.println("Расставили шахматы");
    }

    @Override
    protected void playGame() {
        System.out.println("Игроки делают свои ходы");
    }

    @Override
    protected void endGame() {
        System.out.println("Делаем последний ход");
    }

    @Override
    protected void printWinner(String name) {
        System.out.println("Победитель - " + name);
    }
}
