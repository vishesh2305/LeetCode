// 491. Non-decreasing Subsequences
// https://leetcode.com/problems/non-decreasing-subsequences/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-04 00:02:33
// Runtime:    7 ms (beats 69.89%)
// Memory:     51.3 MB (beats 99.91%)
// Topics:     Array, Hash Table, Backtracking, Bit Manipulation

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> current) {
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }
        ;

        if (index == nums.length)
            return;

        Set<Integer> seen = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            if (seen.contains(nums[i]) || (!current.isEmpty() && nums[i] < current.get(current.size() - 1)))
                continue;
            seen.add(nums[i]);

            current.add(nums[i]);

            helper(nums, i + 1, current);
            current.remove(current.size() - 1);
        }

    }
}
