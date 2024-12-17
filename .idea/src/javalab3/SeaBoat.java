import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a sea boat with various properties such as name, speed, weight, capacity, and type.
 */
public class SeaBoat {

    // Fields of the SeaBoat class
    private String name;      // Name of the boat
    private int speed;        // Speed of the boat in km/h
    private double weight;    // Weight of the boat in kilograms
    private int capacity;     // Passenger capacity of the boat
    private String type;      // Type of the boat (e.g., "Fishing", "Transport", "Recreational")

    /**
     * Constructs a SeaBoat object with the specified attributes.
     *
     * @param name     Name of the boat.
     * @param speed    Speed of the boat in km/h.
     * @param weight   Weight of the boat in kilograms.
     * @param capacity Passenger capacity of the boat.
     * @param type     Type of the boat.
     */
    public SeaBoat(String name, int speed, double weight, int capacity, String type) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.capacity = capacity;
        this.type = type;
    }

    // Getters and setters for accessing and modifying the fields

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

    /**
     * Compares this SeaBoat object to another object for equality based on all fields.
     *
     * @param obj The object to compare to.
     * @return True if all fields are equal; otherwise, false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check for reference equality
        if (obj == null || getClass() != obj.getClass()) return false;  // Check for null or different class
        SeaBoat seaBoat = (SeaBoat) obj;  // Cast to SeaBoat
        // Compare all fields for equality
        return speed == seaBoat.speed &&
                Double.compare(seaBoat.weight, weight) == 0 &&
                capacity == seaBoat.capacity &&
                name.equals(seaBoat.name) &&
                type.equals(seaBoat.type);
    }

    /**
     * Generates a hash code for the SeaBoat object based on its fields.
     *
     * @return The hash code of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, speed, weight, capacity, type);
    }

    /**
     * Returns a string representation of the SeaBoat object.
     *
     * @return A string containing the boat's attributes.
     */
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
     * The main method to demonstrate sorting and searching operations on SeaBoat objects.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an array of SeaBoat objects
        SeaBoat[] boats = {
                new SeaBoat("Boat A", 60, 1200.5, 20, "Fishing"),
                new SeaBoat("Boat B", 60, 1500.0, 15, "Transport"),
                new SeaBoat("Boat C", 75, 800.0, 10, "Recreational"),
                new SeaBoat("Boat D", 55, 1000.0, 25, "Fishing"),
                new SeaBoat("Boat E", 50, 1100.0, 18, "Transport"),
                new SeaBoat("Boat J", 75, 800.0, 11, "Recreational"),
                new SeaBoat("Boat G", 80, 1400.0, 13, "Transport")
        };

        // Sort the array by speed (ascending) and capacity (descending)
        Arrays.sort(boats, Comparator.comparingInt(SeaBoat::getSpeed)
                .thenComparing(Comparator.comparingInt(SeaBoat::getCapacity).reversed()));

        // Print the sorted array
        System.out.println("Sorted boats:");
        for (SeaBoat boat : boats) {
            System.out.println(boat);
        }

        // Search for a specific boat in the array
        SeaBoat targetBoat = new SeaBoat("Boat C", 75, 800.0, 10, "Recreational");
        boolean found = Arrays.stream(boats).anyMatch(boat -> boat.equals(targetBoat));

        // Output the search result
        System.out.println("\nSearching for: " + targetBoat);
        System.out.println(found ? "Boat found in the array." : "Boat not found in the array.");
    }
}
