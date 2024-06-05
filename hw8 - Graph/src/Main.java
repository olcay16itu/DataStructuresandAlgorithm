import java.util.*;

/**
 * Main class for managing and interacting with a social network graph.
 */
public class Main {

    /**
     * Main method to run the Social Network Analysis menu.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SocialNetworkGraph network = new SocialNetworkGraph();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Social Network Analysis Menu =====");
            System.out.println("1. Add person");
            System.out.println("2. Remove person");
            System.out.println("3. Add friendship");
            System.out.println("4. Remove friendship");
            System.out.println("5. Find shortest path");
            System.out.println("6. Suggest friends");
            System.out.println("7. Count clusters");
            System.out.println("8. Exit");
            System.out.print("Please select an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter hobbies (comma separated): ");
                        String[] hobbiesArray = scanner.nextLine().split(",");
                        List<String> hobbies = new ArrayList<>();
                        addHobbies(hobbiesArray, hobbies);
                        network.addPerson(name, age, hobbies);
                        break;
                    case 2:
                        System.out.print("Enter name of the person to remove: ");
                        name = scanner.nextLine();
                        network.removePerson(name);
                        break;
                    case 3:
                        System.out.print("Enter the name of the first person: ");
                        String name1 = scanner.nextLine();
                        System.out.print("Enter the name of the second person: ");
                        String name2 = scanner.nextLine();
                        network.addFriendship(name1, name2);
                        break;
                    case 4:
                        System.out.print("Enter the name of the first person: ");
                        name1 = scanner.nextLine();
                        System.out.print("Enter the name of the second person: ");
                        name2 = scanner.nextLine();
                        network.removeFriendship(name1, name2);
                        break;
                    case 5:
                        System.out.print("Enter the name of the start person: ");
                        String startName = scanner.nextLine();
                        System.out.print("Enter the name of the end person: ");
                        String endName = scanner.nextLine();
                        network.findShortestPath(startName, endName);
                        break;
                    case 6:
                        System.out.print("Enter the name of the person: ");
                        name = scanner.nextLine();
                        System.out.print("Enter the maximum number of suggestions: ");
                        int maxSuggestions = Integer.parseInt(scanner.nextLine());
                        network.suggestFriends(name, maxSuggestions);
                        break;
                    case 7:
                        network.countClusters();
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Adds hobbies to a list after trimming whitespace.
     * @param hobbiesArray Array of hobbies as strings.
     * @param hobbies List to store the trimmed hobbies.
     */
    public static void addHobbies(String[] hobbiesArray, List<String> hobbies) {
        for (String hobby : hobbiesArray) {
            hobbies.add(hobby.trim());
        }
    }
}
