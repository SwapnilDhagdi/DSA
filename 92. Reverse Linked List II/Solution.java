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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null) return head; //edge case 
                                            //1->2->3->4->5 left=2 right=4  the approach goes in three steps for 
                                            //step 1 moving the pointer to the left for this question left=2
                                            //step 2 iterating over the list and reversing them 
                                            // finally step 3 connecting reversed list head to the right+1 node and its tail to left-1 node 
        ListNode lp=new ListNode();
        ListNode result=lp;
        ListNode p=new ListNode();
        lp.next=head;
        ListNode c=head;
        for(int i=0;i<left-1;i++){//step 1
            lp.next=c;
            c=c.next;lp=lp.next;
        }
        ListNode temp=c.next;
        for(int j=0;j<right-left+1;j++){ //step 2 
            temp=c.next;
            c.next=p;
            p=c;
            c=temp;
            
        }
        lp.next.next=c;//step 3
        lp.next=p;
        return result.next;
    }
}
