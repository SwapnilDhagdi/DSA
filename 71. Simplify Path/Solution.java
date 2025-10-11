/*The approach starts by dividing string path passing regrex as / */
class Solution {
    public String simplifyPath(String path) {
        if(path.length()==0)return "";
        if(path.length()==1)return path;
        String[] str=path.split("/");//divide string by /

        StringBuilder result=new StringBuilder("");
        Stack<String> stack=new Stack<>();
        for(String s:str){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(s.equals("")||s.equals(".")){} //filter out "" or . out 
            else{
                stack.push(s);//else push it in stack
            }
        }
        
        Stack<String> resultStack=new Stack<>();//reverse stack

        while(!stack.isEmpty()){
            resultStack.push(stack.pop());
        }
        while(!resultStack.isEmpty()){
            result.append("/").append(resultStack.pop());//append stack content to string 
        }
        if(result.length()==0)return "/"; //if there is no string in result return /
        return result.toString();
    }
}
