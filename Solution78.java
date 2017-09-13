/**
*LZS
*Solution78:给定一个整形数组，求这个数组的所有子集，并以链表的链表形式返回
*
*思路：这是典型的使用回溯法解决的题目！
*	定义专门的回溯方法，输入参数为：
*		1.链表的链表list，用来存储所有子集
*		2.链表temp，用来表示nums的每一个子集
*		3.开始指针start，用来标识每次回溯方法开始的位置（之前添加过的元素不能再重复添加，所以这个参数是必要的）
*		4.数组nums，每次需要将nums中的元素按照start指定的规则添加进temp。
**/


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, new ArrayList<Integer>(), 0, nums);
        
        return list;
    }
    
    private void backTracking(List<List<Integer>> list, List<Integer> temp, int start, int[] nums){
        list.add(new ArrayList(temp));
        
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backTracking(list, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        } 
    }
}
