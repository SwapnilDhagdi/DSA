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

//We will solve this in 3 steps 
/*
  1.Finding if Cycle exist
  2. finding length of cycle 
  3.finding start of cycle 
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast =head;
        int cycleLength=0;
        while(fast!=null && fast.next!=null){ //slow and fast pointer approach one moves one step and another moves 2 step eventually they will meet at a node if cycle present else there is no cycle 
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
               cycleLength=findLength(slow);//find length if present
                break;
            }

        }
        return firstNode(head,cycleLength); //with the length retrieved find the start of cycle
    }
    public int findLength(ListNode head){
        ListNode current=head;
        ListNode iter=head;
        int currentLength=0;

        while(true){//take 2 pointer and circle one around the cycle to get the length 
            iter=iter.next;
            currentLength+=1;

            if(iter == current){
                break;
            }
        }

        return currentLength;
    }
    public ListNode firstNode(ListNode head,int cycleLength){
        ListNode pointer1=head;
        ListNode pointer2=head;
        //take 2 pointer
        
        if (cycleLength==0) //edge case of there is no cycle 
        return null;

        while(cycleLength>0){//move one away from another pointer such that distance betn them == cycleLength 
            pointer2=pointer2.next;
            cycleLength-=1;
        }

        while(pointer1 != pointer2){ //eventually they will meet at a point and it is the start of cycle 
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }
        return pointer1;
    }
}
