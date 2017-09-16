/**
*LZS
*Solution162:寻找峰值元素。
*	给定一个数组nums，满足nums[i] != nums[i+1],寻找数组中的峰值元素的索引，存在多个峰值元素时，返回其中任何一个的索引即可。
*
*思路1：直接法，遍历数组，找到满足nums[i] > nums[i+1] && nums[i+1] > nums[i+2]条件的i+1即可
*
*思路2：二分法
*	注意：由于要求返回多个峰值中任何一个即可，所以不需要寻找全局的峰值，因此只需要找到一个峰值就可以了。所以思路1里面我写的
*	代码是寻找全局峰值的，虽然也符合条件，但不免画蛇添足，还可以简化。
*	
*	使用二分法，low从0开始，high从nums.length-1开始，每次查找一个中间mid，将mid与mid+1上的元素比较，假如nums[mid] < nums[mid+1]，
*	则说明在mid右边肯定存在一个上升序列，故而使得low=mid+1继续在右半边查找，否则如果nums[mid] > nums[mid+1]，说明在mid+1左边肯定
*	存在一个上升序列，所以使得high=mid继续在左半边查找。最后返回low或者high都行。
**/

//思路1：直接法，遍历数组，找到满足nums
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)    return -1;
        if(nums.length == 1)    return 0;
        
        int curPeak = Integer.MIN_VALUE;
        int curIndex = -1;
        
        if(nums[0] > nums[1]){
            curPeak = nums[0];
            curIndex = 0;
        }
        
        int n = nums.length;
        for(int i = 0; i < n-2; i++){
            if(nums[i] < nums[i + 1] && nums[i + 1] > nums[i + 2]){
                curPeak = Math.max(curPeak, nums[i + 1]);
                curIndex = (curPeak == nums[i+1]) ? (i+1) : curIndex;
            }
        }
        
        if(nums[n -1] > nums[n - 2] && nums[n - 1] > curPeak){
            curPeak = nums[n - 1];
            curIndex = n - 1;
        }
        return curIndex;
    }
}

//思路2：二分法
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)    return -1;
        if(nums.length == 1)    return 0;
        int low = 0, high = nums.length-1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[mid + 1])   high = mid;
            else    low = mid + 1;
        }
        return low;      
    }
}
