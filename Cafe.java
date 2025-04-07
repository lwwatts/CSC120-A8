/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    // Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Default constructor for the Cafe class
     * @param name the name of this cafe
     * @param address the address of this cafe
     * @param floors the number of floors this cafe has
     */
    public Cafe(String name, String address, int floors){
        super(name, address, floors);
        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;
        System.out.println("You have built a cafe: ☕");
    }
    
    /* Overloaded constructor with number of coffee ounces, sugar packets, cream splashes, and cups */
    public Cafe(String name, String address, int floors, int coffee, int sugar, int cream, int cups) {
        super(name, address, floors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Deducts from this cafe's inventory the resources required to fill the given coffee order, prints a confirmation message
     * @param size the number of ounces of coffee needed for the given order
     * @param sugars the number of sugar packets needed for the given order
     * @param creams the number of cream "splashes" needed for the given order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        int restock_coffee = 0;
        int restock_sugar = 0;
        int restock_cream = 0;
        int restock_cups = 0;
        if(this.nCoffeeOunces < size){
            restock_coffee = 80;
        }
        if(this.nSugarPackets < nSugarPackets){
            restock_sugar = 20;
        }
        if(this.nCreams < nCreams){
            restock_cream = 20;
        }
        if(this.nCups == 0){
            restock_cups = 20;
        }
        if(restock_coffee != 0 || restock_sugar != 0 || restock_cream != 0 || restock_cups != 0){
            System.out.println("Taking a moment to restock before completing order!");
            this.restock(restock_coffee, restock_sugar, restock_cream, restock_cups);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Coffee sold!");
    }

    /* Overloaded sellCoffee method that sells a default coffee (12 oz, 1 sugar packet, 2 splashes of cream) */
    public void sellCoffee(){
        this.sellCoffee(12, 1, 2);
    }

    /**
     * Restocks the cafe's inventory when an inventory item is not sufficient to fulfill an order
     * @param coffees the number of ounces of coffee to be added to the inventory
     * @param sugars the number of sugar packets to be added to the inventory
     * @param creams the number of cream "splashes" to be added to the inventory
     * @param cups the number of cups to be added to the inventory
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    // Overridden Building methods
    
    /**
    * Moves the user to a given floor in the building if the user is in the building and able to go to that floor
    */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum > 1){
            throw new RuntimeException("You are not allowed on any floors of this cafe except the first floor.");
        }
    }

    /**
    * Prints out all the functions of this class that the user can call
    */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugar, nCream)");
    }
    
    public static void main(String[] args) {
        // Cafe testCafe = new Cafe("Test", "unknown", 2, 20, 10, 10, 10);
        // testCafe.showOptions();
        // testCafe.sellCoffee();
        // testCafe.sellCoffee(20, 6, 8);
        // testCafe.enter();
        // testCafe.exit();
    }
    
}
