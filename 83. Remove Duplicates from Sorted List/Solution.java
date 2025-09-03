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
     public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)return null;
        if(head.next==null) return head;
        ListNode prev=head;
        ListNode post=head.next;
        while(true){
            if(post==null){
                break;
            }else if(post.next==null){
                if(prev.val==post.val){
                    prev.next=null;
                    break;
                }else{
                    prev.next=post;
                    break;
                }
            }
            if(prev.val==post.val){
                post=post.next;
            }else{
                prev.next=post;
                post=post.next;
                prev=prev.next;
            }
        }
        return head;
    }
}
