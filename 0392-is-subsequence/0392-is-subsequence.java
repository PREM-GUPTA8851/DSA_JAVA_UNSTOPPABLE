class Solution {
    public boolean isSubsequence(String s, String t) {

        // i -> s ko traverse karega
        // j -> t ko traverse karega
        int i = 0, j = 0;

        // jab tak dono strings ke andar hain
        while (i < s.length() && j < t.length()) {

            // character match hua
            if (s.charAt(i) == t.charAt(j)) {
                i++; // s ka next character
            }

            // t hamesha aage badhega
            j++;
        }

        // agar s ke saare characters match ho gaye
        return i == s.length();
    }
}