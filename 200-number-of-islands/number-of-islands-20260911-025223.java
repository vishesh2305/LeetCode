// 200. Number of Islands
// https://leetcode.com/problems/number-of-islands/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-11 02:52:23
// Runtime:    3 ms (beats 87.64%)
// Memory:     52.3 MB (beats 57.86%)
// Topics:     Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix

class Solution {
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length==0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count =0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){

                    count++;
                    helper(grid, i, j);

                }
            }
        }
        return count;
        
    }

    private void helper(char [][] grid, int curRow, int curCol){
        if(curRow < 0 || curCol < 0 || curRow >= grid.length || curCol >= grid[0].length || grid[curRow][curCol] == '0' || grid[curRow][curCol] != '1'){
            return;
        }

        grid[curRow][curCol] = '0';

        helper(grid, curRow+1, curCol);
        helper(grid, curRow, curCol+1);
        helper(grid, curRow-1, curCol);
        helper(grid, curRow, curCol-1);

    }
}
