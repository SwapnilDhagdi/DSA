class Solution {
    public int lengthOfLastWord(String s) {
        boolean isword=false;
        int spacecount=0;
        if(s.length()==1) return 1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                isword=true;
            }
            if(s.charAt(i)==' ' && isword){
                return s.length()-i-1-spacecount;
            }else if(s.charAt(i)==' '){
                spacecount++;
            }
        }
        if(isword){
            return s.length()-spacecount;
        }
        return 0;
    }
}
