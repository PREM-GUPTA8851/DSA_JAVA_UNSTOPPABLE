import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // Store dictionary words in HashSet for fast lookup
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();

        // dp[i] = true means s ke first i characters ko
        // dictionary words se form kar sakte hain
        boolean[] dp = new boolean[n + 1];

        // Empty string ko form karna possible hai
        dp[0] = true;

        // Har prefix ko check karenge
        for (int i = 1; i <= n; i++) {

            // Har possible split point check karo
            for (int j = 0; j < i; j++) {

                // Pehle wala part possible ho
                // aur current substring dictionary mein ho
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}