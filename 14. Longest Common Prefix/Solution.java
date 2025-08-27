class Solution {
    public String longestCommonPrefix(String[] strs) {
     String result="";
        String temp="";
        if(strs.length==0)return "";
        if(strs.length==1)return strs[0];
        Arrays.sort(strs,(a,b)->a.length()-b.length());
        for(int i=0;i<strs[0].length();i++){
            temp=strs[0].substring(0,i+1);
            for(String s:strs){
                if(!s.substring(0,i+1).equals(temp)){
                    return result;
                }
            }
            result=temp;
        }
        return result;   
    }
}
