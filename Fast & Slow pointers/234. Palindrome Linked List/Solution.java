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
Slipt the linked list in two halfes by slow and fast pointer approach the slow pointer will indicate the middle of list or start of other half of list 

Revere secound half this will return the other half of list 
compare both of the and find out 
  */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode secoundHalfStart=reverse(slow);
        while(head!=null && secoundHalfStart!=null){
            if(head.val != secoundHalfStart.val)
            return false;

            head=head.next;
            secoundHalfStart=secoundHalfStart.next;
        }
        return true;
    }
    ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
