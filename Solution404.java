/**
*LZS
*Solution404：给定一个二叉树，求二叉树所有左叶子节点的值的总和。
*
*思路：考察二叉树的迭代遍历
*	1.如果当前节点root为空，则返回0；
*	2.如果当前节点root的左子树非空：
*		1）如果左节点的左右子树都为空，则说明左节点就是叶子节点，ans加上root.left.val
*		2)如果左节点不是叶子节点，则以左节点为输入参数，进行迭代，ans加上迭代值
*	3.以右节点为参数进行迭代，ans加上迭代值
*	4.最后返回ans即可。
*
*注意：此处不需要判断右节点是否为空，也不需要判断右节点是否是叶子节点
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
    
    public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int ans = 0;
    if(root.left != null) {
        if(root.left.left == null && root.left.right == null) ans += root.left.val;
        else ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);
    
    return ans;
    }
}
