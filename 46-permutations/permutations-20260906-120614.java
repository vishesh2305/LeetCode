// 46. Permutations
// https://leetcode.com/problems/permutations/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-06 12:06:14
// Runtime:    2 ms (beats 34.77%)
// Memory:     45.6 MB (beats 45.77%)
// Topics:     Array, Backtracking

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        helper(nums, used, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, boolean[] used, List<Integer> ds){
        if(ds.size()== nums.length){
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            ds.add(nums[i]);
            used[i] = true;
            helper(nums, used, ds);
            ds.remove(ds.size()-1);
            used[i] = false;
        }
    }
}
