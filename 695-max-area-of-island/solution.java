// 695. Max Area of Island
// https://leetcode.com/problems/max-area-of-island/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-22 01:51:05
// Runtime:    2 ms (beats 63.24%)
// Memory:     46.4 MB (beats 82.62%)
// Topics:     Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix

class Solution {
    int MaxCount = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == true){
                    continue;
                }
                MaxCount = Math.max(MaxCount , helper(grid, i, j, visited));
            }
        }

        return MaxCount;
    }

    private int helper(int[][] grid, int currRow, int currCol, boolean[][] visited){
        if(currRow >= grid.length || currCol >= grid[0].length || currRow <0 || currCol < 0){
            return 0;
        }

        if(grid[currRow][currCol] == 0){
            visited[currRow][currCol] = true;
            
            return 0;
        }


        if((grid[currRow][currCol] == 1) && (visited[currRow][currCol] != true)){
            visited[currRow][currCol] = true;
            return (1 + helper(grid, currRow+1, currCol,visited) +
            helper(grid, currRow, currCol+1,visited)
            + helper(grid, currRow-1, currCol,visited)
            + helper(grid, currRow, currCol-1,visited));
        }

        return 0;
    }
}
