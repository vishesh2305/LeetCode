// 216. Combination Sum III
// https://leetcode.com/problems/combination-sum-iii/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-03 02:21:37
// Runtime:    0 ms (beats 100.00%)
// Memory:     42 MB (beats 98.09%)
// Topics:     Array, Backtracking

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(k , n, 1, new ArrayList<>(), result);
        return result;
    }

    private void helper(int k , int target,  int index, List<Integer> ds, List<List<Integer>> result){

        if(ds.size() > k){
            return;
        }
        if(target == 0){
            if(ds.size()==k){
                result.add(new ArrayList<>(ds));
            }
            return; 
        }

        if(index > 9){
            return;
        }


        ds.add(index);
        helper(k , target - index, index+1, ds, result);
        ds.remove(ds.size()-1);

        helper(k , target, index+1, ds, result); 

    }
}
