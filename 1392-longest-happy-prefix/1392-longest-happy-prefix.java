class Solution {
    public String longestPrefix(String s) {

        // Example: s = "abab"
        // m = 4
        int m = s.length();

        int[] lps = new int[m];

        // Step 1: LPS array banana
        int len = 0;
        int i = 1;

        while (i < m) {

            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else if (len != 0) {
                len = lps[len - 1];
            }
            else {
                lps[i] = 0;
                i++;
            }
        }

        // LPS = [0, 0, 1, 2]
        // Last LPS value = 2
        // Prefix of length 2 = "ab"
        return s.substring(0, len);
    }
}