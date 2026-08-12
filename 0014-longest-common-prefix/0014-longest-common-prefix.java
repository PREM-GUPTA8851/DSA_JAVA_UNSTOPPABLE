class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        // Pehli string ko baaki sab strings se compare karenge
        for (int i = 1; i < strs.length; i++) {

            // Jab tak current string prefix se start nahi hoti,
            // prefix ka last character remove karte jao
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}