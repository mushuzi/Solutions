/**
*LZS
*Solution653:给定一个二叉查找树BST和一个整数k，判断树种是否存在两个节点使得其值相加等于k
*
*思路：二叉树的中序遍历+链表list的操作
*	1.按照左中右的顺序遍历BST，并将其值存在list中，则list中的元素是从小到大排列的，并且没有重复
*	2.处理list，问题转化为判断list中是否存在元素k-list.get[i]，即判定条件为list.contains(k-list.get(i)).
*
*注意：
*	1.由于list中没有重复元素，所以不能出现由于3=6-3而判定为TRUE的情况。
*		于是添加判断条件k-list.get(i) != k/2
*	2.在中序遍历二叉查找树的时候，由于是递归的方式将节点值添加到list中，所以list应该申明在遍历函数之外，
*		否则每次递归都会重新申明一个新的list而导致之前的结果被清零
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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> res = helper(root);
        System.out.println("res="+res);
        if(res.size() < 2)    return false;
        for(int i:res){
            if(res.contains(k-i) && (k-i) != k/2)   return true;
        }
        return false;
    }
	
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> helper(TreeNode root){  
        if(root == null)    return list;
        else{
            helper(root.left);
            list.add(root.val);
            helper(root.right);
        }
        return list;
    }
}
