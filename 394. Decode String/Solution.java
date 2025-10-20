//2 stack approach where one stack holds the string and another stack hold the numbee
class Solution {
    public String decodeString(String s) {
        Stack<Integer> stkNum = new Stack<>();
        Stack<String> stkStr = new Stack<>();

        int currNo = 0;
        String currStr = "";

        for (Character c: s.toCharArray()){
            if (c == '['){//it it is a [ push previos number and string
                stkNum.push(currNo);
                stkStr.push(currStr);
                currNo = 0;
                currStr = "";
            }else if (c==']'){//it is a closed bracket update currStr 
                currStr = stkStr.pop() + currStr.repeat(stkNum.pop());
            }else if(Character.isDigit(c)){ // if its a digit convert it to numeric value 
                currNo = currNo*10 + c -'0';
            }else{
                currStr+=c; //else add it to the string
            }
        }
        return currStr;
    }
}
