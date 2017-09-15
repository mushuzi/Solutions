/**
*LZS
*Solution64：最小路径和。给定一个m*n的二维网格，每个网格有一个非负的权重，求从最左上角到最右下角的最小路径和？
*	要求：任何情况下只能向右或向下移动。
*
*思路：动态规划（DP）
*	1.对于网格的第一行，当前路径和 = 前一个格子的路径和 + 当前格子的权重（因为当前格子只能是前一个格子向右走得到的）
*	2.对于网格的第一列，当前路径和 = 上一个格子的路径和 + 当前格子的权重（因为当前格子只能是前一个格子向下走得到的）
*	3.对于其他的网格，当前路径和 = min{前一个格子的路径和， 上一个格子的路径和} + 当前格子的权重
*	（因为当前格子可能是前一个格子向右走得到的，也可以是上一个格子向下走得到的）
*接下来直接编程搞定就可以了！
**/

class Solution {
    public int minPathSum(int[][] grid) {
        
        if(grid == null)    return -1;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
                 
        for(int j = 1; j < n; j++)
        	sum[0][j] = sum[0][j-1] + grid[0][j];
        
        for(int i =1; i < m; i++)
        	sum[i][0] = sum[i-1][0] + grid[i][0];


        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++)
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
        }
        return sum[m-1][n-1]; 
    }    
}


/**
*	在以上的代码中重新声明了一个二维数组sum来记录每个节点处的路径和，时间复杂度为O(m*n)，空间复杂度为O(m*n)
*	但由于grid与sum位置上一一对应，所以还可以直接在给定的网格二维数组grid上进行操作，使空间复杂度降低为常数。代码如下：
**/
class Solution {
    public int minPathSum(int[][] grid) {
        
        if(grid == null)    return -1;
        
        int m = grid.length;
        int n = grid[0].length;
                 
        for(int j = 1; j < n; j++)
        	grid[0][j] += grid[0][j-1];
        
        for(int i =1; i < m; i++)
        	grid[i][0] += grid[i-1][0];

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        }
        return grid[m-1][n-1]; 
    }    
}