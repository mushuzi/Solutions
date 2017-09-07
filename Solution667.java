/**
*LZS
*Solution667:Beautiful Arrangement II:给定一个整数n和整数k，1<=k<n， 使用1~n的数构造一个长度为n的数组[a1, a2, a3, ... , an]
*	使得其[|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 恰好包含k个不同的整数
*
*思路：具体的构造方法很巧妙，自己始终想不出来，参考了网上的思路。

*n为偶数时，例如n=6,将n进行以下方式的排列：
*	1	2	3
* 6   5   4
*	如果k=5,则构造数组为[6,1,5,2,4,3],各数之间的间隔恰好为[5,4,3,2,1] 包含5=k个不同的整数
*	如果k=4,则构造数组为[6,1,5,2,3,4]，各数之间的间隔恰好为[5,4,3,1,1] 包含4=k个不同的整数
*规律：n为偶数时，按照上述方式排列，数组res构造方式如下：偶数位取int end=n, n--，奇数位取int start=0, start++; 直到取满k个元素为止。
*	剩余的n-k个位置，如果k恰好是偶数位，则res[j] = res[j-1] + 1;否则，则res[j] = res[j+1] - 1;

*n为奇数时，例如n=1,将n进行以下方式的排列：
*	1	2	3	4
* 	  7   6   5  
*	如果k=6,则构造数组为[1,7,2,6,3,5,4],各数之间的间隔恰好为[6,5,4,3,2,1] 包含6=k个不同的整数
*	如果k=5,则构造数组为[1,7,2,6,3,4,5]，各数之间的间隔恰好为[6,5,4,3,1,1] 包含5=k个不同的整数
*规律：n为奇数时，按照上述方式排列，数组res构造方式如下：奇数位取int end=n, n--，偶数位取int start=0, start++; 直到取满k个元素为止。
*	剩余的n-k个位置，如果k恰好是偶数位，则res[j] = res[j-1] - 1;否则，则res[j] = res[j+1] + 1;
*/

class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] res = new int[n];
        
		//这一段逻辑略乱，可以加以改进
        int start = 1, end = n;
        int index1 = 0, index2 = 0;
        if(n % 2 == 0)  index1 = 1;
        else    index2 = 1;
        
        while(index1 <= k && index2<= k){
            res[index1] = start++;
            res[index2] = end--;
            index1 += 2;
            index2 += 2;
        }
        
		//下面这四段太繁琐了，可以加以整理
        if(n % 2 == 0 && k % 2 == 0){
            for(int j = k; j < n; j++)
                res[j] = res[j-1] + 1;
        }
        
        if(n % 2 == 0 && k % 2 == 1){
            for(int j = k; j < n; j++)
                res[j] = res[j-1] - 1;
        }
        
        if(n % 2 == 1 && k % 2 == 0){
            for(int j = k; j < n; j++)
                res[j] = res[j-1] - 1;
        }
        
        if(n % 2 == 1 && k % 2 == 1){
            for(int j = k; j < n; j++)
                res[j] = res[j-1] + 1;
        }
        return res;
	}
}

//以上代码为了便于理解，写的较为繁琐。下面是整理过后的简洁版的代码，两个版本可以对照理解
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int start = 1, end = n, index1 = 0, index2 = 1;
        
        while(index1 <= k && index2 <= k){
            res[index1] = (n % 2 == 0) ? end-- : start++;
            res[index2] = (n % 2 == 0) ? start++ : end--;
            index1 += 2;
            index2 += 2;
        }
        
        for(int j= k; j < n; j++){
            res[j] = (((n % 2) ^ (k % 2)) == 1) ? (res[j-1] - 1) : (res[j-1] + 1);
        }
        return res;
    }
}