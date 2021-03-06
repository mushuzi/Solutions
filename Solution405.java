/**
*LZS
*Solution405：给定一个十进制数，将其转化成十六进制，对于负数，使用二进制补码
*
*思路：先将十进制数转化成二进制数，再转化成十六进制数
*	1.首先声明一个数组map，用来存储0~15的数字与十六进制数的对应关系
*	2.使num与1111（即15）进行按位与，此操作用于取出num的从低位到高位的后4位，
*		按位与的结果就是转换成16进制后的结果，与对应的字符拼接即可
*	3.为了取到所有num的位数，每次需要将num进行无符号右移4位
*	4.num为0的时候，说明处理结束，可以跳出循环
**/

class Solution {
    public String toHex(int num) {
        if(num==0)  return "0";
        
        char[] map={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String res="";
        
        while(num!=0){
            res =map[num & 15] + res;
            num = (num >>> 4);
        }
        return res;
    }
}