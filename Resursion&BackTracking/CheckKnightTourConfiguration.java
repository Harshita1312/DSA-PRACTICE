class Solution {
    public boolean isValid(int[][] grid, int j, int i, int n, int expVal){
        if(i<0 || j<0 || i>=n || j>=n || (grid[j][i] != expVal)) return false;
        if(grid[j][i] == (n*n)-1) return true;
        boolean ans1 = isValid(grid, j-2, i+1, grid.length, expVal+1);
        boolean ans2 = isValid(grid, j-2, i-1, grid.length, expVal+1);
        boolean ans3 = isValid(grid, j+2, i+1, grid.length, expVal+1);
        boolean ans4 = isValid(grid, j+2, i-1, grid.length, expVal+1);
        boolean ans5 = isValid(grid, j-1, i+2, grid.length, expVal+1);
        boolean ans6 = isValid(grid, j+1, i+2, grid.length, expVal+1);
        boolean ans7 = isValid(grid, j-1, i-2, grid.length, expVal+1);
        boolean ans8 = isValid(grid, j+1, i-2, grid.length, expVal+1);
        return (ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8);
    }
    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0, 0, grid.length, 0);
    }
}
