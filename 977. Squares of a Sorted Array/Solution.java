class Solution {
    public int[] sortedSquares(int[] nums) {
       for(int num=0;num<nums.length;num++){
            nums[num]=nums[num]*nums[num];
        }
       Arrays.sort(nums);
       return nums;
   }
}
