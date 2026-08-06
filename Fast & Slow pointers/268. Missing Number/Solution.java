/*
  we have to find the missing number so the number must be in sequence so to find first we will sort them then check if any one is missing or not 
*/
class Solution {
    public int missingNumber(int[] nums) {
      Arrays.sort(nums);

      for(int i=0;i<nums.length;i++){
        if(i!=nums[i]){
            return i;
        }
      }
        return nums.length;
    }
}
