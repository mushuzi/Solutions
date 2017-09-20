/**
*LZS
*Solution54：Spiral Matrix
*	给定一个m*n的二维矩阵，按照顺时针旋转的方式将矩阵元素读入list链表中，并返回链表。
*
*思路：典型的顺时针旋转遍历二维数组的方法。设置四个指针up,bottom, left, right，然后按照右→下→左→上的方式写四个for语句遍历数组即可，
*	同时按照up++, right--, bottom--, left++的顺序更新四个指针
*
*注意：矩阵的行m和列n不一定相等，所以循环控制条件应该改变为while((m < n) ? (up <= bottom) : (left <= right))
*	同时在循环过程中随着指针的更新可能算法应该停止了，但是由于之后还有for循环没有执行，所以应加入break语句控制。
*	具体实现参见代码！
**/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();        
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)  return list;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int up = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        
        while((m < n) ? (up <= bottom) : (left <= right)){
            for(int j = left; j <= right; j++)
                list.add(matrix[up][j]);
            up++;
            if(up > bottom) break;
            
            for(int i = up; i <= bottom; i++)
                list.add(matrix[i][right]);
            right--;
            if(left > right)    break;
            
            for(int j = right; j >= left; j--)
                list.add(matrix[bottom][j]);
            bottom--;
            if(up > bottom) break;
            
            for(int i = bottom; i >= up; i--)
                list.add(matrix[i][left]);
            left++;
            if(left > right)    break;
        }
        return list;
    }
}