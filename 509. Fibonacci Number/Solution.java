class Solution {
    static List<Integer> li=new ArrayList<>(List.of(0,1));
    static int length=2;
    public int fib(int n) {
      
        // if(n<= 1){
        //     return n;
        // }    
        // return fib(n-1)+fib(n-2);
        
          if(n <=length-1){
            return li.get(n);
        } else if (n<=1) {
            return n;
        } else{
            li.add(fib(n-1)+fib(n-2));
            length+=1;
            return li.get(n);
        }
    }
}
