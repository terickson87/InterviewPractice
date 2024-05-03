package interviewpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NewPracFileTest {

    @Test 
    void given_addToVal_when_run_then_success() {
        // Arrange
        int addTo = 3;
        NewPracFile newPracFile = new NewPracFile(addTo);

        // Act
        int other = 5;
        int result = newPracFile.run(other);

        // Assert
        int expected = addTo + other;
        assertEquals(expected, result);
        
    }

    @Test 
    void given_noAddToVal_when_run_then_success() {
        // Arrange
        int defaultAddTo = 5;
        NewPracFile newPracFile = new NewPracFile();

        // Act
        int other = 5;
        int result = newPracFile.run(other);

        // Assert
        int expected = defaultAddTo + other;
        assertEquals(expected, result);
        
    }

    
}
