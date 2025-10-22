// The first appreoach is to squared each element and then sort it it which is O(n+nlogn) i.e O(nlogn);
class Solution {
    public int[] sortedSquares(int[] nums) {
       for(int num=0;num<nums.length;num++){
            nums[num]=nums[num]*nums[num];
        }
       Arrays.sort(nums);
       return nums;
   }
}
//2nd approach is a 2 pointer approach (only beacause it is sorted array) keep 1 pointer at left and another at right 
//make a new array the squared numbered which is greater from the left side or right side will be placed at the last of new array return the new array  
class Solution {
    public int[] sortedSquares(int[] nums) {
    int [] result=new int[nums.length];
    int left=0;
    int right=nums.length-1;
    for(int i=nums.length-1;i>=0;i--){
        int leftSquared=nums[left]*nums[left];
        int rightSquared=nums[right]*nums[right];
        if(leftSquared>rightSquared){
            result[i]=leftSquared;
            left++;
        }else{
            result[i]=rightSquared;
            right--;
        }
    }
       return result;
   }
}
