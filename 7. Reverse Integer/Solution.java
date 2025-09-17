/*Approach 1-O(log(x)) */
class Solution {
     public int reverse(int x) {
        long result=x<0?Long.parseLong(new StringBuilder(Integer.toString(x).substring(1)).reverse().toString())*-1:Long.parseLong(new StringBuilder(Integer.toString(x)).reverse().toString()); //find the reversed number
        return result>Integer.MAX_VALUE?0:result<Integer.MIN_VALUE?0:(int)result;//return 0 if it overflows integer else convert it to int and return 
    }
}

/* Approact 2 O(log(x))*/
class Solution {
     public int reverse(int x) {
        long result=0;
          while(x!=0){
               result=result*10+x%10; //reversing and storing the digit
               x/=10;
          }
        return result>Integer.MAX_VALUE?0:result<Integer.MIN_VALUE?0:(int)result;//return 0 if it overflows integer else convert it to int and return 
    }
}
