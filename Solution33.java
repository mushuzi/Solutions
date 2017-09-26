/**
*LZS
*Solution33：在旋转排序树种查找给定元素的位置
*
*示例：input：nums = [4,5,6,7,0,1,2] target = 6;	output: 2
*
*思路：
*	1.首先可以想到本题肯定可以用遍历一遍数组nums的方式找到target的位置，时间复杂度为O(n)，但是这么简单肯定不是最好的解决
*	办法，联想到之前排序数组中查找指定元素，使用的是二分法，算法时间复杂度为O(logn)，本题中是旋转排序数组，特点是有两个单
*	调递增的子区间，并且前一个子区间的最小值大于后一个子区间的最大值，在每一个子区间内部是排序数组，因此考虑使用二分法！
*
*	2.使用二分法的前提是在一个单调的区间里，因此必须首先判断当前的区间是否单调
*
*	3.二分法的解题套路先用上！low从0开始向后移动，high从nums.length - 1开始向前移动，mid = (low + high) / 2;
*
*	4.如何更新low和high是需要考虑的问题。
*		1）首先，如果遇到nums[mid] == target的情况，说明已经找到了，直接返回mid即可，程序结束。
*		2）如果nums[low] <= nums[mid]，说明[low, mid]是一个单调区间：如果nums[low] <= target < nums[mid]，说明target在
*			[low, mid)这个单调区间里，所以更新high = mid - 1；否则，说明target在(mid, high]的区间里，更新low = mid + 1
*		3)如果nums[low] > nums[mid],说明(mid, high]是一个单调区间：如果nums[mid] < target <= nums[high]，说明target在
*			(mid, high]这个单调区间里，所以更新low = mid + 1；否则，说明target在[low, mid)的区间里，更新high = mid - 1；
*		
*	5.二分法结束的条件：
*		1）如果遇到nums[mid] == target的情况，说明已经找到了，直接返回mid即可，程序结束。
*		2）如果一直不能遇到1）所示的情况，则每次二分需要满足low < high的条件，即算法在low == high时结束。
*
*	6.也有可能一直找不到满足nums[mid] == target的情况，最后算法在low == high时结束，最后需要再判断nums[low] == target是否成立，如果成立
*		则返回low，否则说明不存在与target相等的元素，返回-1.
**/

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return -1;
        int low = 0, high = nums.length - 1;
        
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else    low = mid + 1;
            }
            else{
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return nums[low] == target ? low : -1;
    }
}