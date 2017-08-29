/**
*LZS
*Solution637:求二叉树的每一层的平均值，并以double型list的形式返回。
*
*思路：本题考查二叉树的广度搜索算法，广度搜素相对于深度搜索来说较为麻烦，不能简单使用递归来实现，应该使用队列来实现
*	1.使用队列q来按层存放二叉树的节点，首先第一层root要先存到队列q中
*	2.循环控制条件是队列非空,每次处理的范围由n控制，即每一层的节点个数
*	3.每处理完一个节点，将其左右子树加入到队列中，并将处理完的节点从队列中删除
*	4.每进行完一个n控制的循环，将计算所得的各层平均值添加到list中去，最后返回。
**/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) return res;
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            double sum = 0.0;
            for(int i = 0;i < n;i++){
                TreeNode node = q.poll(); 
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null)  q.offer(node.right);
            }
            res.add(sum/n);            
        }
        return res;
    }
}