import java.util.*;

/**
 * Represents a social network graph where each person can have friendships with other people.
 * Provides methods to manage people, friendships, find shortest paths, count clusters, and suggest friends.
 */
public class SocialNetworkGraph {
    Map<String, Person> people = new HashMap<>();
    Map<Person, List<Person>> friendships = new HashMap<>();

    /**
     * Adds a person to the social network.
     *
     * @param name    the name of the person
     * @param age     the age of the person
     * @param hobbies the list of hobbies of the person
     */
    public void addPerson(String name, int age, List<String> hobbies) {
        Person person = new Person(name, age, hobbies);
        people.put(name, person);
        friendships.put(person, new ArrayList<>());
        System.out.println("Person added: " + person);
    }

    /**
     * Removes a person from the social network.
     *
     * @param name the name of the person to remove
     */
    public void removePerson(String name) {
        Person p = people.get(name);
        if (p == null) {
            System.out.println("Person not found: " + name);
            return;
        }
        for (Person person : friendships.keySet()) {
            friendships.get(person).remove(p);
        }
        friendships.remove(p);
        people.remove(name);
        System.out.println("Person removed: " + p.name);
    }

    /**
     * Adds a friendship between two people in the social network.
     *
     * @param name1 the name of the first person
     * @param name2 the name of the second person
     */
    public void addFriendship(String name1, String name2) {
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);
        if (person1 != null && person2 != null) {
            friendships.get(person1).add(person2);
            friendships.get(person2).add(person1);
            System.out.println("Friendship added between " + person1.name + " and " + person2.name);
        } else {
            System.out.println("One or both persons not found in the network.");
        }
    }

    /**
     * Removes a friendship between two people in the social network.
     *
     * @param name1 the name of the first person
     * @param name2 the name of the second person
     */
    public void removeFriendship(String name1, String name2) {
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);
        if (person1 != null && person2 != null) {
            if (friendships.containsKey(person1) && friendships.get(person1).contains(person2)) {
                friendships.get(person1).remove(person2);
            }
            if (friendships.containsKey(person2) && friendships.get(person2).contains(person1)) {
                friendships.get(person2).remove(person1);
            }
            System.out.println("Friendship removed between " + person1.name + " and " + person2.name);
        } else {
            System.out.println("One or both persons not found in the network.");
        }
    }

    /**
     * Finds and prints the shortest path between two people using BFS.
     *
     * @param startName the name of the start person
     * @param endName   the name of the end person
     */
    public void findShortestPath(String startName, String endName) {
        Person start = people.get(startName);
        Person end = people.get(endName);
        if (start != null && end != null) {
            bfs(start, end);
        } else {
            System.out.println("People not found.");
        }
    }

    /**
     * Helper method to print the path from start to end person.
     *
     * @param start the start person
     * @param end   the end person
     * @param prev  a map of previous nodes for reconstructing the path
     */
    private void printPath(Person start, Person end, Map<Person, Person> prev) {
        List<Person> path = new ArrayList<>();
        for (Person at = end; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.print("Shortest path: ");
        for (Person p : path) {
            System.out.print(p.name);
            if (!p.name.equals(end.name)) {
                System.out.print(" -> ");
            }
        }
        System.out.println("");
    }

    /**
     * Counts and prints clusters of people in the social network using BFS.
     *
     * @return a list of clusters where each cluster is a list of people
     */
    public List<List<Person>> countClusters() {
        Set<Person> visited = new HashSet<>();
        List<List<Person>> clusters = new ArrayList<>();

        for (Person person : friendships.keySet()) {
            if (!visited.contains(person)) {
                List<Person> cluster = new ArrayList<>();
                bfs(person, visited, cluster);
                clusters.add(cluster);
            }
        }
        printCluster(clusters);
        return clusters;
    }

    /**
     * Prints the clusters of people.
     *
     * @param clusters a list of clusters where each cluster is a list of people
     */
    public void printCluster(List<List<Person>> clusters) {
        System.out.println("Number of cluster found: "+clusters.size());
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + (i+1) + ":");
            for (Person p : clusters.get(i)) {
                System.out.println(p.name);
            }
        }
    }

    /**
     * Helper method to perform BFS for counting clusters.
     *
     * @param start    the starting person
     * @param visited  a set of visited people
     * @param cluster  the current cluster being built
     */
    private void bfs(Person start, Set<Person> visited, List<Person> cluster) {
        Queue<Person> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            cluster.add(current);

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    /**
     * Helper method to perform BFS for finding the shortest path.
     *
     * @param start the starting person
     * @param end   the ending person
     */
    private void bfs(Person start, Person end) {
        Map<Person, Person> previous = new HashMap<>();
        Queue<Person> queue = new LinkedList<>();
        Set<Person> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            Person current = queue.poll();

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                    queue.add(neighbor);

                    if (neighbor.equals(end)) {
                        found = true;
                        break;
                    }
                }
            }
        }
        if (found) {
            printPath(start, end, previous);
        } else {
            System.out.println("No path found between " + start.name + " and " + end.name);
        }
    }

    /**
     * Suggests friends for a person based on mutual friends and common hobbies.
     *
     * @param personName    the name of the person for whom to suggest friends
     * @param maxSuggestions the maximum number of friend suggestions to display
     */
    public void suggestFriends(String personName, int maxSuggestions) {
        Person person = people.get(personName);
        if (person == null) {
            System.out.println("Person not found.");
            return;
        }

        Map<Person, Double> scores = new HashMap<>();

        for (Person candidate : friendships.keySet()) {
            if (!candidate.equals(person) && !friendships.get(person).contains(candidate)) {
                int mutualFriends = 0;
                for (Person friend : friendships.get(person)) {
                    if (friendships.get(candidate).contains(friend)) {
                        mutualFriends++;
                    }
                }

                Set<String> commonHobbies = new HashSet<>(person.hobbies);
                commonHobbies.retainAll(candidate.hobbies);
                double score = mutualFriends * 1 + commonHobbies.size() * 0.5;

                if (score > 0) {
                    scores.put(candidate, score);
                }
            }
        }

        List<Map.Entry<Person, Double>> sortedCandidates = new ArrayList<>(scores.entrySet());
        sortedCandidates.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        System.out.println("Friend suggestions for " + personName + ":");
        for (int i = 0; i < Math.min(maxSuggestions, sortedCandidates.size()); i++) {
            Map.Entry<Person, Double> entry = sortedCandidates.get(i);
            System.out.println(entry.getKey().name + " (Score: " + entry.getValue() + ")");
        }
    }
}
