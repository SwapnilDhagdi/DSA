class Solution {
    static List<Integer> li=new ArrayList<>(List.of(1,2));

    public int climbStairs(int n) {
        if(n<=2) return n;
        if(n<=li.size()){
            return li.get(n-2)+li.get(n-3);
        }
        li.add(climbStairs(n-1)+climbStairs(n-2));
        return li.get(n-1);
    }
}
