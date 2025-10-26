/*Three pointer approach*/
//if nums[i]+nums[left]+nums[right]==0 
//that means nums[left]+nums[right]==-nums[i]
//we will first select i based on that run loop to find left and right 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result =new ArrayList<>();
       Arrays.sort(nums);//sort the array to ascending order
       for(int i=0;i<nums.length-2;i++){ 
            if(nums[i]>0){ // in an ascending ordered array inital index nums is greater than 0 that means rest number can never add up to 0 
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){ // to avoid duplicates
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            int target=-nums[i];
            while(left<right){//two pointer approach 
                if(nums[left]+nums[right]=target){//if left and right add upto target add to list
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){ // skip duplicates 
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }else if(nums[left]+nums[right]<target){ // if the addition is less than target me need bigger number
                    left++;
                }else{
                    right--;
                }
            }
       }
       return result;
    }
}
