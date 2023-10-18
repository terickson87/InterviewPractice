package interviewpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoinChangeTest {

    @Test
    void example1() {
        // Input: coins = [1,2,5], amount = 11, Output: 3
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int expected = 3;
        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        assertEquals(expected, result);

    }

    @Test
    void example2() {
        // Input: coins = [2], amount = 3, Output: -1
        int[] coins = new int[]{2};
        int amount = 3;
        int expected = -1;
        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        assertEquals(expected, result);
    }

    @Test
    void example3() {
        // Input: coins = [1], amount = 0, Output: 0
        int[] coins = new int[]{1};
        int amount = 0;
        int expected = 0;
        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        assertEquals(expected, result);
    }
    
    @Test
    void example4() {
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        int expected = 20;
        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        assertEquals(expected, result);
    }
}
