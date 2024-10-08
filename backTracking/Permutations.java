package backTracking;

import java.util.ArrayList;
import java.util.List;

// Generate all permutations of a set
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = obj.permute(nums);
        System.out.println(result);
    }
}
