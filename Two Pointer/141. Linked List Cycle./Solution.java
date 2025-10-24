/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode small=head;
        ListNode fast=small.next;

        while(fast!=null || small!=null){//if fast or small reach the null that means there is no cycle 
            if(small==fast){
                return true;
            }
            small=small.next;
            if(fast.next!=null && fast.next.next!=null){//if they meet that means there is ccycle
                fast=fast.next.next;
            }else{
                break;
            }
        }
        return false;
    }   
}
