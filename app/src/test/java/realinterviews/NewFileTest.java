package realinterviews;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NewFileTest {

    @Test 
    void given_addToVal_when_run_then_success() {
        // Arrange
        int addTo = 3;
        NewFile newFile = new NewFile(addTo);

        // Act
        int other = 5;
        int result = newFile.run(other);

        // Assert
        int expected = addTo + other;
        assertEquals(expected, result);
        
    }

    @Test 
    void given_noAddToVal_when_run_then_success() {
        // Arrange
        int defaultAddTo = 5;
        NewFile newFile = new NewFile();

        // Act
        int other = 5;
        int result = newFile.run(other);

        // Assert
        int expected = defaultAddTo + other;
        assertEquals(expected, result);
        
    }

    
}
