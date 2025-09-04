class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.replace(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int i: map.keySet()){
            if(map.get(i)!=2){
                return i;
            }
        }
        return 0;
    }
}
