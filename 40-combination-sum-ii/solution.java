// 40. Combination Sum II
// https://leetcode.com/problems/combination-sum-ii/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-03 01:30:29
// Runtime:    5 ms (beats 99.26%)
// Memory:     44.5 MB (beats 99.66%)
// Topics:     Array, Backtracking

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> ds){
        if(target==0){
            result.add(new ArrayList<>(ds));
            return;
        }
        if(index==candidates.length){
            return;
        }


        for(int i= index; i<candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }

            if(candidates[i] > target){
                break;
            }

            ds.add(candidates[i]);
            helper(candidates, target-candidates[i], i+1, ds);
            ds.remove(ds.size()-1);

        }

    }
}
