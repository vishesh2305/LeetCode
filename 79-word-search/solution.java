// 79. Word Search
// https://leetcode.com/problems/word-search/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-22 02:49:11
// Runtime:    107 ms (beats 94.53%)
// Memory:     43.1 MB (beats 43.73%)
// Topics:     Array, String, Backtracking, Depth-First Search, Matrix

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();


        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(helper(board, ch, i, j, 0)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean helper(char[][] board, char[] ch,int curRow, int curCol, int index){
        if(curRow < 0 || curRow >= board.length || curCol < 0 || curCol >= board[0].length){
            return false;
        }

        if(board[curRow][curCol] != ch[index]) return false;

        if(index == ch.length-1){
            return true;
        }

        if(board[curRow][curCol] == ch[index]){

            char temp = board[curRow][curCol];
            board[curRow][curCol] = '#';

            boolean found = helper(board, ch, curRow+1, curCol, index+1) ||
            helper(board, ch, curRow-1, curCol, index+1) ||
            helper(board, ch, curRow, curCol+1, index+1) ||
            helper(board, ch, curRow, curCol-1, index+1);

            board[curRow][curCol] = temp;
            return found;
        }

        return false;
    }
}
