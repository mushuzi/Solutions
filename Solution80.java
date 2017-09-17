/**
*LZS
*solution80：从排序数组中移除重复元素，允许有不超过两个的重复元素存在。
*
*思路1：我自己想的是用map实现，先统计每个元素出现的次数，再根据map对数组进行更新。但是这样做太太太太太慢了！！！
*
*思路2：双指针法
*	1.定义一个指针j, 表示正在检查的nums的位置
*	2.定义一个指针res,表示更新完成的nums的位置，每次更新过后res++；由于重复元素的存在，res必然是小于等于j的，且一旦检查到了重复元素
*		并且进行过删除之后，j和res之间至少有2的差值
*	3.当j<2时，还没有检测到重复元素，nums[res++] = nums[j];
*	 或者当nums[j] > nums[i-2]的时候，之前一定有了重复元素，且又开始检测到了一个新的元素，nums[res++] = nums[j]；
*	4.进行上述操作，直到检查完所有的nums元素，即j<nums.length，则nums已经全部被更新过了，返回此时的res。
**/

//思路1 
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        int len = 0;
        int[] temp = new int[map.size()];
        
        int index = 0;
        for(int i : map.keySet())
            temp[index++] = i;
        
        Arrays.sort(temp);
        for(int k : temp)
        {
            res += (map.get(k) >= 2) ? 2 : map.get(k);
            for(int j = 0; j < ((map.get(k) >= 2) ? 2 : map.get(k)); j++)
                nums[len++] = k;
        }
                
        return res;        
    }
}

//思路2 
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int res = 0;
        for(int j = 0; j < nums.length; j++){
            if(j < 2 || nums[j] > nums[res - 2])
                nums[res++] = nums[j];
        }
        return res;
    }
}