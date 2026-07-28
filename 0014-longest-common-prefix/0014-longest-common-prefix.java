class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        // Dry Run
        // ["flower","flow","flight"]
        //
        // prefix = "flower"

        for (int i = 1; i < strs.length; i++) {

            // i = 1
            // current = "flow"
            // flower -> flowe -> flow
            // match mil gaya, prefix = "flow"

            // i = 2
            // current = "flight"
            // flow -> flo -> fl
            // match mil gaya, prefix = "fl"

            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.length() == 0)
                    return "";
            }
        }

        // ans = "fl"
        return prefix;
    }
}