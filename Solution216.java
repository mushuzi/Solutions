/**
*LZS
*Solution216:给定两个整数n和k，寻找所有满足k个不同整数相加等于n的组合，并且每个组合中的所有数必须在1~9之间
*
*示例：
*input: k=3, n=7		output:[[1,2,4]]
*input: k=3, n=9		output:[[1,2,6], [1,3,5], [2,3,4]]
*
*思路：使用回溯法
*	1.首先观察到本题需要返回链表形式的链表，因此定义res为链表形式的链表，每次产生可行组合时添加进入res；定义comb为整型链表，表示当前正在被判断的组合。
*		则“comb被添加进res”需要满足条件：comb的长度==给定的k值 && comb中元素的和==给定的n值
*	2.采用回溯法，需要定义回溯函数helper，输入参数为res、comb、k、n、start，start表示每次输入时数字的开始点。因为comb中的数字不能重复，所以1加入comb以后，
*		就不能再从1开始进行下一轮尝试了，所以必须对上一轮开始添加的位置进行标记。
*	3.最后，当comb中当前组合不满足条件时，需要退回来加入别的元素再尝试，因此需要使用comb.remove(comb.size()-1)删除comb的最后一个元素。
*		寻找成功，最后一个元素要退位，尝试其他可能可能的组合；寻找不到，当前组合不可行，也要回退，移除最后一个元素
*	4.按照上述方法进行回溯，最终可以找到所有可能的组合。
**/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), k, 1, n);
        return res;
        
    }
    
    private void helper(List<List<Integer>> list, List<Integer> comb, int k, int start, int n){
        if(comb.size() == k && n == 0){
            list.add(new ArrayList(comb));
            return;
        }
        
        for(int i = start; i <= 9; i++){
            comb.add(i);
            helper(list, comb, k, i+1, n - i);
            comb.remove(comb.size()-1);
        }
    }
}
