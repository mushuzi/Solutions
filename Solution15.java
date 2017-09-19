/**
*LZS
*Solution15: 3Sum
*	给定一个整形数组，寻找数组中满足a+b+c=0的三元组，要求不能出现重复的组合
*
*思路1：回溯法
*	回溯法的解题已成套路，还是比较好解的，但是时间复杂度比较高，提交没有通过。
*
*思路2：三指针法。时间复杂度O(n*n)
*	首先确定一个数，然后在这个数之后的数中设置low指针和high指针，low指针从前往后，high指针从后往前，找到所有满足条件的组合
*	要求无重复的三元组。则参考之前几道回溯法解题的思路，首先将nums排序，然后每次遇到已经处理过的相同的元素时，就跳过，直到遇到下一个不同的
*	元素。三个指针都需要避免重复。
*具体实现参考代码
**/

//思路1：回溯法
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 3)    return list;
        
        Arrays.sort(nums);
        backTracking(list, new ArrayList<Integer>(), 0, 0, nums);
        
        return list;
    }
    
    private void backTracking(List<List<Integer>> list, List<Integer> temp, int start, int target, int[] nums){
        if(temp.size() == 3){
        	if(target == 0)  list.add(new ArrayList(temp));
            return;
        }
        
        if(target < 0)  return;
        
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;            
            temp.add(nums[i]);
            backTracking(list, temp, i + 1, target - nums[i], nums);
            temp.remove(temp.size() - 1);
        }
    }
}

//思路2：三指针法。时间复杂度O
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 3)    return list;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            //1.跳过i移动过程中的重复元素
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int low = i + 1, high = nums.length - 1;
            
                while(low < high){
                    int sum = nums[i] + nums[low] + nums[high];
                    if(sum == 0){
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) low++;  //2.跳过low移动过程中的重复元素
                        while(low <high && nums[high - 1] == nums[high])    high--; //3.跳过high移动过程中的重复元素
                        low++;
                        high--;
                    }
                    else if(sum < 0)    low++;
                    else    high--;
                }
            } 
        }            
        return list;
    }
}