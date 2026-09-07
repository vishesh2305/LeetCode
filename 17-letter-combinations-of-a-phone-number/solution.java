// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-08 01:24:54
// Runtime:    0 ms (beats 100.00%)
// Memory:     43.5 MB (beats 53.56%)
// Topics:     Hash Table, String, Backtracking

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] phoneMap = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        helper(digits, phoneMap, 0, new StringBuilder());

        return result;

    }

    private void helper(String digits, String[] phoneMap, int index, StringBuilder sb){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for(char ch : phoneMap[digit].toCharArray()){
            sb.append(ch);
            helper(digits, phoneMap, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
