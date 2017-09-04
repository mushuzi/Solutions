/**
*LZS
*Solution108:给定一个按照升序排列的数组nums，将其转化成高度平衡的二叉查找树
*
*思路：考察二叉查找树的特点：左子树<根<右子树
*	1.先来考虑根节点是由nums的哪个元素组成：是由nums最中间的那个元素组成，即nums[(0+nums.length-1)/2]
*	2.nums中索引为0~(0+nums.length-1)/的元素为根节点的左子树，索引为(0+nums.length-1)/2+1~nums.length-1的元素为根节点的右子树
*	3.再分别将根节点的左节点和右节点当做根，由此进行递归，则能构成二叉查找树
*
*/

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null)  return null;
        TreeNode root = helper(nums, 0, nums.length-1);
        return root;
        
    }
    
    public TreeNode helper(int[] nums, int low, int high){
        if(nums==null || low>high)  return null;
        
        int mid=(low+high)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid-1);
        root.right = helper(nums, mid+1, high);
        
        return root;
    }
}