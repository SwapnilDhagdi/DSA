class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maximum = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
               
                left = map.get(currentChar) + 1; 
                            }

            map.put(currentChar, right);

            maximum = Math.max(maximum, right - left + 1);
        }

        return maximum;
    }
}
