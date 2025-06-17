package il.ac.hit.validation;

import java.util.Comparator;

public class UserSortDemo {

    public static void main(String[] args) {
        // Create unsorted users
        User[] users = {
                new User("charlie", "charlie@mail.com", "123", 30),
                new User("alice", "alice@mail.com", "123", 28),
                new User("bob", "bob@mail.com", "123", 25)
        };

        // Sort by username
        System.out.println("Before sorting by username:");
        printUsers(users);

        UserUtils.sort(users, Comparator.comparing(User::getUsername));

        System.out.println("\nAfter sorting by username:");
        printUsers(users);

        // Sort by age
        System.out.println("\nBefore sorting by age:");
        printUsers(users);

        UserUtils.sort(users, Comparator.comparingInt(User::getAge));

        System.out.println("\nAfter sorting by age:");
        printUsers(users);
    }

    // Helper method to print user usernames and ages
    private static void printUsers(User[] users) {
        for (User user : users) {
            System.out.println(user.getUsername() + " (age: " + user.getAge() + ")");
        }
    }
}
