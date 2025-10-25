/*Sliding window*/
// The approach is to maintain 2 array one to count frequency of elemnts in p string and one for s 
//first populate both with their inital p.length() element to create a window of windowLengt p.Length initall check if both arrays are equal add 0 to the list cause its the starting index of the matched string

//gradually moving to right side adding right side  and decrementing left side element of the string 
//windowLength will we constant through out the iteration
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length())return new ArrayList<>();
        int[] pFrequency=new int[26];
        int[] sFrequency=new int[26];
        int pLen=p.length();
        int sLen=s.length();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<pLen;i++){
            sFrequency[s.charAt(i)-'a']+=1;
            pFrequency[p.charAt(i)-'a']+=1;
        }
        if(Arrays.equals(pFrequency,sFrequency)){//inital check 
            result.add(0);
        }
        for(int right=pLen;right<sLen;right++){ //from pLength to s.Length 
            int left=right-pLen;//to reduce the windowSize 
            sFrequency[s.charAt(right)-'a']+=1;
            sFrequency[s.charAt(left)-'a']-=1;
            if(Arrays.equals(sFrequency,pFrequency)){ // if the arrays matched that mean element in that window has the same occurance as of elments in p string cause pLen=windowLength  
                result.add(left+1);// add it to the list 
            }
        }
        return result;
    }
}
