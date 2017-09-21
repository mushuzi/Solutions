/**
*LZS
*Solution18:4Sum
*	给定一个整型数组nums和一个整数target，寻找数组元素中满足a+b+c+d=target条件的四元组，要求不能出现重复四元组。
*
*思路：之前做过3Sum的题，大体思路相同，可以使用回溯法，但是效率很低，一般回溯法适用于不限定元素个数的情况。
*	这里使用四指针的方法解题。
*	首先我们设置以下四个指针：
*		1.指针i，取值范围从0 ~ nums.length - 3，递增方式更新;
*		2.指针j，取值范围从i + 1 ~ nums.length - 2，递增方式更新;
*		3.指针low，取值范围从j + 1 ~ high - 1，递增方式更新;
*		4.指针high，取值范围从nums.length - 1 ~ low + 1，以递减方式更新；
*
*	其次我们需要去除重复的组合，对于重复元素，跳过不再检查。由于有四个指针，所以需要进行四次去重的处理
*		1.对于指针i，if(i > 0 && nums[i] == nums[i - 1])	continue;
*		2.对于指针j，if(j > i - 1 && nums[j] == nums[j - 1])	continue;
*		3.对于指针low, while(low < high && nums[low] == nums[low + 1])	low++;
*		4.对于指针high，while(low < high && nums[high] == nums[high - 1])	high--;
*	注意在对low和high的去重处理中，low<high的条件限制使必须的，否则代码不被通过。
*
*	最后我们考虑几个需要预处理的特殊情况：
*		1.对于nums[i]，如果nums[i] + nums[ i + 1] + nums[i + 2] + nums[ i + 3] > target，说明从nums[i]开始，之后不再存在等于target的
*	组合，所以代码可以直接break。如果nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target，说明
*	nums[i]对于其之后所有的元素来说要想达到和等于target，都是相对较小的，所以应该continue跳出本次循环，进入到检查nums[i + 1]的循环。
*		2.对于nums[j]，如果nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target，同理应该break；
*	如果nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target，同理应该continue；
*
*算法复杂度为O(n^3)，空间复杂度为常数。
**/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0)    return list;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; i++){
            
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)  break;  //最小的一组数的和都大于target，说明不存在等于target的组合
            if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
                continue;   //说明本次选取的nums[i]元素有点小，应该跳出本次循环进行下一轮循环
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            for(int j = i + 1; j < nums.length - 2; j++){
                
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)  break;
                if(nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target)  continue;
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high){
                    int temp = nums[i] + nums[j] + nums[low] + nums[high];
                    if(temp == target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1])   low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }
                    else if(temp < target)  low++;
                    else    high--;
                }
            }
        }
        return list;
    }
}
