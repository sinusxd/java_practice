package practice8.TemplateMethod;

public class Monopoly extends Game{
    @Override
    protected void initializeGame() {
        System.out.println("Ставим карту, разбираем деньги и карточки");
    }

    @Override
    protected void playGame() {
        System.out.println("Бросаем кубики, делаем ходы");
    }

    @Override
    protected void endGame() {
        System.out.println("Остался один игрок, который не является банкротом");
    }

    @Override
    protected void printWinner(String name) {
        System.out.println("Победитель - " + name);
    }
}
