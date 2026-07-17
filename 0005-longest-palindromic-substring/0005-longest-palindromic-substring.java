class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        if (n <= 1) return s;

        int start = 0;      // Starting index of longest palindrome
        int maxLen = 1;     // Current maximum length

        // Check every character as center
        // i = 0
        // i = 1
        // i = 2
        // i = 3
        // i = 4

        for (int i = 0; i < n; i++) {

            // ---------------- ODD LENGTH ----------------
            int left = i;
            int right = i;

            // s = "babad"

            // i = 0
            // left = 0 , right = 0

            // i = 1
            // left = 1 , right = 1

            // i = 2
            // left = 2 , right = 2

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // i = 0
                // left = 0 right = 0
                // length = 1

                // i = 1
                // left = 1 right = 1
                // length = 1

                // left = 0 right = 2
                // substring = "bab"
                // length = 3

                // i = 2
                // left = 2 right = 2
                // length = 1

                // left = 1 right = 3
                // substring = "aba"
                // length = 3

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    // maxLen = 3

                    start = left;
                    // start = 0
                }

                left--;
                // left = -1
                // left = -1
                // left = 0

                right++;
                // right = 1
                // right = 3
                // right = 4
            }

            // ---------------- EVEN LENGTH ----------------

            left = i;
            right = i + 1;

            // i = 0
            // left = 0 right = 1

            // i = 1
            // left = 1 right = 2

            // i = 2
            // left = 2 right = 3

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // "babad" me koi even palindrome nahi milega

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLen);

        // start = 0
        // maxLen = 3

        // substring(0,3)

        // Answer = "bab"
    }
}