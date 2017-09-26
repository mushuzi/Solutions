/**
*LZS
*Solution81：在有重复的旋转排序数组nums中的查找指定元素target的位置。
*
*首先思考：重复带来了什么不便：
*	重复使得单调递增区间的判断具有不确定性。例如：nums=[1,3,1,1,1],则low=0,high=4,mid=2,nums[low]=nums[mid],不能确定单调性
*
*思路1：人为去重，然后按照无重复的旋转排序数组查找的方法进行
*
*思路2：改进无重复排序数组查找的方法。当nums[low] == nums[mid]的，无法判断low到mid是否是递增区间，因此low++，使得low指针后移
*	，以此来去掉重复带来的不确定性。
**/

//思路1：人为去重，然后按照无重复的旋转排序数组查找的方法进行
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return false;
        int low = 0, high = nums.length - 1;
        while(low < high){
            //从前往后和从后往前，先去重
            while(low < high && nums[low] == nums[low + 1])    low++;
            while(high > low && nums[high] == nums[high - 1]) high--;
            int mid = (low + high) / 2;
            if(nums[mid] == target) return true;
            if(low == high)	return (nums[low] == target) ? true : false;    //[1,1,1]的特殊情况，去重后会出现low==high的情况，需要先判断一下
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid])
                    high = mid- 1;
                else
                    low = mid + 1;
            }
            else{
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return (nums[low] == target) ? true : false;
    }
}

//思路2：改进无重复排序数组查找的方法。
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return false;
        int low = 0, high = nums.length - 1;
        while(low < high){
        
            int mid = (low + high) / 2;
            if(nums[mid] == target) return true;
        
            if(nums[low] < nums[mid]){
                if(nums[low] <= target && target < nums[mid])
                    high = mid- 1;
                else
                    low = mid + 1;
            }
            else if(nums[low] > nums[mid]){
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else    //如果nums[low] == nums[high]，则不能判断是否是递增区间，low向后移动
                low++;
        }
        return (nums[low] == target) ? true : false;
    }
}
