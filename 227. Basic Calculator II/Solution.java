//Approach 1
/*Less Recomended Approach  infix to postfix approach */

class Solution {

    public int calculate(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        String postfix = infixToPostfix(s);
        return evaluatePostfix(postfix);
    }
    private int priority(char op) {
        return switch(op){
            case '/', '*' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }
    private String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {

                StringBuilder number = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number.append(s.charAt(i));
                    i++;
                }
                i--; 
                
                postfix.append(number.toString()).append(" ");

            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }
    private int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            
            char firstChar = token.charAt(0);

            if (Character.isDigit(firstChar)) {
                stack.push(Integer.parseInt(token));
            } else {
            
                int num2 = stack.pop();
                int num1 = stack.pop(); 
                stack.push(calculateExpression(num1, num2, firstChar));
            }
        }
        
        return stack.pop();
    }
    private int calculateExpression(int num1, int num2, char op) {
        return switch(op){
            case '/' -> num1 / num2;
            case '*' -> num1 * num2;
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            default -> 0; 
        };
    }
}

//Approach 2
/*Single pass Approach */
/*collect the entire number between operatora and push it as once in stack to integer then as per operator push the output */
public class Solution {
public int calculate(String s) {
    int len;
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    for(int i=0;i<len;i++){
        char c=s.charAt(i);
        if(Character.isDigit(c)){
            num = num*10+s.charAt(i)-'0';
        }
        if((!Character.isDigit(c) &&' '!=c) || i==len-1){
            if(c=='-'){
                stack.push(-num);
            }
            if(c=='+'){
                stack.push(num);
            }
            if(c=='*'){
                stack.push(stack.pop()*num);
            }
            if(c=='/'){
                stack.push(stack.pop()/num);
            }
            c = s.charAt(i);
            num = 0;
        }
    }

    int result = 0; //at the end add everything together
  
    for(int num:stack){
        result += num;
    }
    return result;
    }
}
