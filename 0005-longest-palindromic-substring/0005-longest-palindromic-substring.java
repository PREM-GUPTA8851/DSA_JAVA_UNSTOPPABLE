class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

    int start = 0;
    int maxLen = 1;
// using the algo expand around centre 
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            int len1 = expand(s, i, i);

            // Even-length palindrome
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);
// if length greater than maxlength 
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }
// expand around centre
 
// bab--> i = 1 point at a 
// a == a--> left --; right++; --> b == b 
// left-- --> left = -1; 
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
