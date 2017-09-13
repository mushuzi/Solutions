/**
*LZS
*Solution59:给定一个整数n，使用1~n*n的数按照螺旋的方式（顺时针）生成一个n*n的矩阵。
*
*示例：
*	n=3时，生成矩阵为
*	[
*		[1,2,3],
*		[8,9,4],
*		[7,6,5]
*	]
*
*示例：
*	n=4时，生成矩阵为
*	[
*		[1, 2, 3,  4],
*		[16,15,14, 5],
*		[11,12,13, 6],
*		[10, 9, 8, 7]

*	]
*
*思路：使用螺旋遍历输出数组的方法，添入自增的数字
*	1.如何标识每次处理的行和列？
*		定义四个指针top, bottom, left, right.其中：
*			top初始化为0，意为数组第一行，每处理完一行，top+1指向下一个从上到下待处理的行；
*			bottom初始化为n-1，意为数组最后一行，每处理完一行，bottom-1指向下一个从下到上待处理的行；
*			left初始化为0，意为数组第一列，每处理完一列，left+1指向下一个从左到右待处理的列；
*			right初始化为n-1，意为数组的最后一列，每处理完一列，right-1指向下一个从右往左待处理的列；
*
*	2.如何保证在数字自增的前提下填入对应的位置？
*		观察可知每一轮填入数字都是右->下->左->上的顺序，因此需要定义四个for循环分别按顺序将数字填入对应的
*	left~right、top~bottom、right~left、bottom~top的位置上，并且每执行完一个for循环，分别对应top+1、
*	bottom-1、left+1、right-1,使指针指向下一个待处理的行或者列。
*
*	3.如何保证所有的行和列都被处理完了？
*		将四个for循环放进while循环中，循环控制条件是left <= right && top <= bottom
*
*	至此，就可以完成矩阵的生成了！


class Solution {
    public int[][] generateMatrix(int n) {
         
        int[][] res = new int[n][n];
        
        if(n == 0)  return res;
        
        int top = 0, bottom = n-1, right = n-1, left = 0;
        int index = 1;
        int i = 0;
        
        while(top <= bottom && left <= right){
            for(i = left; i <= right; i++)
                res[left][i] = index++;
            top++;
            
            for(i = top; i <= bottom; i++)
                res[i][right] = index++;
            right--;
            
            for(i = right; i >= left; i--)
                res[bottom][i] = index++;
            bottom--;
            
            for(i = bottom; i >= top; i--)
                res[i][left] = index++;
            left++;
        }
        return res;
    }
}