import java.util.ArrayList;

public class BedRoom {

    private int roomNumber;
    private int capacity;
    private ArrayList<Guest> guestCollection;
    private RoomType size;

    public BedRoom(int roomNumber, int capacity, RoomType size){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.size = size;
        this.guestCollection = new ArrayList<Guest>();
    }

    public int countGuests(){
        return this.guestCollection.size();
    }

    public void addGuest(Guest guest){
        if (guestCollection.size() < this.capacity) {
            this.guestCollection.add(guest);
        }
    }

    public void removeGuest(Guest guest){
        if (guestCollection.size() > 0 && guestCollection.contains(guest)){
            this.guestCollection.remove(guest);
        }
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public int getRoomCapacity() {
        return this.capacity;
    }

    public RoomType getRoomSize() {
        return this.size;
    }

    public int getNightlyValueFromRoomType(){
        return this.size.getNightlyRate();
    }

}
