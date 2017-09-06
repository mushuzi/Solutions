/**
*LZs
*Solution8:实现atoi功能，将字符串转化为整型
*
*思路：
*	1.判断字符串是否为空，如果是，则返回0；
*	2.去除给定字符串的空格，可以使用简单的判断，也可以使用str.trim()方法
*	3.判断正负号，如果字符串首端不出现符号或出现“+”，则说明是正数；如果出现“-”，则说明是负数
*	4.对str剩下的的部分：判断是否是合法输入、字符串转换为数字、判断是否存在溢出
*
*注意：
*	1.字符串转换成数字：乘10累加，即total = total * 10 + str.charAt(i)-'0';
*			str.charAt(i)-'0'是将字符转化成数字的最便捷的方法！！！！
*	2.合法输入的判断：合法的数字应该是0~9，若碰到此范围之外的字符则停止转化
*	3.溢出的判断：必须在最后一步之前进行判断，否则计算机会自动做溢出处理。
*		比如得到了负号flag为正，绝对值total为2147483648的数后，计算机会自动将其转化为-2147483648，从而跳过溢出处理
*		所以此处想的办法是在total = total*10+digit执行之前判定是否溢出，而相应的判定条件也要做除以10的处理
**/

class Solution {
    public int myAtoi(String str) {
        //1.判断str时候为空，或长度为0
        if(str == null || str.length() == 0)    return 0;
        
        //2.去掉开头多余的空格
        int index = 0;
        while(str.charAt(index) == ' ' && index < str.length())
            index++;
        
        //3.判断正负号
        int flag = 1;
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            flag = (str.charAt(index) == '+') ? 1 : -1;
            index++;
        }
        
        //4.转换数字：判断是否是合法输入，并且判断是否存在溢出
        int total = 0;

        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit > 9 || digit < 0)  break;
            
            
            if(Integer.MAX_VALUE/10 < total || (Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit))
            return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            total = total * 10 + digit;
            index++;            
            
        }
        return total * flag;
    }
}