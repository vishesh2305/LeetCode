// 491. Non-decreasing Subsequences
// https://leetcode.com/problems/non-decreasing-subsequences/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-04 00:10:01
// Runtime:    6 ms (beats 93.73%)
// Memory:     51.8 MB (beats 98.87%)
// Topics:     Array, Hash Table, Backtracking, Bit Manipulation

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> ds){
        if(ds.size() >= 2){
            result.add(new ArrayList<>(ds));
        }

        if(index == nums.length) return;

        Set<Integer> seen = new HashSet<>();
        for(int i= index; i<nums.length; i++){
            if(seen.contains(nums[i]) || (!ds.isEmpty() && (nums[i] < ds.get(ds.size()-1)))) continue;
            seen.add(nums[i]);
            ds.add(nums[i]);
            helper(nums, i+1, ds);
            ds.remove(ds.size()-1);
        }

    }
}
