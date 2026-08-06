/* 
  intput:- [[1,3],[2,6],[8,10],[15,18]]

  as they almost represnt a number like scenario 
  and a number line is naturally ascending going from left to right 

  so first we will sort the sequence in ascending by comparing 0th element of each sub array 

  then if the 1nt element of prev subarray is >= 0th element of current subarray that means they can be merged 

  else they cannot be merged and need to add them to sol 

*/ 
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {

            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            }else {
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
