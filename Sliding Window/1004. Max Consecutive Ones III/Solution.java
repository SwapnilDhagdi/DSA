/*Sliding Window Approach */
/*Approach 1 O(n)*/
// The approach is to skip the non 1 number untill k>0 , if k becomes less than or equal to 0 that means the windowLength has reached its maximum and you need shorten it length from the left size 
// while shorting it dont increment the right as it would lead to missing the case if nums[left] contains 1 
class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowLength=0,maxLength=Integer.MIN_VALUE,left=0,right=0;
        while(right<nums.length){
            if(nums[right]==1){//increase window size
                windowLength+=1;
                right+=1;
            }else{
                if(k>0){//if encountered a non 1 number  skip till k>0
                    right+=1;
                    k-=1;
                    windowLength+=1;
                }else{//if k becomes <=0 reduce windoew size and only increament k if the left number is not 1 
                    if(nums[left]!=1){
                        k+=1;
                    }
                    left+=1;
                    windowLength-=1;
                }
            }
            maxLength=Math.max(maxLength,windowLength);
        } 
        return maxLength;
    }
}
