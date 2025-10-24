/* Sliding window approach  */
/* initally calculate the sum>=target which would be initial window size  */
/* once the sum>=target try to reduce it by subtracting the left most element from the sum untill sum>=target while keeping track of minimum window size by Math.min and i-left */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=Integer.MAX_VALUE;
        int sum=0,left=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                len=Math.min(len,i-left);
                sum-=nums[left++];
            }
        }
        if(len==Integer.MAX_VALUE){
            return 0;
        }
        return len+1;
    }
}
