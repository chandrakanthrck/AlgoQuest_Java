package doordash.greedyAlgorithm;

public class CountAllPUDO {
    public int countOrders(int n) {
        // Modulo value to handle large numbers
        int MOD = 1_000_000_007;
        long result = 1;

        // Calculate the number of valid sequences
        for (int i = 1; i <= n; i++) {
            result = result * i % MOD;       // Factorial for pickups
            result = result * (2 * i - 1) % MOD; // Number of ways to arrange deliveries
        }

        return (int) result;
    }
}
