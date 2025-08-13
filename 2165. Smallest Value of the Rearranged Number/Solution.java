class Solution {
    public long smallestNumber(long num) {

        StringBuilder result=new StringBuilder();
        int count=0;
        List<Long> set=new ArrayList<>();
        if(num >0) {
            while (num / 10 != 0) {
                long number = num % 10;
                set.add(number);
                num /= 10;
            }

            set.add(num);
            set.sort(Long::compareTo);
            while (set.contains((long) 0)) {
                set.remove((long) 0);
                count++;
            }
            for (int i = 0; i < set.size(); i++) {
                if (i == 1) {
                    while(count !=0){
                        result.append("0");
                        count--;
                    }
                    
                    result.append(set.get(i));
                }else {
                    result.append(set.get(i));
                }
            }
             while(count !=0){
                        result.append("0");
                        count--;
            }

        }else if(num==0){
            return 0;
        }
        else{
            num=Math.abs(num);

            while (num / 10 != 0) {
                long number = num % 10;

                set.add(number);
                num /= 10;
            }
            set.add(num);
            set.sort((a,b)->{
                if(a<b) return 1;
                if(a>b) return -1;
                return 0;
            });

            while (set.contains((long) 0)) {
                set.remove((long) 0);
                count++;
            }

            for (int i = 0; i < set.size(); i+=1) {

                if(i==0){
                    result.append('-');
                    result.append(set.get(i));
                }else{
                    result.append(set.get(i));
                }
            }
             while(count !=0){
                        result.append("0");
                        count--;
            }
        }

        return Long.parseLong(result.toString());
    }
}
