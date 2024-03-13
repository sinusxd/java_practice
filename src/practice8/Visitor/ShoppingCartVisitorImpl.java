package practice8.Visitor;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public int visit(Book book) {
        int cost = 0;
        if (book.getPrice() > 500)
            cost = book.getPrice() - 50;
        else
            cost = book.getPrice();

        System.out.println("Стоимость книги: " + cost + " ISBN: " + book.getIsbnNumber());
        return cost;

    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPrice() * fruit.getWeight();
        System.out.println(fruit.getName() + ' ' + cost);
        return cost;
    }
}
