/* 
  eg 19 -> 1^2+9^2=82-> 68 -> 100-> 1 happy number 
  2->4->16->37->58->89->145->42->20->4 it is not and this will repeat again 

  This can be dont with slow and fast approach 

  slow will carry result of current number n digits sum 
  Fast will carry result of sum of digits which is result of sum of digit of current sum 

  if both meet and is 1 it is happy number else they are not  
*/
class Solution {
    public boolean isHappy(int n) {
        if (n==1){
            return true;
        }
        int slow=getSum(n);
        int fast=getSum(getSum(n));


        while(true){
            if(slow == fast){
                break;
            }
            slow=getSum(slow);
            fast=getSum(getSum(fast));
        }
        if(slow == 1){
            return true;
        }
        return false;
    }
    public int getSum(int num){
        int sum=0;

        while(num>=10){
            sum+=  Math.pow((num % 10),2);
            num /= 10;
        }
        sum+=  Math.pow((num % 10),2);
        System.out.println(sum);
        return sum;
    }

}
