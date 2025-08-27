class Solution {
    public void moveZeroes(int[] nums) {
         int count=0;
       int j=0;
       for(int i=0;i<nums.length;i++){
           nums[j]=nums[i];
            if(nums[i]==0){
                count++;
            }else{
                j++;
            }
       }
       for(int i=0,k=nums.length-count;i<count;i++){
           nums[k]=0;
           k++;
       }
    }
}
