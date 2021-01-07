import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedRoomTest {

    BedRoom bedroom;

    @Before
    public void setUp(){
        bedroom = new BedRoom(1,2,RoomType.SINGLE);
    }

    @Test
    public void roomHasNumber(){
        assertEquals(1, bedroom.getRoomNumber());
    }

    @Test
    public void roomHasCapacity(){
        assertEquals(2, bedroom.getRoomCapacity());
    }

    @Test
    public void roomHasSize(){
        assertEquals(RoomType.SINGLE, bedroom.getRoomSize());
    }

    @Test
    public void guestCollectionStartsEmpty(){
        assertEquals(0, bedroom.countGuests());
    }
}
