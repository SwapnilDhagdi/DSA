/*
example PAYPALISHIRING numsRows 4
String[
 Str[0]     P     A     H    N
 str[1]     A  P  L  S  I  I  G
 str[2]     Y     I     R
]
interate over the string s  and keep adding the charAt[i] at the Stringarray[index]
at the end, append string array to a single array and return 
*/

class Solution {
  public String convert(String s, int numRows) {
        if(numRows==1) return s;

        
        boolean downward=true; // for tracking the direction of appending character 

        int i=0,k=0;
        String [] result=new String[numRows];
        for(int a=0;a<numRows;a++){
            result[a]="";
        }
        while(k!=s.length()){
            if(downward){
                result[i]+=s.charAt(k);
                i++;k++;
                if(i==numRows){
                    i-=2;
                    downward=false;
                }
            }
            else{
                result[i]+=s.charAt(k);
              k++;i--;
                if(i==-1){
                    i+=2;
                    downward=true;
                }
            }
        }
        String res="";
        for(String str:result){
           res+=str;
        }
        return res;
    }
}
