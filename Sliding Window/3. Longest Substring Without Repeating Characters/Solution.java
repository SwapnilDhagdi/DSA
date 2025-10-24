//Sliding window approach
//Approach 1 O(n)
// using a deque to handle the pop operation 
// A hashset to handle the efficiently searching operation
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maximum=Integer.MIN_VALUE,size=0;
        if(s.length()==0)return 0;
        if(s.length()==1) return 1;
        Deque<Character> queue=new LinkedList<>();
        Set<Character> set=new HashSet<>();
   
        for(int i=0;i<s.length();i++){
            char currentChar=s.charAt(i);
            if(!set.contains(currentChar)){//if element not present add it to queue and set
               set.add(currentChar);
               queue.addFirst(currentChar);
               size+=1; 
            }else{//if it contains pop untill untill the removed character is equal to current , then push back current char 
                char removedChar=queue.removeLast();
                size-=1;
                set.remove(removedChar);
                while(removedChar!=currentChar){
                    size-=1;
                    removedChar=queue.removeLast();
                    set.remove(removedChar);
                }
                set.add(currentChar);
                queue.addFirst(currentChar);
                size+=1;
            }
            maximum=Math.max(maximum,size);
        }

        return maximum;
    }
}


/*Approach 2 O(n)*/
//this approach carries only hashset 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maximum=Integer.MIN_VALUE,size=0;
        if(s.length()==0)return 0;
        if(s.length()==1) return 1;
        Set<Character> set=new HashSet<>();
        int i=0,left=0;
        while(i<s.length()){
            char currentChar=s.charAt(i);
            if(!set.contain(currentChar)){ // if set does not contain element, add it and update the maximum 
                set.add(currentChar);
                maximum=Math.max(maximum,set.size());
                i++;
            }else{// if it is present remove left most element from set and increment the left , Since it did not increment i it will again check for same character occurance ultimately removing till it removes till that character and in next iteration add it and the process continues                set.remove(s.charAt(left++));
            }
        }
        return maximum;
    }
}
