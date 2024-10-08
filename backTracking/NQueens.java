package backTracking;

import java.util.ArrayList;
import java.util.List;

// Solve the N-Queens puzzle
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n);
        return result;
    }
    
    private void backtrack(List<List<String>> result, List<Integer> tempList, int n) {
        if (tempList.size() == n) {
            result.add(generateBoard(tempList, n));
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(tempList, i)) {
                    tempList.add(i);
                    backtrack(result, tempList, n);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    
    private boolean isValid(List<Integer> tempList, int col) {
        int row = tempList.size();
        for (int i = 0; i < row; i++) {
            if (tempList.get(i) == col || Math.abs(tempList.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> generateBoard(List<Integer> tempList, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < tempList.size(); i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (tempList.get(i) == j) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            board.add(row.toString());
        }
        return board;
    }
    
    public static void main(String[] args) {
        NQueens obj = new NQueens();
        List<List<String>> result = obj.solveNQueens(4);
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
