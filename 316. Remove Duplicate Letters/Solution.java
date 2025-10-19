/*it is a 2 step approach*/
public String removeDuplicateLetters(String s) {
        if(s.length()==1)return s;
        StringBuilder stringBuilder=new StringBuilder();
        Set<Character> seenChar=new HashSet<>();//to keep track of elements that we already encountered
        Map<Character,Integer> lastOccurance=new HashMap<>();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){ //step 1 calculate the last occuracnce of each element 
            lastOccurance.put(s.charAt(i),i);
        }

        for(int i=0;i<s.length();i++){
            char currentChar=s.charAt(i);
            if(seenChar.contains(currentChar)){//if we have already seen an element we can skip it as we dont need to push it in stack
                continue;
            }

            while(!stack.isEmpty()&&stack.peek()>currentChar&&lastOccurance.get(stack.peek())>i){  //the element is bigger that the current top elemt of stack we will pop till we do not find elemt which is smaller than currentChar or is occuranance is not present later in the string
                seenChar.remove(stack.pop());//we also remove it from the set 
            }
            stack.push(currentChar);
            seenChar.add(currentChar);
        }
        for(Character character:stack){
            stringBuilder.append(character); 

        }
        return stringBuilder.toString();
    }
