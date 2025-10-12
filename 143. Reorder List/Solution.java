/* It is a 3 step approach */
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
  
   public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
        return;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {//first we will find the middle node by slow-fast/turtle-hare approach 
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode head1 = head;        
    ListNode head2 = slow.next;   
    slow.next = null; //disconnect the list from mid   

    ListNode prev = null;
    ListNode curr = head2;
    while (curr != null) {//then by classic 3 pointer approach we reverse the mid onwards list
        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
    }
    head2 = prev;


    ListNode p1 = head1;
    ListNode p2 = head2;
    

    while (p2 != null) {//then we just connect them in a zigzag pattern 
      
        ListNode next1 = p1.next;
        ListNode next2 = p2.next;

 
        p1.next = p2;
        p2.next = next1;

  
        p1 = next1;
        p2 = next2;
    }
}
}
