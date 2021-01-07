import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceroom;

    @Before
    public void setUp(){
        conferenceroom = new ConferenceRoom(10, "The John Harper Room");
    }

    @Test
    public void roomHasCapacity(){
        assertEquals(10, conferenceroom.getCapacity());
    }

    @Test
    public void roomHasName(){
        assertEquals("The John Harper Room", conferenceroom.getRoomName());
    }
}
