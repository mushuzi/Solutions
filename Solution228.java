/**
*LZS
*Solution228:Summary  Ranges
*
*思路：代码注释中写的很清楚，具体不再赘述
*
*总结：
*	1.遇到这种题目，首先将子序列用合适的要素抽象出来，然后剩下的事情就是更新这些要素来构造子序列了
*	2.边界条件一定要注意明确
*
**/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0)    return res; //特殊情况1：数组为空或数组长度为0时，返回空链表
        
        if(nums.length == 1)    //特殊情况2：数组长度为1时，直接将唯一的元素加入链表，并返回
        {
            res.add(nums[0] + "");
            return res;
        }   
        
        /**
        *   1.每一个连续的子序列的开始索引记为startIndex，
        *   2.nums中每个元素nums[i]与索引i的差值记为diff，则属于同一个子序列的元素具有相同的diff
        *   3.len表示从startIndex开始，需要经过len个位置才能到达这个子序列的最后一个位置
        *   有了startIndex、diff和len三个元素，子序列可以被唯一确定，即nums[startIndex] +"->" + nums[startIndex + len]
        **/
        int startIndex = 0, diff = nums[0], len = 0;
        for(int i = 1; i < nums.length;i++){
            while(i < nums.length && (nums[i] - i == diff)){  
                i++;
                len++;
            }
            if(len == 0)    res.add(nums[i - 1] +""); //len == 0 表示只有nums[startIndex] 一个元素属于当前的子序列，采用第一种添加方式
            else    res.add(nums[startIndex] + "->" + nums[startIndex + len]);  //len > 0 表示当前子序列包含多个元素，采用第二种添加方式
            
            if(i <= nums.length - 1)    //每找到一个子序列并添加完后，更新startIndex、diff和len，进入下一个子序列的判断
            {
            	startIndex = i;
            	diff = nums[i] - i;
            	len = 0;
            }
            if(i == nums.length - 1)   //针对数组最后一个元素可能会是最后一个子序列的特殊情况，进行单独处理。
                res.add(nums[nums.length - 1] + "");
        }
        return res;
    }
}