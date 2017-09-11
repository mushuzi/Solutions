/**
*LZS
*Solution62:给定m*n个方格组成的网格，位于（0,0）的格子的机器人需要到（m-1,n-1）位置的目的地去，机器人只能
*	向右或者向下每次移动一格，问机器人到达目的地有多少种不同的路径
*
*思路：
*	首先明确几个情况：
*	1.当m=1时（只有一排网格时），由于机器人只能向右或向上，所以不管n多大，到达目的地只有一条路径（一路向右）
*	2.当n=1时（只有一列网格时），由于机器人只能向右或向上，所以不管m多大，到达目的地只有一条路径（一路向下）
*	3.当m>1 && n>1时，对于第一排和第一列以外的格子（i,j）来说，其对应的路径数为（i-1,j）和(i,j-1)对应的路径数之和
*
*由以上分析，很容易想到使用迭代的方法，然而超时！
*转而使用动态规划的思想！！！
**/


//迭代法求解，但是超时
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1)  return 1;
        if(n == 1)  return 1;
        return uniquePaths(m - 1, n)+uniquePaths(m, n - 1);
    }
}


//动态规划
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] step = new int[m][n];
        
        //因为不能向上和向左走，所以矩阵的第一行和第一列的所有格子对应的step值都为1
        for(int i = 0; i < m; i++)
            step[i][0] = 1;
        
        for(int j = 0; j < n; j++)
            step[0][j] =1;
        
        //对于第一行和第一列以外的格子，每个格子对应的步数是其左边格子和上边格子对应步数的和
        for(int i =1; i< m; i++){
            for(int j =1; j < n; j++)
                step[i][j] = step[i-1][j] + step[i][j-1];
        }
        return step[m-1][n-1];  //finish需要经过的步数
    }
}