package backTracking;

import java.util.ArrayList;
import java.util.List;

// Find all combinations that sum to a target
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) result.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(result, tempList, candidates, remain - candidates[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = obj.combinationSum(candidates, 7);
        System.out.println(result);
    }
}
