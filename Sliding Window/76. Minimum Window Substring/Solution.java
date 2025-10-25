/*Sliding Window*/
//The approach is to use 2 arrays one for the t string elements and one for s frequency element 
//these will help to find the occurance or elements 
class Solution {
    private int[] tFrequency=new int[58];
    private int[] sFrequency=new int[58];
    public String minWindow(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();
        int left=0,minLength=Integer.MAX_VALUE,start=0;
        if(tLen>sLen){//edge case
            return "";
        }
       
        for(int i=0;i<tLen;i++){// place elements in the tFrequency and sFrequency array till t.length()
            sFrequency[s.charAt(i)-'A']+=1;
            tFrequency[t.charAt(i)-'A']+=1;
        }
        if(isEqual()){//inital check if they are equal or not 
            return s.substring(0,tLen);
        }
        for(int right=tLen;right<sLen;right++){//iterating through the s string
            sFrequency[s.charAt(right)-'A']+=1;// increasing frequency of the element at index right in the string s 
                while(isEqual()){//continusly checking if the arrays are equal  ,if they do 
                    if(right-left+1 < minLength){//calculate its length ,if less then minimum 
                        start=left;//update the start
                        minLength=right-left+1;//update the minlength
                    }
                    sFrequency[s.charAt(left++)-'A']-=1;//remove the element count from the sFrequency array 
                }

        }
        if(minLength==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+minLength);
    }
    public boolean isEqual(){
        for(int i=0;i<tFrequency.length;i++){ // we dont need check entire sFrequency array  , just check for the tFrequency array element cause those are the atleast condition that need to be followed 
            if(tFrequency[i]!=0){//this is to reduce the scope of the traversing and also , avoiding conditions where new element is in there that is not present is t String caouse it will throw false
                if(tFrequency[i]>sFrequency[i]){ // frequency of element in t can be less or equal to s element ,But it can newer be greater than s element if they do that means the elements in frequency are missing
                    return false;//thus they are not equal 
                }
            }
        }
        return true;
    }
}
