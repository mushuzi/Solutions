/**
*LZS
*Solution530:给定一个具有非负值的二叉查找树BST，返回其任意两个节点之间差值的绝对值的最小值
*
*思路：考察二叉查找树的中序遍历
*	1.使用递归中序遍历二叉查找树，将其值存放在list中，则由右中左顺序遍历而得的list是从大到小排列的顺序
*	2.对list进行操作，寻找两个相邻值的差的最小值
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
    public int min=0;
    
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        
        List<Integer> list = helper(root);
        
        for(int i = 0; i < list.size()-1; i++){
            min = Math.min(min, list.get(i) - list.get(i+1));
        }
        return min;
    }
    
    public List<Integer> list = new ArrayList<>();
    
    public List<Integer> helper(TreeNode root){
        if(root == null)    return new ArrayList<>();
        else{
            helper(root.right);
            list.add(root.val);
            helper(root.left);
        }
        return list;
    }
}