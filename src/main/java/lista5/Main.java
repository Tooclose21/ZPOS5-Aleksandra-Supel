package lista5;

import lista3.classimpl.Book;
import lista3.classimpl.Game;
import lista3.classimpl.Pillow;
import lista3.classimpl.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static lista5.Sets.*;


public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(3);
        set2.add(4);
        System.out.printf("Set1:\n%s\nSet2:\n%s\n", set, set2);
        System.out.printf("Union: %s\n", union(set, set2));
        System.out.printf("Difference: %s\n", difference(set, set2));
        System.out.printf("Intersection: %s\n", intersection(set, set2));
        System.out.printf("Symmetric difference: %s\n", symmetricDifference(set, set2));
        System.out.printf("Equal?: %s\n", isEqual(set, set2));

        Product pillow = new Pillow("IKEA pillow", 12, 142, 25, 100);
        Product game = new Game("Baldur's Gate III", 250, 150, 2023,18, 0.25);
        Product book = new Book("YellowFace", 100, 90, 350);

        Warehouse store = new Warehouse(new HashMap<>() {{
            put("P0183", pillow);
            put("G198", game);
            put("B901384", book);
        }});
        store.listProducts();


        Subject subject = new Subject("Math", 4, 5);
        Subject subject2 = new Subject("Ultrasounds", 2, 1);
        SubjectStorage storage = new SubjectStorage(new HashMap<>() {{
            put("LM0198", subject);
            put("EU02983", subject2);
        }});
        for (Map.Entry<String, Subject> entry : storage.getAll()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Sentence sentence = new Sentence("BLa test\n and something!!!Bla.,to, test");
        System.out.printf("Words: %s\nChars: %s\n", sentence.getNumberOfWords(), sentence.getNumberOfCharacters());
    }
}
