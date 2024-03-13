package practice8.Visitor;

public class ShoppingCartClient {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{new Book(200, "1234"),new Book(1000, "5678"),
                new Fruit(100, 2, "Banana"), new Fruit(50, 5, "Apple")};
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        for(ItemElement item: items){
            item.accept(visitor);
        }
    }
}
