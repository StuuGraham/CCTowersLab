import java.util.ArrayList;

public class ConferenceRoom {

    private int capacity;
    private ArrayList<Guest> guestAttendance;
    private String name;

    public ConferenceRoom(int capacity, String name){
        this.capacity = capacity;
        this.name = name;
        this.guestAttendance = new ArrayList<Guest>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getRoomName() {
        return this.name;
    }

    public int conferenceCountGuests(){
        return this.guestAttendance.size();
    }

    public void conferenceAddGuest(Guest guest){
        if (guestAttendance.size() < this.capacity) {
            this.guestAttendance.add(guest);
        }
    }

    public void conferenceRemoveGuest(Guest guest){
        if (guestAttendance.size() > 0 && guestAttendance.contains(guest)){
            this.guestAttendance.remove(guest);
        }
    }
}
