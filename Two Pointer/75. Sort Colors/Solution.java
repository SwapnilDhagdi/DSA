/*This problem has 2 ways to solve this problem*/
/*Two pointer Approach O(n)*/
  //Approach is to travers through array carrying 3 pointers one points to left points to 0 mid points to 1 and right points to 2  as per the position 0 1 2  
class Solution {
    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1,mid=0;
        while(mid<=right){
            if(nums[mid]==0){ // if the number is 0 swap it with left
                int temp=nums[mid];
                nums[mid++]=nums[left];
                nums[left++]=temp;
            }else if(nums[mid]==1){ //if it is 1 let it be caus it is at its place 
                mid+=1;
            }else{// if it is 2 swap it with right 
                int temp=nums[right];
                nums[right--]=nums[mid];
                nums[mid]=temp;
            }
        }
    }
}

/*Approach 2 2 pass Approach O(n+n)*/
/*carry a map and fill it with number of occurach of element in the array then replace each value of array with the numbers 012 as per sequence*/
class Solution {
    public void sortColors(int[] nums) {
         Map<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<nums.length;i++){//calculating frequency
             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
         }
         int index=0;
         int [] sample=new int[]{0,1,2}; //a sample array iterate
         for(int i:sample){
             for(int j=0;j<map.getOrDefault(i,0);j++){
                 nums[index++]=i;//replacing main array values 
             }
         }
       
    }
}
