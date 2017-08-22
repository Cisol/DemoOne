package com.cisol.algorithm; /**
 * Created by Administrator on 2017/6/19 0019.
 */

/**
 * 动态规划
 * Given a m x n grid filled with non-negative numbers, find a path from top left
 * to bottom right which minimizes the sum of all numbers along its path.
 */
public class DP {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] column = new int[m]; //记录当前列与之前一列的值
        column[0] = grid[0][0];  //初始化column[0]
        for(int i=1; i<m; i++)
            column[i] = column[i-1] + grid[i][0];  //初始化第一列
        for(int i=1; i<n; i++) {
            column[0] = grid[0][i] + column[0];  //计算当前列第一行的值
            for(int j=1; j<m; j++) {
                column[j] = Math.min(column[j-1], column[j]) + grid[j][i];  //计算当前列其他行的值
            }
        }
        return column[m-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,5},{3,2,1}};
        int minPath = minPathSum(grid);
        System.out.println(minPath);
    }
}
