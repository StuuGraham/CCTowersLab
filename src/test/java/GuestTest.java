import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void setUp(){
        guest = new Guest("Stuart Graham");
    }

    @Test
    public void guestHasName(){
        assertEquals("Stuart Graham", guest.getName());
    }
}
