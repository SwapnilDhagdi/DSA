
class Solution {
   public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        long result = 0;
        boolean negative = false;
        while (i < s.length() && s.charAt(i) == ' ') { // ignoring white spaces 
            i++;
        }
         if (i < s.length()) { // checking for the sign
            if (s.charAt(i) == '-') {
                negative = true;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {   
            result = result * 10 +  s.charAt(i) - '0'; // addign digit to the result 
            if (negative) {
                if (-result < Integer.MIN_VALUE) { // checking if the result exceeds the Integer.maxvalue or minvalue
                    return Integer.MIN_VALUE;
                }
            } else {
                if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            i++;
        }
        return negative?(int)-result:(int)result; // if the integer not exceesd max value then return result accn to negative 
     
    }
}

// Integer limit 2^-31 <= n<=2^31 -1  i.e -2147483648<=n<=2147483647 
