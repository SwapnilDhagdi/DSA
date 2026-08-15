/*
    [[1,3],[6,9]], newInterval = [2,5]

    The new interval can be between two intervals we will saperate the entire list such that the starting will be non over lapping middle 
    is overlapping 
    and end is over lapping

    we will divide in 3 step 

*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int arrayIndex=0,arrayLength=intervals.length;

      /*
          Step 1 add everything to result until the newinterval not come 
      */
        while(arrayIndex < arrayLength && intervals[arrayIndex][1] < newInterval[0]){
            result.add(intervals[arrayIndex]);
            arrayIndex+=1;
        }


      /*
          Step 2 add overlapped part now takin minimum of start of interval and maximum of end of interval
      */
        while(arrayIndex<arrayLength && intervals[arrayIndex][0] <= newInterval[1]){
            newInterval[0]=Math.min(intervals[arrayIndex][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[arrayIndex][1],newInterval[1]);
            arrayIndex+=1;
        }

        //Add it
        result.add(newInterval);


        /*
          Step 3:- add everything rest the newInterval 
        */
        while(arrayIndex<arrayLength){
            result.add(intervals[arrayIndex]);
            arrayIndex+=1;
        }

      //convert back to 2D array 
        return result.toArray(new int[result.size()][]);
    }
}
