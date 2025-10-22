/* using another array not recomended */
//it uss a saperate array to store the elent present at position i+k which then replaced by the current ith element 
class Solution {
    public void rotate(int[] nums, int k) {
   
        int length=nums.length;
        int turns=k%length;
        
        Integer [] temp=new Integer[length];
        for(int i=0;i<length;i++){
            if(temp[i]==null){//if the element is not present it will update the temp array  replace value by nums value
                temp[(i+k)%length]=nums[(i+k)%length];
                nums[(i+turns)%length]=nums[i];
            }else{// if the element is presen in temp it will update temp array and replace next value by temp value
                temp[(i+turns)%length]=nums[(i+k)%length];
                nums[(i+turns)%length]=temp[i];
            }
        }
    }
}

//secound approach using a 2nd array to store new sequence of the array and then copying it back to original nums array 
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int turns = k % length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int newPosition = (i + turns) % length;
            result[newPosition] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, length);
    }
}
