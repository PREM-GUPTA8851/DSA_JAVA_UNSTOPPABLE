class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base Case
        // Agar word2 khali hai to word1 ke saare characters delete karne padenge.
        //
        // dp[0][0] = 0
        // dp[1][0] = 1
        // dp[2][0] = 2
        // ...
        // dp[n][0] = n

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // Agar word1 khali hai to word2 ke saare characters insert karne padenge.
        //
        // dp[0][0] = 0
        // dp[0][1] = 1
        // dp[0][2] = 2
        // ...
        // dp[0][m] = m

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Example
        //
        // word1 = "horse"
        // word2 = "ros"

        // i = 1
        // i = 2
        // i = 3
        // i = 4
        // i = 5

        for (int i = 1; i <= n; i++) {

            // j = 1
            // j = 2
            // j = 3

            for (int j = 1; j <= m; j++) {

                // Compare current characters

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    // Same character
                    //
                    // Example
                    // r == r
                    //
                    // No operation needed
                    //
                    // dp[i][j] = dp[i-1][j-1]

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    // Characters different
                    //
                    // Example
                    // h != r
                    //
                    // Three choices

                    // Insert
                    //
                    // dp[i][j-1]

                    int insert = dp[i][j - 1];

                    // Delete
                    //
                    // dp[i-1][j]

                    int delete = dp[i - 1][j];

                    // Replace
                    //
                    // dp[i-1][j-1]

                    int replace = dp[i - 1][j - 1];

                    // Take minimum operation

                    dp[i][j] = 1 + Math.min(insert,
                                    Math.min(delete, replace));
                }
            }
        }

        // Final Answer
        //
        // dp[n][m]
        //
        // dp[5][3]
        //
        // = 3

        return dp[n][m];
    }
}