class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0)return -1;

        if(haystack.length()==1 && haystack.equals(needle))return 0; 
        for(int i=0;i<haystack.length();i++){
           if(haystack.charAt(i)==needle.charAt(0) && i+needle.length()<=haystack.length()){
               if(haystack.substring(i,i+needle.length()).equals(needle)){
                   return i;
               }
           }
        }
        // if(haystack.contains(needle)){
        //     return haystack.indexOf(needle);
        // }
        return -1;
    }
}
