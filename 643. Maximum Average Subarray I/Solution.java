/*calculate sum first */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length==1)return nums[0];
        double length=nums.length;
        double maxAvg=Integer.MIN_VALUE;
        double sum=0;
        
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxAvg=Math.max(maxAvg,sum); // update maxAvg in case k is equals to length of array
        for(int right=k;right<length;right++){// now apply the sliding window keeping window size k 
            sum+=nums[right];
            sum-=nums[right-k];
            maxAvg=Math.max(sum,maxAvg);//update window size as per the sum and current maxAvg
        }
        return maxAvg/k;// return average
    }
}
