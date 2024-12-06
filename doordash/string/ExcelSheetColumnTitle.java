package doordash.string;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();

        while (columnNumber > 0) {
            // Adjust to 0-indexed (Excel columns are 1-indexed)
            columnNumber--;
            // Get the current character
            char current = (char) ('A' + (columnNumber % 26));
            title.append(current);
            // Move to the next digit
            columnNumber /= 26;
        }

        // Reverse the result since we built it backwards
        return title.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle solver = new ExcelSheetColumnTitle();

        System.out.println("Column 1: " + solver.convertToTitle(1)); // Output: "A"
        System.out.println("Column 28: " + solver.convertToTitle(28)); // Output: "AB"
        System.out.println("Column 701: " + solver.convertToTitle(701)); // Output: "ZY"
    }
}

