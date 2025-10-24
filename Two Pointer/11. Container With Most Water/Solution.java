/*Approach Two pointer O(n) */
// the approach is to set pointer left and right on the edges 
// decrementing or incrementing the side whose height is smallest 
// and updating area
class Solution {
     public static int maxArea(int[] height) {
        if(height.length==0 || height.length==1||height==null)return 0; //edge case
         int left=0,right=height.length-1,Area=0; 
        while(left<right){
            if(Area<Math.min(height[left],height[right])*(right-left)){ // if area is gerater than the current width area of container the area will change 
                Area=Math.min(height[left],height[right])*(right-left);
            }
            if(height[left]<height[right]){ //changing the pointer location as per the largest height of pillar ,one with low height changed 
                left++;
            }else{
                right--;
            }
        }
        return Area;
    }
}
