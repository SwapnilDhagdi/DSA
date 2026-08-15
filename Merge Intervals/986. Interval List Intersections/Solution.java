/*
    eg  
    
   condition 1     0---2
                      1-----------5
    condition 2             5-------9
                      0---------7
    condition 3    1----3
                            5----7
We got 3 condition either first overlaps secound or secound overlaps first 
or no over lap 

we will focus on first 2 condition 

*/

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIndex=0,secondIndex=0 ,firstLength=firstList.length,secoundLength=secondList.length;
        List<int[]> result =new ArrayList<int[]>();
        while(firstIndex < firstLength && secondIndex <secoundLength ){

            int[] first = firstList[firstIndex];
            int[] second=secondList[secondIndex];

          // if 0th indexed of first come's in between second interval 
            boolean firstOverLapsSecond = first[0] >= second[0] && first[0] <=second[1];
          // if oth index of second comes inbetween first interval 
            boolean secondOverLapsSecond = second[0] >= first[0] && second[0] <= first[1];


          // in either of the cse there is an overlap
          //interdsection is minimum and maximum 
            if(firstOverLapsSecond || secondOverLapsSecond)
            {
                result.add(
                    new int[]{
                        Math.max(
                            first[0],second[0]),
                        Math.min(
                            first[1],second[1])
                    }
                    );
            }


          //increment accordingly 
            if(first[1] > second[1]){
                secondIndex+=1;
            }else{
                firstIndex+=1;
            }
        }    
        return result.toArray(new int[result.size()][]);
    }
}
