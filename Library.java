import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements{

  // Attributes:
  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for Library class
   * @param name  the name of this library
   * @param address the address of this library
   * @param nFloors  the number of floors this library has
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }

  // Methods to add to/subtract from the collection

  /**
   * Adds a book to this library's collection and prints a confirmation message
   * @param title the title of the book to be added
   */
  public void addTitle(String title){
    this.collection.put(title, true);
    System.out.println("The book " + title + " has been added to the collection.");
  }

  /**
   * Removes a book from this library's collection and prints a confirmation message, if the book is in the collection, else prints an error message
   * @param title the title of the book to be removed
   * @return the title of the book removed, if the book was successfully removed, else a blank string
   */
  public String removeTitle(String title){
    if(this.containsTitle(title)){
      this.collection.remove(title);
      System.out.println("The book " + title + " has been removed from the collection.");
      return title;
    }
    else{
      System.out.println("The book " + title + " cannot be removed from the collection because it is not in the collection.");
      return "";
    }
  }
  
  // Methods to browse the collection

  /**
   * Changes the available status of a book from true to false, if status is true. Else, prints an error message.
   * @param title the title to be 'checked out' from the collection
   */
  public void checkOut(String title){
    if(this.containsTitle(title)){
      if(this.collection.get(title)){
        this.collection.replace(title, false);
        System.out.println("The book " + title + " has been checked out.");
      }
      else{
        System.out.println("The book " + title + " cannot be checked out because it has already been checked out.");
      }
    }
    else{
      System.out.println("The book " + title + " cannot be checked out because it is not in the collection.");
    }
  }

  /**
   * Changes the available status of a book from false to true, if the status is false. Else, prints an error message.
   * @param title the title to be 'returned' to the collection
   */
  public void returnBook(String title){
    if(this.containsTitle(title)){
      if(!this.collection.get(title)){
        this.collection.replace(title, true);
        System.out.println("The book " + title + " has been returned.");
      }
      else{
        System.out.println("The book " + title + " cannot be returned because it has not been checked out.");
      }
    }
    else{
      System.out.println("The book " + title + " cannot be returned because it is not in the collection.");
    }
  }

  /**
   * Checks whether a title is in this library's collection
   * @param title the title of interest
   * @return T/F: whether or not the title is in the collection
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /**
   * Checks the available status of a title in this library's collection
   * @param title the title of interest
   * @return T/F: whether or not the title is available in the collection
   */
  public boolean isAvailable(String title){
    if(this.containsTitle(title)){
      return this.collection.get(title);
    }
    else{
      return false;
    }
  }
  
  /**
   * Prints all the titles in the collection and their available status in an easily readable format
   */
  public void printCollection(){
    for(String title : collection.keySet()){
      if(this.isAvailable(title)){
        System.out.println(title + ": available");
      }
      else{
        System.out.println(title + ": checked out");
      }
    }
  }

  // Testing only
  public static void main(String[] args) {
    // Library neilson = new Library("Neilson", null, 4);
    // System.out.println(neilson.getName());
    // System.out.println(neilson.getAddress());
    // System.out.println(neilson.getFloors());
    // neilson.addTitle("Where the Wild Things Are");
    // neilson.addTitle("Blueberry Girl");
    // neilson.addTitle("Goodnight, Moon");
    // neilson.addTitle("Journey");
    // neilson.printCollection();
    // neilson.checkOut("Where the Wild Things Are");
    // neilson.checkOut("Where the Wild Things Are");
    // System.out.println(neilson.isAvailable("Where the Wild Things Are"));
    // neilson.returnBook("Where the Wild Things Are");
    // System.out.println(neilson.isAvailable("Where the Wild Things Are"));
    // neilson.checkOut("The Cat in the Hat");
    // neilson.returnBook("Blueberry Girl");
    // System.out.println(neilson.containsTitle("Where the Wild Things Are"));
    // System.out.println(neilson.containsTitle("That Cat in the Hat"));
    // neilson.printCollection();
  }  
}