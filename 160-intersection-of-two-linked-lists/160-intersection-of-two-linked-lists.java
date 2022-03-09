/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = getCount(headA);
        int count2 = getCount(headB);
        int diff = Math.abs(count1 - count2);
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        if(count1 > count2){
            while(diff >0){
                temp1 = temp1.next;
                diff--;
            }
        }else{
            while(diff >0){
                temp2 = temp2.next;
                diff--;
            }
        }
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp2;
    }
    public int getCount(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}