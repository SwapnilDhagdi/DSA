/*Sliding window approach*/
// maintain a data structure such as array or map that can be use to keep track of frequencies 
class Solution {
    public int characterReplacement(String s, int k) {
        int [] charFrequency=new int[26];
        int i=0,left=0,maxLength=Integer.MIN_VALUE,currentMax=0,windowLength=0;
        while(i<s.length()){
            char currentChar=s.charAt(i);
            int frequencyIndex=currentChar-'A';
            charFrequency[frequencyIndex]=charFrequency[frequencyIndex]+1;//update the array values as per the character arrives 
            currentMax=Math.max(currentMax,charFrequency[frequencyIndex]);//update the current maxvalue if it got changed
            windowLength+=1;//update the window 
            if(windowLength-currentMax>k){//* important *  if the current window size is too large i.e windowsize-maxFrequency<k that mean the window is too large 
                                          // because it has too many element in it that after substituting k elements also make the window size large that mean i can be trimmed down
                char leftChar=s.charAt(left);
                charFrequency[leftChar-'A']=charFrequency[leftChar-'A']-1; //update the element frequency of that character
                left++;
                windowLength--;
            }
            i++;
            maxLength=Math.max(maxLength,windowLength);
        }
        return maxLength;
    }
   
}
