class Solution {
    public boolean isPalindrome(int x) {
        // String data=Integer.toString(x);
        // for(int i=0;i<data.length()/2;i++){
        //     if(data.charAt(i) != data.charAt(data.length()-1-i)){
        //         return false;
        //     }
        // }
        // return true;

        StringBuilder data=new StringBuilder(Integer.toString(x));
        StringBuilder input=new StringBuilder(Integer.toString(x));
        if(data.reverse().compareTo(input)==0){
            return true;
        }
        return false;
    }
}
