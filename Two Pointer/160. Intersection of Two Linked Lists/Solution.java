/*Approach 1 O(m+n)*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
        Set<ListNode> visited = new HashSet<>(); // a hashset to verify the node 

   
        ListNode tempA = headA;//store all the node in list 
        while (tempA != null) {
            visited.add(tempA);
            tempA = tempA.next;
        }

      
        ListNode tempB = headB;
        while (tempB != null) {// check if the node present in set
            if (visited.contains(tempB)) {
                return tempB; //return 
            }
            tempB = tempB.next; 
        }

        return null;
    }
}

/*Approach 2 O(n+m)*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;//this approach works like a cycle 

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;//if a reaches to end move it to headB
            b = (b == null) ? headA : b.next;//if b reaches to end move it to headA
        }                                    //eventually they will meat at node or null

        return a;
    }
}
