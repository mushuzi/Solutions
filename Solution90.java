/**
*LZS
*Solution90:Subsets II
*	给定一个可能会存在重复元素的整形数组nums，返回所有可能的子集，但是要求不能返回重复的子集
*
*思路：与Subsets I类似，采用回溯法实现。这里需要注意的一点是怎么避免重复子集，对应到代码中就是如何判断list中是否存在与temp
*	具有相同种类和出现次数的子链表list1。比如temp=[1,2,1]; list中包含一个子list1=[1,1,2]，则temp就是一个重复的子集，不能加入
*
*为了避免上述情况的发生，首先想到先将nums排序，则之后由回溯法产生的子集都是从小到大排列的，不会存在上述例子中temp=[1,2,1]的情况。直接用下列语句：
*	直接用下列语句：if(!list.contains(temp)) list.add(new ArrayList(temp));		避免重复即可。
*	但是！！！这样还是中规中矩，不能减少操作的步骤，故而效率比较低，所以需要想办法改进！！！
*
*注意到这样一个事实：如果当前处理的元素nums[i]与前一个处理过的元素nums[i-1]相同，则说明两点：
*	1.nums[i]与其之后位置的元素所能构成的nums的子集都已经被nums[i-1]构成的子集包括的，即跳过nums[i]不会漏掉某些子集
*	2.正因为有1中的解释，利用nums[i]所组成的所有子集都是重复的，不能加进list中，所以可以跳过nums[i]不处理。
*	以上想法的实现需要用i>start的条件来约束，因为第一次进行回溯时是不需要判断是否存在重复的（要避免第一次回溯时i=0，i-1会越界的情况）
*
*有了以上分析，代码get！
*另外，总结一点：类似的题目中对数组的预先排序是非常重要的！！！（其实只要不涉及到数组下标的问题中，都应该优先考虑到给数组排序）
**/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0)    return new ArrayList();        
        List<List<Integer>> list = new ArrayList<>();
        
        Arrays.sort(nums);        
        backTracking(list, new ArrayList<>(), 0, nums);
        
        return list;
    }
    
    private void backTracking(List<List<Integer>> list, List<Integer> temp, int start, int[] nums){
        // if(!list.contains(temp)) list.add(new ArrayList(temp)); //由于每一步的list.contains()很耗费时间，所以要想办法改进
        
        list.add(new ArrayList(temp));
        
        for(int i = start; i < nums.length; i++){
            
            //如果当前处理的元素nums[i]与前一个处理过的元素nums[i-1]相同，则说明两点：
            //  1.nums[i]与其之后位置的元素所能构成的nums的子集都已经被nums[i-1]构成的子集包括的，即跳过nums[i]不会漏掉某些子集
            //  2.正因为有1中的解释，利用nums[i]所组成的所有子集都是重复的，不能加进list中，所以可以跳过nums[i]不处理。
            //当然也需要用i>start的条件来约束，第一次进行回溯时是不需要判断是否存在重复的（并且避免了第一次回溯时i=0，i-1会越界的情况）
            if(i > start && nums[i] == nums[i - 1]) continue;   
            temp.add(nums[i]);
            backTracking(list, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}