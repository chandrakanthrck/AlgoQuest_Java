package doordash.bitmanipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1; // Extract the least significant bit
            result = (result << 1) | bit; // Add the bit to the reversed result
            n >>>= 1; // Unsigned right shift
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        int n1 = 0b00000010100101000001111010011100;
        System.out.println(solution.reverseBits(n1)); // Output: 964176192

        int n2 = 0b11111111111111111111111111111101;
        System.out.println(solution.reverseBits(n2)); // Output: 3221225471
    }
}

