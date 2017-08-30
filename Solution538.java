/**
*LZS
*Solution538:将二叉查找树转化成更大的数，转换规则是节点对应的值加上所有比其的的值，以构成新的节点值
*
*思路：由于是二叉查找树BST，很容易可以得到从大到小排列的节点值序列（采用中序遍历：右子树-》根节点-》左子树）
*	将每个节点的值累加到一个sum变量上，并用sum变量更新节点的值
*
*注意：这里中序遍历我们采用的是右中左的顺序，因为越小的节点值需要加上越多的比它大的节点值，所以值小的节点的访问依赖于值大的
*	的节点的访问，所以先访问大值的节点，即从右到左访问。
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
    
	public int sum=0;
    
    public TreeNode convertBST(TreeNode root) {
        if(root == null)    return null;
        addSum(root);
        return root;
    }
    
    public void addSum(TreeNode root){
        if(root != null){
            addSum(root.right);	//先访问根节点的右子树
            sum += root.val;	
            root.val = sum;	//根节点的新值为根节点的旧值加上其右子树的值
            addSum(root.left);	//最后访问左子树，左节点的新值等于其旧值加上根节点的值和根节点右子树的值
        }
    }
}
