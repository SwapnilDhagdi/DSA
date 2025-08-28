class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0)return 0;
        
       int j=0;
            for(int i=0;i<nums.length;i++){
                nums[j]=nums[i];
                if(nums[i]!=val){
                    j++;
                }
            }
            return j;
    }
}
