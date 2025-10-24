/*Two pointer Approach */
// the idea is to start from the mid gradually expanding both the side till the condition invalids( out of range 0 or length , left and right are not equal)
// for both even and odd string
class Solution {
    private int start = 0; 
    private int maxLength = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }
    private void expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { // start from the center(assumption) and expanding bothside
            l--;
            r++;
        }
        int currentLength = r - l - 1; //calculate length
        if (currentLength > maxLength) { // update maxlength 
            maxLength = currentLength;
            start = l + 1;// set the start
        }
    }
}