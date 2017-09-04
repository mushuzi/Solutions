/**
*LZS
*Solution671:给定一个二叉树，寻找其第二小节点值
*
*思路：遍历二叉树，将其节点值添加进list中，然后排序找到第二小的节点值
*	1.递归访问二叉树的每一个节点，并将无重复的节点值添加进list中
*	2.由于list排序不好实现，于是将list中的元素复制到一个数组temp中，这样做可能效率不是很高，但是很好理解实现
*	3.利用Arrays.sort(temp)对所有节点值进行从小到大的排序
*	4.返回第二小的节点值
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

    public int findSecondMinimumValue(TreeNode root) {
        helper(root);

        System.out.println(list);
        if(list.size()<2)   return -1;
        else{
            int[] temp=new int[list.size()];
            for(int i=0;i<list.size();i++)
                temp[i]=list.get(i);
            Arrays.sort(temp);
            return temp[1];
        }
    }
    
    List<Integer> list=new ArrayList<>();
    
    public List<Integer> helper(TreeNode root){
        if(root == null)    return list;
        helper(root.left);
        if(!list.contains(root.val))
            list.add(root.val);
        helper(root.right);
        return list;
    }
}