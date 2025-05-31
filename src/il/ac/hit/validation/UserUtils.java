package il.ac.hit.validation;

import java.util.Comparator;

/**
 * Utility class providing operations on arrays of {@link User} objects.
 * Currently includes sorting using the Bubble Sort algorithm.
 */
public class UserUtils {

    /**
     * Sorts an array of users using the Bubble Sort algorithm.
     * <p>
     * Template Method Pattern:
     * The sorting logic (bubble sort) is fixed,
     * but the comparison logic is passed via a {@link Comparator}.
     *
     * @param users the array of users to sort
     * @param comparator the comparator used to determine the order
     * @throws IllegalArgumentException if users array or comparator is null
     */
    public static void sort(User[] users, Comparator<User> comparator) {
        // === Validate Arguments ===
        if (users == null) {
            throw new IllegalArgumentException("User array cannot be null");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }

        /*
         * Bubble Sort Algorithm:
         * Repeatedly step through the list, compare adjacent elements,
         * and swap them if they are in the wrong order.
         * Continue until the list is sorted.
         */
        boolean sorted;
        do {
            sorted = true;

            // Iterate through array to find unsorted pairs
            for (int i = 0; i < users.length - 1; i++) {
                if (comparator.compare(users[i], users[i + 1]) > 0) {
                    // Swap adjacent elements
                    User temp = users[i];
                    users[i] = users[i + 1];
                    users[i + 1] = temp;

                    // Mark as unsorted to repeat loop
                    sorted = false;
                }
            }
        } while (!sorted);
    }
}
