/**
*LZS
*Solution563:给定一个二叉树，求二叉树的左子树节点的值的和与右子树上节点的值的和之差的绝对值
*
*思路：二叉树的迭代遍历
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int result=0;
    
    public int findTilt(TreeNode root) {
        helper(root);
        return result;
    }
    
    public int helper(TreeNode root){
        if(root==null)  return 0;
        
        int left=helper(root.left);
        int right=helper(root.right);
        
        result+=Math.abs(left-right);
        return left+right+root.val;
    }
}