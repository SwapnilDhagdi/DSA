/*Approach 1O(log(x)) */
class Solution {
     public int reverse(int x) {
        long result=x<0?Long.parseLong(new StringBuilder(Integer.toString(x).substring(1)).reverse().toString())*-1:Long.parseLong(new StringBuilder(Integer.toString(x)).reverse().toString()); //find the reversed number
        return result>Integer.MAX_VALUE?0:result<Integer.MIN_VALUE?0:(int)result;//return 0 if it overflows integer else convert it to int and return 
    }
}
