package practice8.Visitor;

public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
