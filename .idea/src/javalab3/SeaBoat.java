import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Class representing a SeaBoat with various properties.
 */
public class SeaBoat {

    // Fields of the SeaBoat class representing boat characteristics
    private String name;      // Boat name
    private int speed;        // Boat speed (in km/h)
    private double weight;    // Boat weight (in kg)
    private int capacity;     // Boat capacity (number of passengers)
    private String type;      // Boat type (e.g., "Fishing", "Transport", "Recreational")

    // Constructor to create a SeaBoat object
    public SeaBoat(String name, int speed, double weight, int capacity, String type) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.capacity = capacity;
        this.type = type;
    }

    // Getters and setters to access and modify the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Overriding the equals() method for comparing SeaBoat objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Return true if objects are the same
        if (obj == null || getClass() != obj.getClass()) return false;  // Return false if null or different class
        SeaBoat seaBoat = (SeaBoat) obj;  // Cast the object to SeaBoat
        // Compare all fields to check for equality
        return speed == seaBoat.speed &&
                Double.compare(seaBoat.weight, weight) == 0 &&
                capacity == seaBoat.capacity &&
                name.equals(seaBoat.name) &&
                type.equals(seaBoat.type);
    }

    // Overriding the hashCode() method for correct comparison in data structures
    @Override
    public int hashCode() {
        return Objects.hash(name, speed, weight, capacity, type);
    }

    // Overriding the toString() method to provide a readable string representation of the object
    @Override
    public String toString() {
        return "SeaBoat{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     * Main method to execute the program.
     */
    public static void main(String[] args) {
        // Creating an array of SeaBoat objects
        SeaBoat[] boats = {
                new SeaBoat("Boat A", 60, 1200.5, 20, "Fishing"),
                new SeaBoat("Boat B", 45, 1500.0, 15, "Transport"),
                new SeaBoat("Boat C", 75, 800.0, 10, "Recreational"),
                new SeaBoat("Boat D", 55, 1000.0, 25, "Fishing"),
                new SeaBoat("Boat E", 50, 1100.0, 18, "Transport")
        };

        // Sorting the array by speed (ascending) and capacity (descending)
        Arrays.sort(boats, Comparator.comparingInt(SeaBoat::getSpeed)
                .thenComparing(Comparator.comparingInt(SeaBoat::getCapacity).reversed()));

        // Printing the sorted array
        System.out.println("Sorted boats:");
        for (SeaBoat boat : boats) {
            System.out.println(boat);
        }

        // Searching for a specific boat
        SeaBoat targetBoat = new SeaBoat("Boat C", 75, 800.0, 10, "Recreational");
        boolean found = Arrays.stream(boats).anyMatch(boat -> boat.equals(targetBoat));

        // Output the search result
        System.out.println("\nSearching for: " + targetBoat);
        System.out.println(found ? "Boat found in the array." : "Boat not found in the array.");
    }
}
