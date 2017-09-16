/**
*LZS
*Solution670:给定一个非负整数num，交换num的两位数字使其构成的新的整数最大，规定只能交换一次
*
*思路：要想得到最大的整数，需要尽量使大数靠前，小数靠后，由于大数在前比小数在后的对数的大小的影响更大，
*	所以我们尽量把最大数换到前面来。具体步骤如下：
*	1.先将num转化成字符数组，便于处理num的每一位
*	2.定义长度为10的数组bucket，统计num中每个数字最后出现的索引位置
*	3.遍历num，针对num[i]，找到i位置之后的所有比num[i]大的数中最大的那个数，将两个数交换，构成的数就是一次交换所能得到的最大的数。
*	4.一次交换过后，将字符数组转化成数字并返回。
**/

class Solution {
    public int maximumSwap(int num) {
        //1.先将num转化成字符数组，方便对每一位进行操作
        char[] digits = String.valueOf(num).toCharArray();
        
        if(digits.length <= 1)  return num;
        
        //2.定义长度为10的数组bucket，统计digits中每个数组最后出现的索引。如num=234335，则digit[3]=4;
        int[] bucket = new int[10];
        for(int i = 0; i < digits.length; i++)
            bucket[digits[i] - '0'] = i;
        
        //3.遍历num，对于每一个num[i]，找到i位置后所有比num[i]大的数中最大的那一个的位置
        for(int i = 0; i < digits.length; i++){
            for(int k = 9; k > digits[i] - '0'; k--){
                if(bucket[k] > i){
                    char temp = digits[i];
                    digits[i] = digits[bucket[k]];
                    digits[bucket[k]] = temp;
                    return Integer.valueOf(new String(digits));
                }
                
            }
        }
        return num;
    }
}