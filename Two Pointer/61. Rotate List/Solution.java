/*Approach 1 O(k*n)*/
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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        if(head==null) return null;
        if(head.next==null) return head;
        int length=0;

        ListNode counter=head;
        while(counter.next!=null){
            counter=counter.next;
            length++;
        }
        length+=1; //calcule length of LL
        k%=length; //calculate remainder i.e after k turn which sequence will be present
    
        if(k==0) return head;
        
        for(int i=0;i<k;i++) {//this will disconnect last second element and conncet last element to head and update head , this will happen k times
            ListNode prev_iterator=head;
            ListNode iterator=head.next;
            while (iterator.next != null) {
                prev_iterator = prev_iterator.next;
                iterator = prev_iterator.next;
            }
            prev_iterator.next = null;
            iterator.next = head;
            head = iterator;
        }
        return head;
    }
}

/*Approach 2 O(n)*/

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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        if(head==null) return null;
        if(head.next==null) return head;
        int length=0;

        ListNode counter=head;
        while(counter.next!=null){
            counter=counter.next;
            length++;
        }
        length+=1;
        k%=length;
                    //till now same as approach 1
        if(k==0) return head;
                                                                [1    2    3   4   5] k=2
                                                                head     prev post
        ListNode prev=head; 
        ListNode post=head.next;//to disconnect the prev and post and connect last elemnt to head and update head 
        for(int i=0;i<length-k-1;i++){
            prev=prev.next;  
            post=prev.next;
        }
        prev.next=null;
        counter.next=head;//for this use counter elemnt used to find length
        head=post;
        return head;
    }
}
