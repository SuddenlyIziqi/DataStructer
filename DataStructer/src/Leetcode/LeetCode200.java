package Leetcode;

/**
 *200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 */
public class LeetCode200 {
    char[][] grid ;
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        int maxIslands=0;
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        this.grid = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(this.grid[i][j]=='1'){
                    maxIslands++;
                    dfs(i,j);
                }
            }
        }
        return maxIslands;
    }
    public void dfs(int x, int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length){
            return ;
        }
        if(grid[x][y]!='1'){
            return;
        }
        grid[x][y] = 2;
        dfs(x,y-1);
        dfs(x,y+1);
        dfs(x-1,y);
        dfs(x+1,y);
    }
}
