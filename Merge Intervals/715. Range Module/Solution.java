/*
  For This problem we have to perform 3 actions 
  1. Add range
  2. if the range is present 
  3. remove a range 

  soln 
  1 -> To add a range we will take the same method as problem 57. Insert interval 
      first run a loop unitll we encounter the intersection between interval and the interval that is going to add, while interval[1] < left 
      once the intersection found run loop newLeft=Math.min(newLeft,list.get(i)[0]); newRight=Math.max(newRight,list.get(i)[1]); untill interval[0] <= right 
      the add the rest of them 
  2 -> for the query range 
      we have to just verify weather the range left and right lies inside a interval range because the intervals are already sorted due to add range 
  3 -> for the remove range 
      just like 'add range' we will add intervals untill we encounter a intersection between interval and to remove interval 
      once found take interval[0] and left of the intersection if interval[0] <= left and if interval[1] >= right then right, interval[1]
      Then add rest of them to result
*/

class RangeModule {

    List<int[]> list;
    public RangeModule() {
        list=new ArrayList<int[]>();
    }
    
    public void addRange(int left, int right) {
        int length=list.size(),i=0;
        List<int[]> result= new ArrayList<int[]>();

        if(length==0){
            list.add(new int[]{left,right});
            return;
        }

        while(i < length && list.get(i)[1] < left){
            result.add(list.get(i));
            i++;
        }
        int newLeft=left;
        int newRight=right;
        while(i<length && list.get(i)[0] <= right  ){
            newLeft=Math.min(newLeft,list.get(i)[0]); 
            newRight=Math.max(newRight,list.get(i)[1]);
            i++;
        }
        result.add(new int[]{newLeft,newRight});

        while(i < length){
            result.add(list.get(i++));
        }
        list=result;
    }
    
    public boolean queryRange(int left, int right) {
        for(int i=0;i<list.size();i++){
            int[] interval=list.get(i);
            if(interval[0] <= left  && right<=interval[1]){
               return true;
            }
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        List<int[]> result=new ArrayList<int[]>();
        int i=0,length=list.size();
        while(i<length && list.get(i)[1] < left){
            result.add(list.get(i++));
        }
       while(i < length && right > list.get(i)[0]){

        int [] interval =list.get(i);

        if(interval[0] < left ){
            result.add(new int[]{interval[0],left});
        }

        if(interval[1] > right){
            result.add(new int[]{right,interval[1]});
        }

        i++;
       }

       while(i<length){
        result.add(list.get(i++));
       }
        list=result;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
