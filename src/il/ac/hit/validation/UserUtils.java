package il.ac.hit.validation;

import java.util.Comparator;

public class UserUtils {
    /**
     * Template Method pattern:
     * sorting logic: Bubble sort.
     * Variable logic: Comparator passed in as parameter.
     */
    public static void sort(User[] users, Comparator<User> comparator) {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < users.length - 1; i++) {
                if (comparator.compare(users[i], users[i + 1]) > 0) {
                    // Swap
                    User temp = users[i];
                    users[i] = users[i + 1];
                    users[i + 1] = temp;
                    sorted = false;
                }
            }
        } while (!sorted);
    }
}
