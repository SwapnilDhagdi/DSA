/*Sliding Window O(lengthOfword*s)*/

//The approach is to use 2 for loop 1 that iterates over the wordLen this is to ensure if there is any irregular word present 
//and and inner for loop that starts from out's i and increament wordLen 
// if the subString right,right+wordLen is present in tagetMap increment wordfind 
// if word find becomes equal to wordsLen(*the array*) that mean the current window has the element its left index considered and left is incremented to left+=wordLen
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordsLen=words.length,wordLen=words[0].length(),sLen=s.length();
        int totalLen = wordsLen * wordLen; 
        Map<String,Integer> targetMap=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            targetMap.put(words[i],targetMap.getOrDefault(words[i],0)+1);
        }
        for (int i = 0; i < wordLen; i++) { //ex word ,aWord,abWord,abcWord ,it can consider all these possibilities 
            Map<String, Integer> currentWindowMap = new HashMap<>();
            int wordsFound = 0;
            int left = i; 

            for (int right = i; right <= sLen - wordLen; right += wordLen) {//next right+wordLen is taken
                String newWord = s.substring(right  right + wordLen);
                if (targetMap.containsKey(newWord)) {//it is present in map 
        
                    currentWindowMap.put(newWord, currentWindowMap.getOrDefault(newWord, 0) + 1);//increment it 
                    wordsFound++;
                    while (currentWindowMap.get(newWord) > targetMap.get(newWord)) {//to remove duplicates ex s= wordgoodgoodgoodbestword words=["word","good","best","word"]  that 3*good is redundant
                        String oldWord = s.substring(left, left + wordLen);
                        currentWindowMap.put(oldWord, currentWindowMap.get(oldWord) - 1);
                        wordsFound--;
                        
                        left += wordLen;
                    }
                    if (wordsFound == wordsLen) { //if wordfound==wordsLen that mean the current window has excatly equal num of element 
                        
                        result.add(left);// add left
                    
                        String oldWord = s.substring(left, left + wordLen); //remove old left,left+wordLen word
                        currentWindowMap.put(oldWord, currentWindowMap.get(oldWord) - 1);
                        wordsFound--; 
                        left += wordLen;
                    }
                } else {
                    
                    currentWindowMap.clear();//if the word is not in targetMap() that means the previos word in the current window is worth less so left should incremnt beyon the misMatched word 
                    wordsFound = 0;
                    left = right + wordLen; 
                }
            }
        }
        return result;
    }
}
