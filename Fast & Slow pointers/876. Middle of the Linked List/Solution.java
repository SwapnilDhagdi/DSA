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

/*
  Take 2 pointers nd initialize them with head
  ptr1 this move only one space
  ptr2 this will move 2 space 

  if ptr2 reaches the end the ptr1 will show the position of mid ptr because it is moving half times the ptr2 
  

*/
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next==null){
            return head;
        }
        if (head.next.next==null){
            return head.next;
        }
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
