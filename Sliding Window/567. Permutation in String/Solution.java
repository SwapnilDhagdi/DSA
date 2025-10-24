/*Sliding window */
//the approach is to carry 2 array one for s1 and one for s2 populate it wih first s1.length() elements and check if they are equal 
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(len1>len2){
        int len2=s2.length(),len1=s1.length();
            return false;
        }
        int[] s1Array=new int[26];
        int [] s2Array=new int[26];
        for(int i=0;i<len1;i++){
            s1Array[s1.charAt(i)-'a']+=1;
            s2Array[s2.charAt(i)-'a']+=1;
        }
        if(Arrays.equals(s1Array,s2Array)){//if they are equal the pair is at start
            return true;
        }
        for(int right=len1;right<len2;right++){
            char currentChar=s2.charAt(right);
            s2Array[currentChar-'a']+=1;//increment the array[currentcharacter]   
            int left=right-len1;// //reduce the window size
            s2Array[s2.charAt(left)-'a']-=1; //reduce the frequence of leaving character
            if(Arrays.equals(s1Array,s2Array)){ //check if the arrays are equal 
                return true;
            }
        }
        return false;
    }
}
