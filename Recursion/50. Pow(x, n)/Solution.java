/*
  This has two case if the powering number is -Ve or +ve if -ve answer shoule be 1/answer and if negative it would be answer

  1. We wil check for negative condition if meet will change number to 1/x and N to -n

  we will only find power of half of the number and will just square it if partiotion is even else square * x if odd 

*/

class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
        }
        return fastPow(x, n);
    }
    
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);
       return n%2==0 ?half* half :half*half*x;
    }
}
