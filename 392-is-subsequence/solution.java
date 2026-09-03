// 392. Is Subsequence
// https://leetcode.com/problems/is-subsequence/
// Difficulty: Easy
// Language:   Java
// Submitted:  2026-09-04 01:15:40
// Runtime:    1 ms (beats 95.62%)
// Memory:     43.8 MB (beats 5.72%)
// Topics:     Two Pointers, String, Dynamic Programming

class Solution {
    public boolean isSubsequence(String s, String t) {

        if(t.contains(s)) return true;

        if(s.length() > t.length()) return false;


        return helper(s, t, 0, 0);
        
    }

    private boolean helper(String s , String t , int i , int j){
        if(i==s.length()) return true;

        if(j== t.length()) return false;

        if(s.charAt(i) == t.charAt(j)){
            return helper(s, t , i+1, j+1);
        }
        return helper(s, t , i, j+1);
    }
}
