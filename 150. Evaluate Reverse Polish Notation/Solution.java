/*
    a Reverse polish notation means the operands preseds the operator eg 2+3 23+ where the high priority operator like (* /) should come last 

    Time Complexity O(N)
*/
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0) return 0;
        if(tokens.length==1) return Integer.parseInt(tokens[0]); //edge cases
        Stack<Integer> stack=new Stack<>();

        for(String s:tokens){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){ // if the token is an operator it will pop last 2 integer and push the caluclated result of those 2 operand with operator 
                int num=stack.pop();
                int num1=stack.pop();
                stack.push(calculate(num,num1,s));
            }else{
                stack.push(Integer.parseInt(s));//else it will push the operand 
            }
        }
        return stack.pop();
    }
    public int calculate(int num,int num1,String operator){//to calculate 
        return switch(operator){
            case "/" -> num1/num;
            case "*" -> num*num1;
            case "+"-> num+num1;
            case "-"-> num1-num;
            default -> 0;
        };
    }
}
