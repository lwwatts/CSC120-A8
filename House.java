import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  // Attributes:
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for House class
   * @param name the name of this house
   * @param address the address of this house
   * @param nFloors the number of floors this house has
   * @param diningRoom  whether or not this house has a dining room
   */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = diningRoom;
    this.hasElevator = elevator;
  }

  /**
   * Checks if this house has a dining room
   * @return T/F: whether or not this house has a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Gets the number of residents in this house
   * @return the size of this house's residents ArrayList
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Adds a student to this house's list of residents
   * @param s the student to be added to the house
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }

  /**
   * Removes a student from this house's list of residents
   * @param s the student to be removed
   */
  public Student moveOut(Student s){
    if(this.residents.contains(s)){
      this.residents.remove(s);
      return s;
    }
    else{
      return null;
    }
  }

  /**
   * Checks to see if a given student is a resident of this house
   * @param s the student of interest
   * @return T/F: whether or not the student is a resident
   */
  public boolean isResident(Student s){
    return this.residents.contains(s);
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
    if (!this.hasElevator && Math.abs(this.activeFloor - floorNum) > 1){
      throw new RuntimeException("This house does not have an elevator, so you cannot move more than one floor at a time.");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  /**
   * Prints out all the functions of this class that the user can call
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn(student) \n + moveOut(student) \n + isResident(student)");
  }

  public static void main(String[] args) {
    // House jordan = new House("Jordan", null, 5, false);
    // House chapin = new House("Chapin", null, 4, true);

  }

}