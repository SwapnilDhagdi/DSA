/*Sliding window O(n)*/
//The approach is to traverse through string with a window size of 10 
//and 2 hashSet if the String left,right+1 is already present in set that means it is a valid string add it to result 
//if not add it to set
//the point of using another set instead of direstly using List<> is to avoid adding multiple same string
//at every iteration gradually moving window to right 
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10)return new ArrayList<>();
        Set<String> set=new HashSet<>();
        Set<String> result=new HashSet<>();
        int left=0;
       
        for(int right=9;right<s.length();right++){
            String subString=s.substring(left,right+1);
            if(set.contains(subString)){
                result.add(subString);
            }else{
                set.add(subString);
            }
            left++;
        }
        return new ArrayList<>(result);
    }
}
