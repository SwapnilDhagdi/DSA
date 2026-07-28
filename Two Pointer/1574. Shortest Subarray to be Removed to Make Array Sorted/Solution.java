/*
  We have to find the shortest sub array length which if removed will result in formation of sorted array 
  i.e prefix sorted array+unsorted Subarray+suffix sorted array 

  1. we will find prefix sub array it is idicated by a pointer 
  2. we will find suffix array it is indicated by another array 

  The array bettween these 2 is unsorted 

  so a loop will run from start of array (i) to left pointer position comparing array element position at right pointer(j) 

  checking that arr[i]<=arr[j] everything is correct move forward i++
  if not then j++ 
  and which check calculated Math.min() for shortest subarray length

*/

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {//finding prefix 
            left++;
        }

        if (left == n - 1) {//edge case
            return 0;
        }

        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {//finding suffix
            right--;
        }

        int ans = Math.min(n - left - 1, right);//current minimum sub array length

        int i = 0, j = right;
        while (i <= left && j < n) { //comparing and updating shortest length
            if (arr[i] <= arr[j]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}
