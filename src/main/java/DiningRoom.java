import java.util.ArrayList;

public class DiningRoom {

    private String name;
    private ArrayList<Guest> dinnerGuests;

    public DiningRoom(String name){
        this.name = name;
        this.dinnerGuests = new ArrayList<Guest>();
    }

    public String getName() {
        return this.name;
    }


}
