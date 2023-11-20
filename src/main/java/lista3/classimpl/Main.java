package lista3.classimpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    Book book1 = new Book("Life of whales", 50, 3, 300);
    Game game1 = new Game("Baldur's gate 3", 250, 52, 2023, 25, 25);
    Game game2 = new Game("Peppa Pig", 100, 2, 2012, 10, 25);
    Pillow pillow1 = new Pillow("Blue pillow", 29.99, 10, 50, 30);
    Warehouse warehouse1 = new Warehouse(new ArrayList<>() {{ add(book1); add(pillow1); add(game1); }});

    warehouse1.listProducts();
    warehouse1.removeProduct(game1);
    warehouse1.addProduct(game2);
    warehouse1.listProducts();
    System.out.println(warehouse1.getProduct(0).getName());
    System.out.println(warehouse1.getProduct(0).getPrice());
    System.out.println(warehouse1.getProduct(0).getAmount());
    System.out.println(book1.isLong());
    System.out.println(game1.recent());
    System.out.println(game1.priceAfterDiscount());
    System.out.println(game2.priceAfterDiscount());
    System.out.println(pillow1.measurements());
}}
