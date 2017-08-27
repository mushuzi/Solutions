/**
*LZS
*Solution160:给定两个交叉的单链表，返回交叉的位置
*
*思路：两个链表可以看做交叉前和交叉后两个部分，交叉后的长度是一样的，因此需要去掉长度差，此长度差即为总长度差
*	1.分别求出两个链表的长度
*	2.以较短的长度为基准，从前面去掉较长的链表多余长度的部分
*	3.两个链表放在一起就行比较，返回第一个相同的节点
*
**/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=getLength(headA);
        int lenB=getLength(headB);
        
        //将两个链表放到统一长度上
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenA<lenB){
            headB=headB.next;
            lenB--;
        }
        
        //开始比较
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
    //获取长度
        public int getLength(ListNode head){
            int len=0;
            while(head!=null){
                len++;
                head=head.next;
            }
            return len;
        }
        
}