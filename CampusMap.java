import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        // Buildings (3)
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Mendenhall Center for the Performing Arts", "122 Green Street Northampton, MA 01063", 3));
        // Libraries (2)
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Library("Josten Performing Arts Library", "122 Green Street Northampton, MA 01063", 2, false));
        // Cafes (1)
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm Street Northampton, MA 01063", 1));
        // Houses (4)
        myMap.addBuilding(new House("Chapin House", "3 Chapin Way Northampton, MA 01063", 4, true, false));
        myMap.addBuilding(new House("Jordan House", "1 Paradise Road Northampton, MA 01063", 5, false, true));
        myMap.addBuilding(new House("Tyler House", "164 Green Street Northampton, MA 01063", 3, true, false));
        myMap.addBuilding(new House("Lawrence House", "99 Green Street Northampton, MA 01063", 4, false, false));
        // Print
        System.out.println(myMap);
    }
    
}
