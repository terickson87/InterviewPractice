package realinterviews;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountStringInstancesTest {
    
    @Test
    void given_2MatchingPattern_when_countIstances_then_returns2() {
        CountStringInstances countStringInstances = new CountStringInstances();
        String pattern = "abr";
        String findIn = "abracadabra";

        int count = countStringInstances.countInstances(pattern, findIn);
        assertEquals(2, count);
    }

    @Test
    void given_1MatchingPattern_when_countIstances_then_returns1() {
        CountStringInstances countStringInstances = new CountStringInstances();
        String pattern = "abr";
        String findIn = "abracadab";

        int count = countStringInstances.countInstances(pattern, findIn);
        assertEquals(1, count);
    }

    @Test
    void given_0MatchingPattern_when_countIstances_then_returns0() {
        CountStringInstances countStringInstances = new CountStringInstances();
        String pattern = "bat";
        String findIn = "abracadabra";

        int count = countStringInstances.countInstances(pattern, findIn);
        assertEquals(0, count);
    }
}
