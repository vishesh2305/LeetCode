// 60. Permutation Sequence
// https://leetcode.com/problems/permutation-sequence/
// Difficulty: Hard
// Language:   Java
// Submitted:  2026-09-05 03:56:28
// Runtime:    1 ms (beats 99.45%)
// Memory:     42.9 MB (beats 40.22%)
// Topics:     Math, Recursion

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();

        int fact = 1;

        for(int i=1; i<n; i++){
            fact *= i;
            numbers.add(i);
        }

        numbers.add(n);

        k--;

        StringBuilder sb = new StringBuilder();


        for(int i=0; i<n; i++){
            int index = k / fact;
            sb.append(numbers.get(index));

            numbers.remove(index);

            if(i==n-1) break;


            k=k% fact;

            fact = fact / (n-i-1);
        }

        return sb.toString();
    }
}
