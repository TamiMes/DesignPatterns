package il.ac.hit.validation;

public class MainApp {
    public static void main(String[] args){

        System.out.println("Hello, Java!");

        // Example usage
        User[] users = {
                new User("alice", "alice@example.com", "Password123$", 25),
                new User("bob", "bob@example.il", "BobPassword$", 30)
        };

        // Sort by username
        UserUtils.sort(users, (u1, u2) -> u1.getUsername().compareTo(u2.getUsername()));

        for (User u : users) {
            System.out.println(u.getUsername());
        }
    }
}
