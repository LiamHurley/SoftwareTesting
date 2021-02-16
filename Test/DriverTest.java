import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    Driver alan = new Driver("alan",100);

    @Test
    public void getDriverName(){
        assertEquals("driver",alan.getDriverName());
    }

    @Test
    public void testNameFail(){
        assertThrows(IllegalArgumentException.class, () -> {
            Driver dave = new Driver("",100);
        });
    }

    @Test
    public void testNumberFail()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            Driver paul = new Driver("paul",99);
        });
    }

    @Test
    public void isNotBanned(){
        assertFalse(alan.check_status());
    }

}