import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    Robot buddy = new Robot("buddy",10);

    @Test
    public void getName(){
        assertEquals("buddy",buddy.getName());
    }

    @Test
    void isNotWorking() {
        assertFalse(buddy.isWorking());
    }

    @Test
    void isWorking() {
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    void setName(){
    }

    @Test
    void talkToRobot(){
    }

    @Test
    void getWorkingMsg() {
        buddy.talkToRobot();
        assertEquals("Hi i am in working mode",buddy.getWorkingMsg());
    }

    @Test
    @DisplayName("getWorkingMsgFail catch the exception")
    void getWorkingMsgFail(){
        assertThrows(IllegalStateException.class, () -> buddy.getWorkingMsg());
    }

    @Test
    void testNameFail(){
        assertThrows(IllegalArgumentException.class, () -> {Robot chuck = new Robot("",10);
        });
    }

    @Test
    void timeoutExceeded(){
        assertTimeout(Duration.ofMillis(10),() -> {
            buddy.waitTillWorking();
        });
    }
}