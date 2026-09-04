// 46. Permutations
// https://leetcode.com/problems/permutations/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-05 02:39:03
// Runtime:    1 ms (beats 87.85%)
// Memory:     45.6 MB (beats 45.82%)
// Topics:     Array, Backtracking

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        helper(nums, new ArrayList<>(), used);
        return result; 
    }
    private void helper(int[] nums, List<Integer> current, boolean[] used){
        if(current.size()== nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;

            current.add(nums[i]);
            used[i] = true;
            helper(nums, current, used);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}
