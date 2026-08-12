class Solution {
    public String longestCommonPrefix(String[] strs) {
// strs = ["interview", "internet", "internal", "into"] --> o/p --> int
    String prefix = strs[0];
    // prefix = interview // first word pkda 
    // Pehli string ko baaki sab strings se compare karenge
    for (int i = 1; i < strs.length; i++) {

    // Jab tak current string prefix se start nahi hoti,
    // prefix ka last character remove karte jao
    while (!strs[i].startsWith(prefix)) {
        // internet.startswith(interview) // false
        // internet.startswith(intervie) // false
        // internet.startswith(intervi) // false
        // internet.startswith(interv) // false
        // internet.startswith(inter) // True

        // internal.startswith(inter) // true
        // into.startswith(inter) // 
        prefix = prefix.substring(0, prefix.length() - 1);
        // prefix = interview.substring(0, 8) // intervie
        
    }
}

        return prefix;
    }
}