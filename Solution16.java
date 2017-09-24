/**
*LZS
*Solution16:3Sum Closest
*	给定一个包含n个整数的数组nums，和一个整数target，寻找nums中的三个整数，使其三个整数的和与target最接近，返回这三个整数的和。
*
*思路：三指针法
*	1.考虑怎么让三个整数的和随着指针的变化呈现一致的增减趋势，这样有利于更新指针？
*		将nums从小到大排序，则指针向后移动，和变大；指针向前移动，和变小
*	2.三个指针如何排列，之间的关系如何？
*		三个指针应能保证遍历到所有的三个数的组合。所以:
*			i的取值范围为0 ~ nums.length - 2;
*			low的取值范围为i + 1 ~ high - 1;
*			high的取值范围为low + 1 ~ nums.length - 1;
*	3.什么情况下更新指针？
*		针对当前的指针i,low,high，对应三个元素的和为sum =nums[i] + nums[low] + nums[high]
*		当sum<target时，low++,当sum > target时，high--。
*	4.怎么能保留下来最近的那组元素的和。
*		每一次，计算sum与target的差的绝对值，与上一组的差的绝对值比较，保留较小的和。
*
*时间复杂度为O(n*n),空间复杂度为常数。
**/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return Integer.MIN_VALUE;
        int result = nums[0] + nums[1] + nums[nums.length -1];
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            int low = i + 1, high = nums.length - 1;
            
            while(high > low){
                int sum = nums[i] + nums[low] + nums[high];
                
                if(sum == target)   return target;
                else if(sum < target) low++;
                else  high--;
                
                if(Math.abs(sum -target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }
}