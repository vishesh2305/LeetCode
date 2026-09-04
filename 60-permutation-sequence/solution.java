// 60. Permutation Sequence
// https://leetcode.com/problems/permutation-sequence/
// Difficulty: Hard
// Language:   Java
// Submitted:  2026-09-05 04:09:50
// Runtime:    1 ms (beats 99.45%)
// Memory:     42.8 MB (beats 56.98%)
// Topics:     Math, Recursion

class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> number = new ArrayList<>();
        int fact = 1;

        for(int i=1; i<n; i++){
            fact *= i;
            number.add(i);
        }
        number.add(n);

        StringBuilder sb = new StringBuilder();
        k--;

        for(int i=0; i<n; i++){
            int index = k / fact;

            sb.append(number.get(index));

            number.remove(index);

            if(i==n-1) break;

            k= k%fact;

            fact = fact/ (n-i-1);
        }

        return sb.toString();
        
    }
}
