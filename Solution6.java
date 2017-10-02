/**
*LZS
*Solution6:ZigZag Conversion
*给定一个字符串s和一个行数numRows，将这个字符串按照numRows行的锯齿形结构输出
*
*思路：这道题本身不考察算法，更多是数学上归纳总结的东西。但是有几个比较值得借鉴的点，总结一下。
*	1.在动手写代码之前，一定要先对问题有一个整体的解决思路，否则很难写出正确的代码。
*	2.一定要提前处理特殊情况，然后再解决常规情况
*	3.以后碰到这种需要用到新的字符串的问题，一定不要再用new一个String类型对象或者new一个char数组再转化成String的
*方法了，这样做效率很低，并且在很多问题上我们并不需要完全搞清楚所求字符串和所给字符串之间的字母的索引对应关系，
*所以尽可能使用StringBuffer类和StringBuilder类的append()方法，这样速度很快，而且很方便，最后再使用toString()方法
*将对象转成字符串即可。
**/

class Solution {
    public String convert(String s, int numRows) {
        //1.考虑特殊情况的处理
        if(numRows <= 0)    return "";
        if(numRows == 1 || s.length() <= numRows)   return s;
        
        //2.正式进入常规情况的处理
        StringBuffer buffer = new StringBuffer();   //这里使用StringBuffer的append方法，避免了新的字符串与s的字母的位置对应关系。
        int len = s.length();
        
        //3.i表示当前行，j表示当前列，i和j都从0开始。
        for(int i = 0; i < len && i < numRows; i++){
            //4.定义start，用来标识当前行的起始位置，随后会随着规律向当前行的后面推进
            int start = i;  //没到一个新的行，重新初始化start为行号（因为这里行号刚好对应字母在s中的位置），并把s.charAt(start)加到buffer中
            buffer.append(s.charAt(start));
            
            for(int j = 1; start < len; j++)    //j从1开始，因为第一列在start的初始化时已经处理过了
            {
                if(i == 0 || i == numRows - 1)  //第一行和最后一行的更新规则：start + 2 * numRows - 2 
                    start += 2 * numRows - 2;
                else{
                    if(j % 2 == 1)  //奇数列的更新规则：start + 2 * (总行数 - 当前行 - 1)
                        start += 2 * (numRows - i - 1);
                    else    //偶数列的更新规则：start + 2 * 当前行
                        start += 2 * i; 
                } 
                
                if(start < len)
                    buffer.append(s.charAt(start));
            }            
        }
        
        return buffer.toString();
    }
}