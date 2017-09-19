/**
*LZS
*Solution120: Triangle
*以整型链表的链表的形式给定一个三角形，计算从第一行到最后一行的最小路径和，每一步只能移动到下一行的相邻元素。
*
*思路：使用动态规划的思想。
*	由分析可知，存在三种情况：
*		1.对于每一个子链表的第一个元素来说，它对应的路径和是其本身的值加上其右上角的值。
*		2.对于每一个子链表的最后一个元素来说，它对应的路径和是其本身的值加上其左上角的值。
*		3.对于每一个链表初第一个和最后一个元素之外的元素，它对应的路径是其本身的值加上其左上角值和右上角值中较小的那个值
*	因此需要记录下来每个每个位置对应的路径和！由于链表元素不能直接修改，所以需要额外申请O(n*n)的二维数组空间来存储路径和。
*	最后所求的从上到下的最小路径和一定是二维数组的最后行中的最小值。
**/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0) == null)   return 0;
        int res = Integer.MAX_VALUE;
        
        //定义一个二维数组来存储每一步的最小路径和。
        int[][] pathSum = new int[triangle.size()][triangle.size()];
        pathSum[0][0] = triangle.get(0).get(0);
        
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> temp = triangle.get(i);
            
            for(int j = 0; j < temp.size(); j++){
                if(j == 0)  pathSum[i][j] = pathSum[i - 1][j] + triangle.get(i).get(j);                    
                else if(j == temp.size() - 1)   pathSum[i][j] = pathSum[i - 1][j - 1] + triangle.get(i).get(j);
                else
                    pathSum[i][j] = Math.min(pathSum[i - 1][j], pathSum[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        
        //找到最后一个数组的最小值
        for(int num : pathSum[pathSum.length - 1])
            res = Math.min(res, num);          
                    
        return res;
    }
}