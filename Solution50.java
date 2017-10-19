/**
*LZS
*Solution50:计算x的n次方
*
*思路：题目给的很简单，也没有过多的说明，但是这道题却蕴含着很多的陷阱！
*	1.首先我们得想到x的n次方，n的取值范围为负无穷大到正无穷大，即n可正可负还可以为0
*		1)n == 0:   x^n = 1;
*		2)n == 1:	x^n = x;
*		3)n > 0:	x^n = x^n;
*		4)n < 0:	x^n = 1/x^(-n)
*		从上述分析可以看到n>0和n<0的下对次方的计算方法是不一样的，因此参考除法的实现，将正负号通过sign独立出来，
*	从而把正负号统一成正
*
*	2.统一成正数以后，问题转化成如何求一个数x的n次方，n为正数。	定义专门的pow(x,n)函数
*		毫无疑问，用简单的累乘是效率低下的，这里采用二分的方法，即
*	1)如果n是偶数，则pow(x,n) = pow(x, n/2)*pow(x, n/2);
*	2)如果n是奇数，则pow(x,n) = pow(x, n/2)*pow(x, n/2)*x;
*	这样就成2的指数倍降低了复杂度，时间复杂度为O(logn)
**/

class Solution {
    public double myPow(double x, int n) {
        //1.特殊情况的处理
        if(n == 0)  return 1;
        if(n == 1)  return x;
        
        //2.n正负号的处理
        int sign = 0;
        if(n < 0){
            sign = -1;
            n = -n;
        }
        
        return (sign == -1) ? 1 / pow(x, n) : pow(x, n);
    }
    
    //定义一个函数pow(x,n),计算x的n次方，且n为正数
    private double pow(double x, int n){
        if(n == 0)  return 1;
        if(n == 1)  return x;
        if(n % 2 == 0){
            double temp = pow(x, n / 2);
            return temp * temp;
        }
        else{
            double temp = pow(x, n / 2);
            return temp * temp * x;
        }
    }
}