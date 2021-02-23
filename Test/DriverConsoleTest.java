import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class DriverConsoleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    /* for console output testing */
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testnumOkMsg() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        System.setOut(new PrintStream(baos));

        Driver dave = new Driver("dave", 250);
        dave.checkNumberValid();

        baos.flush();

        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));

        assertEquals("Driver number valid", linesOfOutput[0]);
    }

    @Test
    public void testnumNotOkMsg() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        Driver dave = new Driver("dave", 5001);
        dave.checkNumberValid();

        baos.flush();

        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));

        assertEquals("Error Driver number not valid", linesOfOutput[0]);
    }

    @AfterEach
    /* for console output testing */
    public void cleanUpStreams() {
        System.setOut(null); System.setErr(null);
    }
}