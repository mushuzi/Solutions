/**
*LZS
*Solution39：给定一个整型数组candidates和一个整数target，找出candidates中所有满足和为target的
*	子集（candidates中的数字可以重用）。
*
*示例：input：candidates = [2,3,6,7]	target = 7;
*	   output: [ [7], [2,2,3] ]
*
*思路：采用回溯法，具体套路和以往做过的回溯法一样，只是由于candidates中数字可以重用，所以每一轮回溯法的开始
*	位置start不需要再加一！
**/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return res;
        
        backTracking(res, new ArrayList<Integer>(), candidates, target, 0);
        
        return res;
    }
    
    private void backTracking(List<List<Integer>> list, List<Integer> temp, int[] nums, int target, int start){
        
        if(target == 0){
            list.add(new ArrayList(temp));
            return;
        }
        else if(target < 0) return;
        
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backTracking(list, temp, nums, target - nums[i], i);	//start不需要加一，所以直接传入每一轮的开始位置i即可
            temp.remove(temp.size() - 1);
        }
    }
}