/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // step 1 Insertion
       //insertion
        Node temp = head;
        while(temp != null){
            Node n = new Node(temp.val);
            Node tempP1 = temp.next;
            temp.next = n;
            n.next = tempP1;
            temp = tempP1;
        }
        //setting the random pointers
        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        //Extraction
        Node temp1 = head; 
        Node temp2 = null;
        if(head != null) temp2 = head.next;
        Node head2 = temp2;
        while(temp1 != null && temp2 != null){
            Node temp1P1 = temp1.next.next;
            Node temp2P1 = null;
            if(temp2.next != null){
                temp2P1 = temp2.next.next;
            }
            temp1.next = temp1P1;
            temp2.next = temp2P1;
            temp1 = temp1P1;
            temp2 = temp2P1;
        }
        return head2;
    }
}