/**
*LZS
*Solution599:两个list的最小索引和。给定两个String类型数组list1和list2，找到两个数组中都有的并且索引相加
*	最小的元素，并已String数组的形式返回。
*
*实例：
*	list1={"Shogun", "KFC", "Tapioca Express", "Burger King"}
*	list2={"KFC", "Shogun", "Burger King"}
*注意：
*	1.list1和list2中可能存在不止一对相同的元素，如上例中的“Shogun"、"KFC"、"Burger King"
*	2.list1和list2中相同元素的两个索引值之和可能有多个相同的最小值，如上例中的“Shogun"、"KFC"，索引值相加都是1
*思路：
*	1.定义一个map，先将list1中的元素为键，对应索引为值，存入map中
*	2.定义List类型list，存放每次索引和最小或者不变的对应元素。
*	3.遍历list2，每次找到一个共有元素，计算其索引和。对于索引和更小的元素，list先清空再添加；对于索引和
*		不变的元素，list直接追加，不用清空。
*	4.将最终所得的list转换成数组类型。利用list.toArray()方法。
**/

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<list1.length;i++)
            map.put(list1[i],i);
        
        List<String> list=new ArrayList<>();
        int minDis=Integer.MAX_VALUE,dis=0;
        
        for(int j=0;j<list2.length && j<=minDis;j++){ 
		//注意此处若j超过当前的最小索引和minDis，则肯定不满足之后的结果，所以就不用再判断了
            if(map.containsKey(list2[j])){
                dis=j+map.get(list2[j]);
                if(dis<minDis){
                    list.clear();
                    list.add(list2[j]);
                    minDis=dis;
                }
                else if(dis==minDis)
                    list.add(list2[j]); 
            }            
        }
        return list.toArray(new String[list.size()]);
    }
}