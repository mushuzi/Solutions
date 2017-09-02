/**
*LZS
*Solution504:给定一个整型带符号数，将其转换成7进制的数，并以字符串的形式返回
*
*思路1（自己想的，效率比较低 ，但是便于理解）
*	1.首先将符号位与数字独立出来，使用一个flag来标志符号位，然后将num统一成正值
*	2.对num做长除法处理，并将每次得到的余数添加到list中
*	3.从后向前遍历list，对得到的余数进行组合
*	4.将符号位与res组合，并返回
*
*思路2（官方做法，代码简洁，效率很高）
*	1.正负数的统一：num为负数时，将其转化为-num，作为参数传入方法中
*	2.递归初始状态的设立：当num小于7时，不会做计算上的转换，直接返回num+""
*	3.递归调用方法，每次递归输入参数为num/7，与num%7进行字符串拼接并返回
*/

//思路1 
class Solution {
    public String convertToBase7(int num) {
        if(num==0)  return "0";
        
        List<Integer> list=new ArrayList<>();   //声明一个list，存放每次计算得到的余数
        String res="";
        
        //把符号位从num中独立出来，并将num统一化成正数
        String flag=num>0 ? "" : "-";
        num = num > 0 ? num : -num;
        
        //对num做长除法操作
        while(num!=0){
            list.add(num%7);
            num/=7;
        }
        
        //从后往前遍历list，组成转换后的字符串
        System.out.println("list:"+list);
        for(int i = list.size()-1; i >= 0; i--)
            res+=list.get(i)+"";
        return flag+res;
    }
}

//思路2 
class Solution {    
    public String convertToBase7(int num){
        if(num < 0) return "-"+convertToBase7(-num);
        
        if(num < 7)   return num + "";
        
        return convertToBase7(num / 7) + num % 7;
    }
}