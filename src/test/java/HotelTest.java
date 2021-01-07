import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    BedRoom bedroom;
    BedRoom bedroom2;
    BedRoom bedroom3;
    ConferenceRoom conferenceroom;
    Guest guest;
    Guest guest2;
    Guest guest3;
    Guest guest4;
    Booking booking;
    DiningRoom diningroom;

    @Before
    public void setUp() {
        bedroom = new BedRoom(1, 2, RoomType.SINGLE);
        bedroom2 = new BedRoom(2,1, RoomType.SINGLE);
        bedroom3 = new BedRoom(3,2,RoomType.DOUBLE);
        conferenceroom = new ConferenceRoom(10, "The Stuart Room");
        hotel = new Hotel();
        guest = new Guest("Emily Cullen");
        guest2 = new Guest("Stuart Graham");
        guest3 = new Guest("John Harper");
        guest4 = new Guest("Roosa P");
        diningroom = new DiningRoom("Pizza Express");


    }

    @Test
    public void hotelCanHaveRooms() {
        hotel.addBedRoom(bedroom);
        hotel.addConferenceRoom(conferenceroom);
        assertEquals(1, hotel.countBedRooms());
        assertEquals(1, hotel.countConferenceRooms());
    }

    @Test
    public void hotelCanAddGuestToBedRoom() {
        hotel.addBedRoom(bedroom);
        hotel.addGuestToBedRoom(bedroom, guest);
        assertEquals(1, bedroom.countGuests());
    }

    @Test
    public void hotelCanRemoveGuestFromBedRoom() {
        hotel.addBedRoom(bedroom);
        hotel.addGuestToBedRoom(bedroom, guest);
        hotel.addGuestToBedRoom(bedroom, guest2);
        hotel.removeGuestFromBedRoom(bedroom, guest);
        assertEquals(1, bedroom.countGuests());
    }

    @Test
    public void hotelWontRemoveGuestIfNotInRoom() {
        hotel.addBedRoom(bedroom);
        hotel.addGuestToBedRoom(bedroom, guest);
        hotel.removeGuestFromBedRoom(bedroom, guest2);
        assertEquals(1, bedroom.countGuests());
    }

    @Test
    public void hotelCanAddGuestToConferenceRoom() {
        hotel.addConferenceRoom(conferenceroom);
        hotel.addGuestToConferenceRoom(conferenceroom, guest);
        assertEquals(1, conferenceroom.conferenceCountGuests());
    }

    @Test
    public void hotelCanRemoveGuestFromConferenceRoom() {
        hotel.addConferenceRoom(conferenceroom);
        hotel.addGuestToConferenceRoom(conferenceroom, guest);
        hotel.addGuestToConferenceRoom(conferenceroom, guest);
        hotel.removeGuestFromConferenceRoom(conferenceroom, guest);
        assertEquals(1, conferenceroom.conferenceCountGuests());
    }

    @Test
    public void hotelCanMakeNewBooking() {
        booking = hotel.makeNewBooking(bedroom, 3);
        assertEquals(bedroom, booking.getBedroom());
        assertEquals(3, booking.getNightsBooked());
    }

    @Test
    public void hotelCanCheckBookingCost() {
        booking = hotel.makeNewBooking(bedroom, 3);
        assertEquals(150, hotel.calculateBookingCost(booking));
    }

    @Test
    public void hotelCanCheckHashMap() {
        hotel.addDiningRoomToHashMap(diningroom);
        assertEquals(diningroom, hotel.getDiningRoomObject("Pizza Express"));
    }

    @Test
    public void hotelWillNotReturnFullRooms() {
        hotel.addBedRoom(bedroom);
        hotel.addBedRoom(bedroom2);
        hotel.addBedRoom(bedroom3);
        hotel.addGuestToBedRoom(bedroom, guest);
        assertEquals(2,hotel.returnEmptyBedrooms().size());
    }
}