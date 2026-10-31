class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Example:
        // s1 = "ab", s2 = "eidbaooo"
        // s1 ke permutations = "ab", "ba"
        // Check karna hai ki s2 mein koi permutation present hai ya nahi.

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Har character ki frequency store karenge.
        // Index: a = 0, b = 1, c = 2 ... z = 25

        for (int i = 0; i < s1.length(); i++) {

            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;

            // i = 0:
            // s1.charAt(0) = 'a' -> freq1[a] = 1
            // s2.charAt(0) = 'e' -> freq2[e] = 1
            //
            // i = 1:
            // s1.charAt(1) = 'b' -> freq1[b] = 1
            // s2.charAt(1) = 'i' -> freq2[i] = 1
            //
            // freq1: a=1, b=1
            // freq2: e=1, i=1
            // Initial window = "ei"
        }

        // Sliding Window:
        // Window ka size s1.length() = 2 hi rahega.

        for (int i = s1.length(); i < s2.length(); i++) {

            if (java.util.Arrays.equals(freq1, freq2)) {
                return true;
            }

            // i = 2:
            // Current window = "ei"
            // freq1 != freq2 -> false
            //
            // Add s2.charAt(2) = 'd'
            // freq2[d]: 0 -> 1
            //
            // Remove s2.charAt(2 - 2) = 'e'
            // freq2[e]: 1 -> 0
            // Next window = "id"

            // i = 3:
            // Current window = "id"
            // freq1 != freq2 -> false
            //
            // Add s2.charAt(3) = 'b'
            // freq2[b]: 0 -> 1
            //
            // Remove s2.charAt(3 - 2) = 'i'
            // freq2[i]: 1 -> 0
            // Next window = "db"

            // i = 4:
            // Current window = "db"
            // freq1 != freq2 -> false
            //
            // Add s2.charAt(4) = 'a'
            // freq2[a]: 0 -> 1
            //
            // Remove s2.charAt(4 - 2) = 'd'
            // freq2[d]: 1 -> 0
            // Next window = "ba"

            // i = 5:
            // Current window = "ba"
            // freq1: a=1, b=1
            // freq2: a=1, b=1
            // Arrays.equals() -> true
            // return true; (function yahin terminate ho jayega)

            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - s1.length()) - 'a']--;
        }

        // Agar last window tak match nahi mila,
        // toh final window ko bhi check karna zaroori hai.
        return java.util.Arrays.equals(freq1, freq2);
    }
}