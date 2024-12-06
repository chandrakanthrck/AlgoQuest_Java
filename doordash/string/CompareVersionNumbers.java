package doordash.string;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        // Split both versions into parts
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        // Compare corresponding parts
        int maxLength = Math.max(v1Parts.length, v2Parts.length);
        for (int i = 0; i < maxLength; i++) {
            int num1 = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int num2 = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;

            // Compare current parts
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }

        // If all parts are equal
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers solver = new CompareVersionNumbers();

        System.out.println("Compare '1.01' and '1.001': " + solver.compareVersion("1.01", "1.001")); // Output: 0
        System.out.println("Compare '1.0' and '1.0.0': " + solver.compareVersion("1.0", "1.0.0"));   // Output: 0
        System.out.println("Compare '0.1' and '1.1': " + solver.compareVersion("0.1", "1.1"));       // Output: -1
    }
}
