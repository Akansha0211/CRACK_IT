/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return revListHelper(head, null);
    }
    public ListNode revListHelper(ListNode head, ListNode dummy){
        
        if(head == null){
            return dummy;
        }
        ListNode next = head.next;
        head.next = dummy;
        return revListHelper(next, head);
    }
}