/**
*LZS
*Solution605:种花问题，给定花床flowerbed和需要种花的数量n，判定是否能种到n株，要求两株花不能挨着。
*本题的难点在于对数组边界的处理，如果不知道怎么处理边界，这道题可能无从下手！
*思路：如果数组第0个位置和第一个位置都为0，则可以在数组第一个位置种一株花（第一位置1）；如果数组最后两个位置都为零，则可以在最后一个位置种一株花（最后一位置1）
*		对于数组中间的位置，如果当前位置已经种过花了（当前位置为1），则判断其前一个位置和后一个位置是否都空闲，若是，则可以在当前位置种一株花（当前位置置1）
*		依次类推，计算给定数组所能种花的数量f，如果数量大于等于给定的n，则返回TRUE，否则返回FALSE。
*		同时，还要注意处理数组长度为1时的特殊情况。
**/

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int f=0,len=flowerbed.length;
		
        if(len==1 && flowerbed[0]==0 && n<=1)   return true;
        
        if(flowerbed[0]==0 && flowerbed[1]==0){
            f+=1;
            flowerbed[0]=1;
        }
		
        if(flowerbed[len-1]==0 && flowerbed[len-2]==0){
            f+=1;
            flowerbed[len-1]=1;
        }  
        
        for(int i=1;i<len-2;i++){
            if(flowerbed[i-1]==0 && flowerbed[i+1]==0 && flowerbed[i]==0){
                f+=1;
                flowerbed[i]=1;
            }
        }
        if(f>=n)    return true;
        else    return false;
    }
}