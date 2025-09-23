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
/*Approach 1 O(n)*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    
        Map<Integer,Integer> map=new LinkedHashMap();

        ListNode post=head;
        ListNode result=new ListNode();
        ListNode rhead=result;
        while(post!=null){//store number as key and value as their number of occurance in list
            if(map.containsKey(post.val)){
                map.replace(post.val,map.get(post.val)+1);
            }else{
                map.put(post.val,1);
            }
            post=post.next;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){//make new list and add only node whose occurance less than 2 
            if(entry.getValue()<2){
                result.next=new ListNode(entry.getKey());
                result=result.next;
            }
        }
        return rhead.next;
      

    }
}


/*Approach 2 O(n)*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
                      
        ListNode prev=new ListNode();//make a new list node 
        ListNode h=prev;//new head node to track head of node 
        ListNode curr=head;
        if(head==null || head.next==null) return head;
        while(curr!=null && curr.next!=null){//loop iterate untill node or its next is null
            if(curr.val==curr.next.val){//if curr and its next value match iterate untill curr and its next value not equal then join prev.nextto curr.next ,but dont move prev node as it can be or can not be correct
               while(curr.next!=null && (curr.val==curr.next.val)){
                curr=curr.next;
               } 
               prev.next=curr.next;
               curr=curr.next;
            }else{
               prev.next=curr;//if the value not match move prev to curr and increment both to next node 
               prev=prev.next;
               curr=curr.next; 
            }
        }
        return h.next; //return duummy node head
    }
}
