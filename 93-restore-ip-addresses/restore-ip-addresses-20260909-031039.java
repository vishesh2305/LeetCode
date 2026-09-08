// 93. Restore IP Addresses
// https://leetcode.com/problems/restore-ip-addresses/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-09 03:10:39
// Runtime:    5 ms (beats 41.50%)
// Memory:     45.9 MB (beats 45.21%)
// Topics:     String, Backtracking

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(String s, int Index, int segmentCount, StringBuilder sb){
        if(segmentCount == 4 && Index == s.length()){
            result.add(sb.toString());
            return;
        }

        for(int i=1 ; i<=3 && Index + i <= s.length() ; i++){
            String segment = s.substring(Index, Index + i);

            if(!(segment.length() > 1 && segment.charAt(0) == '0') && Integer.parseInt(segment) <= 255){

            int originalLength = sb.length();

            if(segmentCount >0 ){
                sb.append(".");
            }

            sb.append(segment);

            helper(s, Index + i, segmentCount+1, sb);

            sb.setLength(originalLength);
            }

        }
    }
}
