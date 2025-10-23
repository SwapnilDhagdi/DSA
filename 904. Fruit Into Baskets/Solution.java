/*Sliding window approach */

//update the nmap every time new element come 
//if map size goes beyond 2 reduce the size till 
//reduce the element occurance untill it popped the number 
class Solution {
   public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        Map<Integer,Integer> map=new HashMap<>();
        int left=0,maxFruits=Integer.MIN_VALUE;
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            if(map.size()>2){
                while(map.size()>2){
                    int num=fruits[left++];
                    map.put(num,map.get(num)-1);
                    if(map.get(num)<=0){
                        map.remove(num);
                    }
                }
                maxFruits=Math.max(maxFruits,right-left+1);
            }else{
                maxFruits=Math.max(maxFruits,right-left+1);
            }
        }
        
        return maxFruits;
    }
}
