/**
*LZS
*Solution543:给定一个二叉树，返回二叉树的半径（二叉树任意两个节点之间的最长路径）
*
*思路：考察二叉树的深度遍历
*	1.声明一个类变量max，用来存放每次递归中产生的相比于上一次递归产生的较大的那个半径值
*	2.采用深度遍历求出二叉树的深度：二叉树深度=左子树深度+右子树深度+1；
*	3.调用求深度函数，得到最大的半径值max并返回
*/

class Solution {
    int max=0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    
    //求二叉树的深度：左子树的深度+右子树的深度+1
    public int depth(TreeNode root){
        if(root == null)    return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        max=Math.max(max, left+right);
        
        return Math.max(left , right) + 1;
    }
}