class Solution {
    public boolean rotateString(String s1, String s2) {
        // method 1:-- 
        // if (s1.length() != s2.length()) {
        //     return false;
        // }

        // String temp = s1 + s1;
        // return temp.contains(s2);
    /*
    Input: s = "abcde", goal = "cdeab"
    
    */

        if (s1.length() != s2.length()) {
            return false;
        }
        // Method_2 :-- Implement KMP algo
        // logic is --> concatenate 1st string with itself and store in one variable
        String text = s1 + s1;
// text = abcdeabcde
// text = abcabc
        // now take an array of size pattern length bcz storing duplicates index
        int n = s1.length(); // 5 
        // abc --> 3
        int[] lps = new int[n]; // [0,0,0,0,0]
// lps[]
        int i = 1;
        int len = 0;
// y pattern k according aapn think krenge
        while(i < n){
            // ek ko one step aange point krenge bcz if vo waps repeat hua to catch kr paenge
            // agar pattern --> aab --> match at starts
            if(s2.charAt(i) == s2.charAt(len)){
                lps[i] = ++len;
                i++;
            }
            else if(len > 0){
                len = lps[len - 1];
            }
            else {
                lps[i] = 0;
                i++;
            }
        }
        // yha se apna lps array ready hoga -->[0,0,0,0,0]

        // to ab aapn text m pattern find krenge 
        i = 0;
        int j = 0;
        while(i < text.length()){
            if(text.charAt(i) == s2.charAt(j)){
                // SAME hua aange check krenge
                i++;
                j++;
// agar j pattern ki length - 1(last) index p h so check krenge 
                if(j == n){
                    return true;// that means pattern mil gya
                }
            }else if(j > 0){
                j = lps[j - 1];
            }

             else{
                i++;
            }
        }
    return false;
    }
}