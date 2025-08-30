class Solution {
    public int mySqrt(int x) {
        int start=1,end=x,mid=0;
        if(x<2)return x;
        while(start<=end){
            mid=start+(end-start)/2;
            if((long)mid*mid>(long)x){
                end=mid-1;
            }else if(mid*mid==x){
                return mid;
            }else{
                start=mid+1;
            }
        }
        return Math.round(end);
    }
}
