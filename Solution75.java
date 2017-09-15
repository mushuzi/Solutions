/**
*LZS
*Solution75:给定一个由0,1,2乱序排列组成的数组nums，完成nums从0~1~2的排序（注意不能使用sort方法）
*
*思路1：统计置位法
*	1.统计nums中0,1,2出现的次数count0，count1，count2
*	2.将nums的前count0个位置置为0，紧接着count1个位置置为1，最后count2个位置置为2；
*
*思路2：双指针法
*	1.定义一个指针low指向nums前端第一个不等于0的位置，定义一个指针high指向nums后端第一个不为2的数
*	2.遍历nums，每遇到一个等于0的数（nums[i] == 0)，将这个位置的数与low位置的数交换，low++, i++；
*		每遇到一个等于2的数（nums[i] == 2)，将这个位置的数与high位置的数交换，high--;(注意这里i不能加1，
*		因为交换到i位上的那个数不一定是0，还可能是1，所以还需要与low位上的元素比较，在开启一轮新的比较)。
**/

//思路1：统计置位法
class Solution {
    public void sortColors(int[] nums) {
        
        int count0 = 0, count1 = 0, count2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)    count0++;
            else if(nums[i] == 1)   count1++;
            else if(nums[i] == 2)   count2++;
        }
        System.out.println("count0 = "+count0 + " count1 = "+ count1 + " count2 = "+count2);
        for(int i = 0; i < nums.length;){
            while(count0 != 0){
                nums[i] = 0;
                count0--;
                i++;
            }
            
            while(count1 != 0){
                nums[i] = 1;
                count1--;
                i++;
            }
            
            while(count2 != 0){
                nums[i] = 2;
                count2--;
                i++;
            }
        }
    }
}


//思路2：双指针法
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        for(int i = low; i <= high;){
            if(nums[i] == 0){
                nums[i] = nums[low];
                nums[low] = 0;
                low++;
                i++;
            }
            else if(nums[i] == 2){
                nums[i] = nums[high];
                nums[high] = 2;
                high--;
            }
            else
                i++;
        }        
    }
}
