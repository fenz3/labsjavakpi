package javalab6;

import java.util.*;

/**
 * Class representing a playroom containing a collection of toys.
 */
public class PlayRoom {
    private List<Toy> toys;   // List of toys
    private double budget;    // Fixed budget for the room

    /**
     * Constructor for PlayRoom.
     *
     * @param budget The budget allocated for toys.
     */
    public PlayRoom(double budget) {
        if (budget <= 0) {
            throw new IllegalArgumentException("Budget must be greater than zero.");
        }
        this.budget = budget;
        this.toys = new ArrayList<>();
    }

    /**
     * Adds a toy to the playroom if it fits within the budget.
     *
     * @param toy The toy to be added.
     */
    public void addToy(Toy toy) {
        if (getTotalPrice() + toy.getPrice() <= budget) {
            toys.add(toy);
        } else {
            System.out.println("Cannot add " + toy.getName() + ": Budget exceeded!");
        }
    }

    /**
     * Calculates the total price of toys in the room.
     */
    public double getTotalPrice() {
        return toys.stream().mapToDouble(Toy::getPrice).sum();
    }

    /**
     * Sorts toys by price in ascending order.
     */
    public void sortByPrice() {
        toys.sort(Comparator.comparingDouble(Toy::getPrice));
    }

    /**
     * Finds toys within a given price range.
     */
    public void findToysInRange(double minPrice, double maxPrice) {
        System.out.println("\nToys in price range $" + minPrice + " - $" + maxPrice + ":");
        toys.stream()
                .filter(toy -> toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice)
                .forEach(Toy::display);
    }

    /**
     * Displays all toys in the playroom.
     */
    public void displayToys() {
        System.out.println("\nToys in the PlayRoom:");
        toys.forEach(Toy::display);
    }

    public static void main(String[] args) {
        PlayRoom playRoom = new PlayRoom(100);

        // Add toys
        playRoom.addToy(new Car("Racing Car", 20, 6, "Small"));
//        playRoom.addToy(new Car("Nissan GTR Car", 80, 7, "Small"));
        playRoom.addToy(new Doll("Barbie", 15, 4, "Plastic"));
//        playRoom.addToy(new Doll("Caddy", 23, 4, "Plastic"));
        playRoom.addToy(new Ball("Football", 10, 5, "Leather"));
//        playRoom.addToy(new Ball("Basketball", 25, 10, "Leather"));
        playRoom.addToy(new BlockSet("Lego", 30, 7, 500));

        // Display toys
        playRoom.displayToys();

        // Sort by price and display
        playRoom.sortByPrice();
        System.out.println("\nToys sorted by price:");
        playRoom.displayToys();

        // Find toys in a price range
        playRoom.findToysInRange(10, 25);
    }
}
