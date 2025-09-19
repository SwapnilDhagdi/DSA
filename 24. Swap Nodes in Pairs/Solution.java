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
/*Approach 1 3 pointer approach O(n)*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode prev=head;
        ListNode curr=prev.next;
        ListNode temp=head;
        head=head.next;//this will change head one step front so that after change head will be at its place 
        while(curr!=null){ //to check the condition
            temp.next=curr;// used to disconnect and reconnect to the node 
            prev.next=curr.next; // performs swaping
            curr.next=prev;
            if(prev.next==null || prev.next.next==null ){//checking condition before making 
                return head;
            }
            temp=prev;
            prev=prev.next;//moving 2 steps ahed
            curr=prev.next;
        }
        return head;

        
    }
}
