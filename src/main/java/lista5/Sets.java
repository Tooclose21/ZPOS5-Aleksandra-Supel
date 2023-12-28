package lista5;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> set1cp = new HashSet<>(set1);
        set1cp.addAll(set2);
        return set1cp;
    }


    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> set1cp = new HashSet<>(set1);
        set1cp.removeAll(set2);
        return set1cp;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> set1cp = new HashSet<>(set1);
        set1cp.retainAll(set2);
        return set1cp;
    }

    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        return difference(union(set1, set2), union(set1, set2));
    }

    public static boolean isEqual(Set<Integer> set1, Set<Integer> set2) {
        return difference(set1, set2).isEmpty() && difference(set2, set1).isEmpty();
    }
}
