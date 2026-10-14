/*
  There are 2 ways to solve this problem 
    1.Non Recursion
    2. Recursion

*/

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
// 1.Recursion
      /*
        Make a function to perform recursion 

        reverseList function will return the result by calling another fundtion 

        the recursion function 
            check if the curr is null if yes return the prev node
            if not 
              create new node that points to currt.next 
              then take curr.next to prev 
              prev =curr 
              curr = next 

              the will leave a gap between the node but since the curr is not null there are chances it will connect later on and if the curr becomes null then any ways we are returning prev
      */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        return reverseListRecursion(prev,head);
    }
    private ListNode reverseListRecursion(ListNode prev,ListNode curr){
        if (curr==null){
            return prev;
        }
        ListNode next = curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        return reverseListRecursion(prev,curr);
    }
}

Or 
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
  // Non recursion 


  /*
    we will traverse till curr become null 
      take a node prev that initally points to null
      while traversing create a new node next that points to curr.next 
      curr.next = prev,
      prev=curr,
      curr=next

      if curr became null  we willl return prev
  */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr != null){
            ListNode next =curr.next;

            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
   
}
