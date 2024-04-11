package realinterviews;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringSetOperationsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test 
    void given_test1_when_run_then_success() throws IOException {
        // Arrange
        String input = String.join("\n", "Add|Dog", "Get|Dog", "Remove|Dog", "Has|Dog");
        provideInput(input);

        // Act
        String[] args = {};
        StringSetOperations.main(args);

        // Assert
        String expected = String.join("\n", "True", "Dog", "True", "False") + "\n";
        String result = outContent.toString();
        assertEquals(expected, result);
    }

    @Test 
    void given_test2_when_run_then_success() throws IOException {
        // Arrange
        String input = String.join("\n", "Get|English", "Add|English", "Add|German", "Add|Mandarin", "Add|Malay", "Get|German", "Get|Mandarin", "Has|French", "Add|French", "Has|French", "Reset", "Has|English", "Has|German", "Has|Mandarin", "Has|Malay", "Has|French");
        provideInput(input);

        // Act
        String[] args = {};
        StringSetOperations.main(args);

        // Assert
        String expected = String.join("\n", "NULL", "True", "True", "True", "True", "German", "Mandarin", "False", "True", "True", "5", "False", "False", "False", "False", "False") + "\n";
        String result = outContent.toString();
        assertEquals(expected, result);
    }

    @Test 
    void given_test3_when_run_then_success() throws IOException {
        // Arrange
        String input = String.join("\n", "Add|A", "Add|B", "Add|C", "Add|D", "Get|A", "Get|B", "Get|1", "Get|2", "Add|1", "Add|2", "Get|2", "Remove|A", "Remove|B", "Remove|C", "Has|A ", "Get|A", "Add|A", "Has|A", "Get|A", "Reset", "Get|C");
        provideInput(input);

        // Act
        String[] args = {};
        StringSetOperations.main(args);

        // Assert
        String expected = String.join("\n", "True", "True", "True", "True", "A", "B", "NULL", "NULL", "True", "True", "2", "True", "True", "True", "False", "NULL", "True", "True", "A", "4", "NULL") + "\n";
        String result = outContent.toString();
        assertEquals(expected, result);
    }

}
