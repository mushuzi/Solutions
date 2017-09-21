/**
*LZS
*Solution229:MAjority Element II
*	给定一个长度为n的数组nums，找到数组中所有出现次数大于n/3的元素，存放在list中并返回，要求时间复杂度为O(n)，空间复杂度为常数
*
*思路：
*	1.推论可知，数组中最多存在两个出现次数大于n/3的元素，所以当list.size()==2时，说明不可能再有这样的众数了，直接返回list
*	2.遍历数组，遍历范围为0 ~ nums.length - nums.length/3;对于nums[i]，判断nums[i] == nums[i + nums.length/3]是否满足，如果满足
*	则将nums[i]添加进list，同时i直接移动到i+nums.length/3+1的位置上，继续判断。
*	3.为了避免[1,1,1,1,1,1]这种情况下，1元素重复加入到list中，还应该有!list.contains(nums[i])条件的限制
**/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0)    return list;
        
        int limit = nums.length / 3;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - limit;){
            if(list.size() == 2)    
                return list;  //数组中最多有两个出现次数大于n/3的元素，因此一旦list.size()==2时，说明已经全部找到，后面的元素不需要再看
            if(!list.contains(nums[i]) && nums[i] == nums[i + limit]){
                list.add(nums[i]);
                i += limit;
            }
            i++;
        }
        return list;
    }
}