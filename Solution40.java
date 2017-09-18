/**
*LZS
*Solution40:Combination Sum II
*	给定一个整型数组candidates和一个整数target，寻找所有candidates元素相加等于target的组合，每个元素只允许使用一次，并且返回的组合中
*	不允许出现重复！
*
*思路：这是典型的需要用回溯法解的题目，有几个需要注意的地方
*	1.怎么避免出现重复的组合？
*		需要两步：首先将candidates排序，保证数组有序；其次在回溯时跳过满足条件i > start && nums[i] == nums[i - 1]的元素，具体分析参考
*	LeetCode 90. Subsets II的解释
*	
*	2.什么情况下，一次回溯结束？
*		分为两种情况：1.找到满足条件的组合，即当前组合元素的和等于target时，return；2.当前组合的已经超过target时，没有再进行下去的必要
*	了，此时需要return。注意如果不进行第二个条件的限制，算法的性能将会急剧下降，因为它会遍历所有可能的组合。
*
*	3.特殊情况的处理：
*		两个特殊情况：1.给定数组为空或者数组长度为0时，直接返回空链表；2.排序后数组的第一个元素就大于target的情况下，不可能存在满足条件
*	组合，因此返回空链表
*
*注意：我在代码中还多进行了一步，找到给定数组排序后第一个大于target的位置，然后将这个位置作为参数传入回溯方法中，目的是为了减少不必要的
*	步骤，但细想实际上并没有必要，因为这个情况已经在回溯方法中用“和超出target则return”的方式包含了。
*
**/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        
        Arrays.sort(candidates);
        if(candidates == null || candidates.length == 0 || candidates[0] > target)    return list;  
        
        int flag = candidates.length; //用于标志第一个比target大的数，如果都比target小，则flag等于数组长度
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] > target){
                flag = i;
                break;
            }
        }
        
        backTracking(list, new ArrayList<Integer>(), 0, target, candidates, flag);
       
        return list;
    }
    
    private void backTracking(List<List<Integer>> list, List<Integer> temp, int start, int target, int[] nums, int flag){
        if(target == 0){
            list.add(new ArrayList(temp));
            return;
        }
        if(target < 0)  return; //必须要有的一步！！！因为会出现target<0的情况，但是这种情况一出现就说明没有进行下去的必要的，因此必须返回。
        
        for(int i = start; i < flag; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backTracking(list, temp, i + 1, target - nums[i], nums, flag);
            temp.remove(temp.size() - 1);
        }
    }
}