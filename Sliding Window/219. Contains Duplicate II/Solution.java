/*Sliding Window O(n)*/
// we will keep a set to keep track of element that are inside the window 
//window length should be max k 

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;//edge case
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {// if right element is already present in the set that means surey value of right-left would be <=K cause the window size we kept is max k
                return true;
            }
            window.add(nums[i]); //add the element 
            if (i >= k) { //this is to manage the edge case 
                window.remove(nums[i - k]);// remove last element of current window 
            }
        }
        return false;
    }
}
