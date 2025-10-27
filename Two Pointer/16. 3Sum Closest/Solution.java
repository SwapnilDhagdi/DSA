/*Two pointer approach  O(n)*/
//the approach is little bit similar  to 3Sum problem 
//in a sorted array 
// nums[1]+nums[2]+nums[3] <- currentsum 
// if the currentSum is less than target we need to increase the sum(left++) if less than target we need to decrese the sum (right--) else they are equaL return the num 
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[2];// calculate inital sum
        
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right) {
                int currentSum=nums[i]+nums[left]+nums[right];
                if(Math.abs(currentSum-target)<Math.abs(closestSum-target)){ // we need the abs differece between currentSum and target as less as posible 
                    closestSum=currentSum;
                    if(Math.abs(currentSum-target)==0){
                        return closestSum;
                    }
                }
                if(currentSum > target){ //if the currentSum > target decrease the sum 
                    
                    right--;
                }else if(currentSum < target){ // else if increase the sum 
                    left++;
                }else{ // they are equal 
                    return currentSum;
                }
            }

        }

        return closestSum;
    }
}
