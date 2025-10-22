// the approach is to traverse the array from left and from the right at a time and calculation the product what ever the max value get update the product 
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1)return nums[0];
        int left=0;
        int right=nums.length-1;
        int leftProduct=1;
        int rightProduct=1;
        int product=0;
        for(int i=0;i<nums.length;i++){
            leftProduct*=nums[left];
            rightProduct*=nums[right];
            left++;
            right--;
            product=Math.max(product,Math.max(rightProduct,leftProduct));
            if(leftProduct==0){
                leftProduct=1;
            }
            if(rightProduct==0){
                rightProduct=1;
            }
        }
        return product;
    }
}
