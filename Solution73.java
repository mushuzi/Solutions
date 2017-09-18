/**
*LZS
*Solution73:给定一个m*n的二维矩阵，如果某一个元素为0，则将该元素所在的行和列都置零。要求就在给定数组的基础上进行，不能另外开辟空间
*
*思路1：如果不要求空间复杂度的话，我首先想到的是遍历数组，将数组元素为0的行和列分别存在集合rowSet和colSet中，然后再更新数组。
*	这样做比较容易理解，但是空间复杂度是O(m+n)
*
*思路2：本题要求不能开辟新的地址空间，于是想到利用数组本身来记录需要被更新的行和列，数组第一行和第一列作为记录空间已经足够。
*	由于要用到第一行和第一列，所以必须先记录一下第一行和第一列的状态，否则第一行第一列的状态会被覆盖掉。所以具体步骤如下：
*	1.检查矩阵第一行和第一列是否存在0，如果存在，对应的标志置位true
*	2.检查第一行和第一列之外其余的行和列，如果存在matrix[i][j]==0，则在对应的第一行matrix[0][j]和第一列matrix[i][0]做标记
*	3.根据第一行和第一列的标记，更新除了第一行和第一列之外的所有行和列
*	4.对第一行和第一列剩下的值进行更新。
*
**/

//思路1 
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)  return;
        
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){                
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        for(int i : rowSet){
            for(int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = 0;
        }
        
        for(int j : colSet){
            for(int i = 0; i < matrix.length; i++)
                matrix[i][j] = 0;
        }
    }
}

//思路2 
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)  return;
        
        int m = matrix.length, n = matrix[0].length;
        boolean hasZeroFirstRow = false, hasZeroFirstCol =false;
        
        //1.检查矩阵第一行是否存在0
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                hasZeroFirstRow = true;
                break;
            }
        }
        
        //2.检查矩阵第二列是否存在0
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                hasZeroFirstCol = true;
                break;
            }
        }
        
        //3.检查其余的行和列，如果存在0，则在对应的第一行和第一列进行标记
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //4.根据第一行和第一列的标记先更新除了第一行第一列之外的值
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        //5.对第一行第一列剩下的值进行更新
        if(hasZeroFirstRow == true){
            for(int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
        
        if(hasZeroFirstCol == true){
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
        
}