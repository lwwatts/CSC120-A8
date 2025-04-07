import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  // Attributes:
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;
  private int capacity;

  /**
   * Default constructor for House class
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
    this.capacity = -1;
  }

  /* Overloaded constructor that adds a cap to the number of residents */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator, int cap){
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = diningRoom;
    this.hasElevator = elevator;
    this.capacity = cap;
  }

  /* Overloaded constructor that adds a starting list of residents */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator, ArrayList<Student> students) {
    super(name, address, nFloors);
    this.residents = students;
    this.hasDiningRoom = diningRoom;
    this.hasElevator = elevator;
    this.capacity = -1;
  }

  /* Overloaded constructor that adds a starting list of residents and a cap to the number of residents */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator, int cap, ArrayList<Student> students){
    super(name, address, nFloors);
    this.residents = students;
    this.hasDiningRoom = diningRoom;
    this.hasElevator = elevator;
    this.capacity = cap;
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
   * Adds a student to this house's list of residents if there's space
   * @param s the student to be added to the house
   */
  public void moveIn(Student s){
    if(capacity == -1 || this.residents.size() < capacity){
      this.residents.add(s);
      System.out.println(s.getName() + " has moved into " + this.name);
    }
    else{
      System.out.println("Sorry, " + s.getName() + " cannot be added to this house because this house is full.");
    }
  }

  /**
   * Adds multiple students to this house's list of residents as long as there's space
   * @param students the students to be added to the house
   */
  public void moveIn(ArrayList<Student> students){
    for(Student s: students){
      if(capacity == -1 || this.residents.size() < capacity){
        this.residents.add(s);
        System.out.println(s.getName() + " has moved into " + this.name);
      }
      else{
        System.out.println("Sorry, " + s.getName() + " cannot be added to this house because this house is full.");
      }
    }
  }

  /**
   * Removes a student from this house's list of residents
   * @param s the student to be removed
   */
  public Student moveOut(Student s){
    if(this.residents.contains(s)){
      this.residents.remove(s);
      System.out.println(s.getName() + " has moved out of " + this.name);
      return s;
    }
    else{
      System.out.println(s.getName() + " cannot move out of " + this.name + " because they do not live there");
      return null;
    }
  }

  /**
   * Removes multiple students from this house at once as long as the students are in the house
   * @param students a list of students to be moved out
   * @return a list of students that have moved out
   */
  public ArrayList<Student> moveOut(ArrayList<Student> students){
    ArrayList<Student> movedOut = new ArrayList<>();
    for(Student s: students){
      Student result = this.moveOut(s);
      if(result != null){
        movedOut.add(result);
      }
    }
    return movedOut;
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
    // House jordan = new House("Jordan", null, 5, false, true, 2);
    // House chapin = new House("Chapin", null, 4, true, false);
    // jordan.moveIn(new Student("test", "99XXXXXXX", 2028));
    // jordan.moveIn(new Student("Test2", "990XXXXXXXXXX", 2025));
    // jordan.moveIn(new Student("Test3", "991XXXXXXXXXX", 2027));
    // ArrayList<Student> testList = new ArrayList<>();
    // testList.add(new Student("s1", "99XXXXXXX", 2028));
    // testList.add(new Student("s2", "99XXXXXXX", 2028));
    // chapin.moveIn(testList);
    // chapin.moveOut(testList);
    // jordan.moveOut(new Student("fake", "fake", 0000));
  }

}