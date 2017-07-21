/**
*LZS
*Solution219:判断数组中是否存在两相等元素，且其坐标差不超过给定k
*
*思路：利用map，每次判断当前数组元素是否存在于map中，若不存在，则将（数组元素，对应索引）成对添加进去；
*	若存在，则求当前元素的索引与map中该元素作为键对应的值的差diff，若diff<=k，则返回TRUE，否则返回FALSE。
*与本题相似的还有217题，217题只是判断是否存在两个相同的元素，因此使用简单的先排序再比较就可以解决。
*	本题在217的基础上难度稍微有所加大。
**/

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length<2)    return false;
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int diff=i-map.get(nums[i]);
                if(diff<=k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}