// 47. Permutations II
// https://leetcode.com/problems/permutations-ii/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-05 03:29:28
// Runtime:    3 ms (beats 92.97%)
// Memory:     47 MB (beats 13.13%)
// Topics:     Array, Backtracking, Sorting

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        helper(nums, used, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, boolean[] used, List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && used[i-1] == false && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            used[i] = true;
            helper(nums, used, current);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}
