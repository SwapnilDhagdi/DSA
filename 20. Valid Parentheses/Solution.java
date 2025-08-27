class Solution {
    public boolean isValid(String s) {
        if(s.length()==0)return true;
        if(s.length()==1)return false;
       char[] c=s.toCharArray();
        Deque<Character> stack=new ArrayDeque<>();
        for(char ch:c){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                if(ch==')' && !stack.isEmpty()){
                    if(stack.pop()!='(')return false;
                }else if(ch=='}' && !stack.isEmpty()){
                    if(stack.pop()!='{')return false;
                }else if(ch==']' && !stack.isEmpty()){
                    if(stack.pop()!='[')return false;
                }else{
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
