
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        // Agar p ki length s se badi hai,
        // toh anagram possible nahi hai
        if (m > n) {
            return ans;
        }

        // p aur current window ki character frequency
        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        // p = "abc"
        // pFreq mein a, b, c ki frequency store hogi
        for (int i = 0; i < m; i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        // First window ki frequency banao
        // s = "cbaebabacd"
        // p = "abc"
        // First window = "cba"

        for (int i = 0; i < m; i++) {
            winFreq[s.charAt(i) - 'a']++;
        }

        // DRY RUN:
        // pFreq:   a=1, b=1, c=1
        // winFreq: a=1, b=1, c=1
        // Window "cba" anagram hai
        // ans = [0]

        if (Arrays.equals(pFreq, winFreq)) {
            ans.add(0);
        }

        // Sliding window: ek character remove,
        // aur ek naya character add karenge
        for (int i = m; i < n; i++) {

            // Window se leftmost character remove karo
            char removeChar = s.charAt(i - m);
            winFreq[removeChar - 'a']--;

            // Window mein naya character add karo
            char addChar = s.charAt(i);
            winFreq[addChar - 'a']++;

            // Current window ka starting index
            int start = i - m + 1;

            // DRY RUN:
            // i=3: window "bae"
            // ans = [0]
            //
            // i=4: window "aeb"
            // ans = [0]
            //
            // i=5: window "eba"
            // ans = [0]
            //
            // i=6: window "bab"
            // ans = [0]
            //
            // i=7: window "aba"
            // ans = [0]
            //
            // i=8: window "bac"
            // Characters a, b, c ki frequency 1 hai
            // Match! ans = [0, 6]
            //
            // i=9: window "acd"
            // Match nahi hua
            // ans = [0, 6]

            if (Arrays.equals(pFreq, winFreq)) {
                ans.add(start);
            }
        }

        return ans;
    }
}
