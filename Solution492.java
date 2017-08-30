/**
*LZS
*Solution492:构建四边形。给定一个面积area，要求以int型数组的形式返回四边形的长L和宽W
*	L和W满足以下三个条件：1.L*W=area；2.L>=W；3.L和W应尽可能接近
*
*思路：本题是一个简单的数学计算题。由条件3可知L和W最接近的极端情况就是L=W，且L*W=area，
*	所以L和W应该以Math.sqrt(area)为界，且L>=Math.sqrt(area),W<=Math.sqrt(area)
*	由于L*W=area的限制，只要确定L或者W之中的一个，另一个也跟着确定。
*	由于L和W应尽可能接近，所以在循环判断时应该从L的小端开始递增或者由W的大端开始递减
*	得到满足条件的一组数之后，将大的赋值给res[0]，将小的赋值给res[1]即可
**/

class Solution {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        if(area == 0)   return res;
        for(int i = (int) Math.sqrt(area); i >0; i--){
            if(area % i == 0){
                res[0] = area/i ;
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}