/**
*LZS
*Solution79：word search
*	给定一个二维数组board和一个String类型的word，判断board中的元素按照水平或竖直的方式能否组合成word
*
*思路：使用深度搜索DFS来解决此问题，采用回溯法，每次对处理过的元素进行标记，处理过的元素在深度搜索时不再进行处理，深度搜索结束后，
*	去除元素的标记完成回溯。
*
*1.确定dfs回溯法的输入参数：
*	1）char[][] board
*	2）int i, int j 用来标记每次开始回溯的位置
*	3）String word
*	4）wordIndex 用来标记深度搜索进行到了word的哪一个字母
*	5）boolean[][] visit 用来标记DFS进行过程中已经处理过的元素，处理过的元素不再处理，每次回溯的时候去除标记
*
*2.确定DFS进行的过程，即在dfs方法中，输入参数如何变化？
*	1.每深入一层，意味着word中又多了一个确定存在的元素，因此，wordIndex需要加1
*	2.针对当前的board[i][j]，深入到下一层时，board中只能在位置（i,j）的上下和左右移动，因此对应(i+1,j),(i-1,j),(i,j-1),(i,j+1)四个，
*		并且这四种方式是在同一深度上的四种可能性，对应着同一个word.chatAt(wordIndex).
*	3.当进行完一次深度搜索时，（i,j）位置上对应的标记要回溯，应该去掉，因为题目中并没有规定字母不能重复使用。
**/

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)  return false;
        
        int m = board.length, n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                if(dfs(board, i, j, word, 0, visit))    return true;
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int wordIndex, boolean[][] visit){
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        
        if(wordIndex >= len)    return true;    //说明已经检查到了所有的word中的字母，返回true
        if(i < 0 || i >= m || j < 0 || j >= n)  return false;   //数组下标越界
        if(word.charAt(wordIndex) != board[i][j])   return false;   //当前访问到的节点值不等于当前对照的Word的字母
        if(visit[i][j] == true) return false;   //访问过的节点不再访问；
       
        //开始递归、回溯
        visit[i][j] = true; 
        if(dfs(board, i - 1, j, word, wordIndex + 1, visit))    return true;
        if(dfs(board, i + 1, j, word, wordIndex + 1, visit))    return true;
        if(dfs(board, i, j - 1, word, wordIndex + 1, visit))    return true;
        if(dfs(board, i, j + 1, word, wordIndex + 1, visit))    return true;
        visit[i][j] = false;    //回溯
        
        return false;
    }
}

//上述代码可以做以下整理，并可以在board本身位置上进行修改，将空间复杂度降低为常数
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)  return false;
        
        int m = board.length, n = board[0].length;
        //boolean[][] visit = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                if(dfs(board, i, j, word, 0))    return true;
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int wordIndex){
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        
        if(wordIndex >= len)    return true;    //说明已经检查到了所有的word中的字母，返回true
        if(i < 0 || i >= m || j < 0 || j >= n || word.charAt(wordIndex) != board[i][j] || board[i][j] == '#')  
            return false;   //1.数组下标越界  2.当前访问到的节点值不等于当前对照的Word的字母  3.访问过的节点不再访问
       
        //开始递归、回溯
        char temp = board[i][j];
        board[i][j] = '#';
        if(dfs(board, i - 1, j, word, wordIndex + 1) || dfs(board, i + 1, j, word, wordIndex + 1)
          || dfs(board, i, j - 1, word, wordIndex + 1) || dfs(board, i, j + 1, word, wordIndex + 1))
            return true;
        board[i][j] = temp;    //回溯
        
        return false;
    }
}