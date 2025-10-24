/*Approach 1 O(n)*/
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
    public ListNode partition(ListNode head, int x) {
        ListNode greater=new ListNode();
        ListNode smaller=new ListNode();
        ListNode ghead=greater;
        ListNode shead=smaller;
        ListNode post=head;
        while(post!=null){ //make 2 sappera node larger and smaller for number compare to X 
            if(post.val<x){//if smaller it will connect to smaller else to greater 
                smaller.next=post;
         
                smaller=smaller.next;
            }else{
                greater.next=post;
    
                greater=greater.next;
            }
            post=post.nextl
        }
        greater.next=null; //at the end trim end of greater 
        smaller.next=ghead.next;//connect smaller and greater 
        return shead.next;
    }
}
