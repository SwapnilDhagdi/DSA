/*Sliding Window Approach O(n)*/
// the minimum window size will be till the product became greater than k or the target
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       int count=0,product=1,left=0;
       if(k<=1){
        return 0;
       }
       for(int right=0;right<nums.length;right++){
        product*=nums[right];// till then calculate product 
        while(product>=k ){//if the product becames greater than target
            product/=nums[left++];// decrease the window size
        }
        count+=right-left+1;// the formula to calculate count 
       }
        return count;
    }
}
