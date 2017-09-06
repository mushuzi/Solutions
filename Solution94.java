/**
*LZS
*Solution94:二叉树的中序遍历
*
*思路1：采用递归的方式实现。
*	1.递归终止条件是当前节点是否为空；
*	2.首先递归调用遍历左子树，
*	3.然后访问当前节点，
*	4.最后递归调用右子树
*
*思路2：采用迭代的方式实现。
*	1.从根节点开始找二叉树的最左节点，将走过的节点保存在一个栈中
*	2.找到最左节点后访问；
*	3.对于每个节点来说，它都是以自己为根的子树的根节点，访问之后就可以转到右儿子上了
**/

//思路1 
//使用递归的方法
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return list;        
    }
    
    public List<Integer> helper(TreeNode root){
        if(root == null)     return list;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
        
        return list;
    }
}

//思路2 
//使用迭代的方法
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        
        if(root == null)    return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while(!stack.empty() || cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}