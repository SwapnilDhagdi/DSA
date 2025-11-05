/*Two pointer approach O(m+n)*/
/*There are two ways to solve this approach */
/*1. Two pointer approach */
/*It goes like we wil take two pointer and set to the end of each string respectively */
/* keep 2 variable to consider # (backspaces) of that string  */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int indexS=s.length()-1,skipS=0;// set them to end 
        int indexT=t.length()-1,skipT=0;

        while(indexS>=0 || indexT>=0){
            while(indexS>=0){// this will find the first index of string s where is character is not backspaced
                int charS=s.charAt(indexS);
                if(charS=='#'){// if the character is backspace we can skip it previos character if it is not another backspace 
                    skipS+=1;
                    indexS--;
                }else if(skipS>0){// if it is not a backspace and skips>0 that means we already encountered # and need to skip this character
                    skipS--;
                    indexS--;
                }else{// if skips are 0 it is the character we need to compare
                    break;
                }
            }
            while(indexT>=0){ // this will find the first index of string t where character is not backspaced -----( same as string s)
                int charT=t.charAt(indexT);
                if(charT=='#'){
                    skipT+=1;
                    indexT--;
                }else if(skipT>0){
                    skipT--;
                    indexT--;
                }else{
                    break;
                }
            }

            if(indexS>=0 && indexT>=0){ 
                if(s.charAt(indexS)!=t.charAt(indexT)){// if those two character didnot  matched we dont need to check for rest of the string  
                    return false;
                }
            }else if(indexS>=0 || indexT>=0){ // if one the string ends but the other did not them mean there will be atleast one charater remains in the string in compare other 
                return false;
            }
            
            indexS--;
            indexT--;
        }
        
    return true;
    }
}


/*Approacg 2 using StringBuilder*/
/*For this we will use 2 StringBuilder */
class Solution {
    public boolean backspaceCompare(String s, String t) {
      
        StringBuilder stringS=new StringBuilder();
        StringBuilder stringT=new StringBuilder();
      /*the main idea is to add each character to string builder and if encountered # remove the last added character */
        int S=0,T=0;// index for the s and t strings
        while(S<s.length() || T<t.length()){
            if(S<s.length()){ 
                char c=s.charAt(S++);
                if(c=='#'){ // it is # remove the character
                    if(stringS.length()!=0){
                        stringS.deleteCharAt(stringS.length()-1);
                    }
                }else{// else append it 
                    stringS.append(c);
                }
            }
            if(T<t.length()){ //same as S string
                char c=t.charAt(T++);
                if(c=='#'){
                    if(stringT.length()!=0){
                        stringT.deleteCharAt(stringT.length()-1);
                    }
                }else{
                    stringT.append(c);
                }
            }
        }
        return stringT.toString().equals(stringS.toString());// in the end if both strings matched return true else false
    }
}
