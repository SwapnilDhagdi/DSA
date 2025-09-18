/*Approach 1  Two pass approach */
class Solution {
     public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1) return null; //edge case
        int length=0;
        ListNode temp=head;
        while(temp!=null){//this will calculate the length of list 
            length++;
            temp=temp.next;
        }
        int len=length-n; // previous node to the node want to delete 
        ListNode prev=head;
        for(int i=1;i<len;i++){
            prev=prev.next; // move node to the prev node to deleting node
        }
        
        if(prev.next==null){ //if it is last node update prev.next
         prev.next=null;
        }else if(length-n==0){
            head=head.next;//if it is head move head node
        }
        else{
           prev.next=prev.next.next;// bypass the node to delete 
        } 
       
        return head;
    }
}

/*Approach 2 2 pointer Approach */

class Solution {
     public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1) return null;// Edge case

        ListNode prev=head; //setting both to head
        ListNode post=head;
        for(int i=0;i<n;i++){//this will gcreate a gap of n between prev and post 
            post=post.next;
            if(post==null) return head.next; // checking for the head 
        }
        while(post.next!=null){//this will ultimately place the prev node just behind the deleting node
            prev=prev.next;
            post=post.next;
        }
        prev.next=prev.next.next;//bypass the deleting node
        return head;
    }
}
