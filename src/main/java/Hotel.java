import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<BedRoom> bedRoomCollection;
    private ArrayList<ConferenceRoom> conferenceRoomCollection;
    private HashMap<String, DiningRoom> diningRoomHashMap;

    public Hotel(){
        this.bedRoomCollection = new ArrayList<BedRoom>();
        this.conferenceRoomCollection = new ArrayList<ConferenceRoom>();
        this.diningRoomHashMap = new HashMap<>();
    }

    public int countBedRooms() {
        return this.bedRoomCollection.size();
    }

    public int countConferenceRooms() {
        return this.conferenceRoomCollection.size();
    }

    public void addBedRoom(BedRoom bedroom) {
        this.bedRoomCollection.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceroom) {
        this.conferenceRoomCollection.add(conferenceroom);
    }

    public void addGuestToBedRoom(BedRoom bedroom, Guest guest) {
//        if (bedroom.countGuests() == 0 ){
            bedroom.addGuest(guest);
//        }
    }

    public void addGuestToConferenceRoom(ConferenceRoom conferenceRoom, Guest guest) {
        conferenceRoom.conferenceAddGuest(guest);
    }

    public void removeGuestFromBedRoom(BedRoom bedroom, Guest guest) {
        bedroom.removeGuest(guest);
    }

    public void removeGuestFromConferenceRoom(ConferenceRoom conferenceroom, Guest guest) {
        conferenceroom.conferenceRemoveGuest(guest);
    }

    public Booking makeNewBooking(BedRoom bedroom, int nightsBooked){
        return new Booking(bedroom, nightsBooked);
    }

    public int calculateBookingCost(Booking booking){
        BedRoom bedroomBooked = booking.getBedroom();
        return booking.getNightsBooked() * bedroomBooked.getNightlyValueFromRoomType();
    }

    public void addDiningRoomToHashMap(DiningRoom diningroom){
        String roomName = diningroom.getName();
        this.diningRoomHashMap.put(roomName, diningroom);
    }

    public DiningRoom getDiningRoomObject(String name){
        return this.diningRoomHashMap.get(name);
    }

    public ArrayList returnEmptyBedrooms(){
        ArrayList emptyBedrooms = new ArrayList<BedRoom>();
        for (BedRoom bedroom : this.bedRoomCollection){
            if (bedroom.countGuests() == 0){
                emptyBedrooms.add(bedroom);
            }
        }
        return emptyBedrooms;
    }
}
