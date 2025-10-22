/*Known as kadanes algorithm */
//iterate over the array if the temporary sumis greater than the global sum update it and if the temporary sum is less than 0 update it to 0   
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int maxNum=Integer.MIN_VALUE;
        int tempMax=0;
        for(int i=0;i<nums.length;i++){
            tempMax+=nums[i];
            if(tempMax > maxNum){
                maxNum=tempMax;
            }
            if(tempMax<0){
                tempMax=0;
            }
        }
        return maxNum;
    }
}
