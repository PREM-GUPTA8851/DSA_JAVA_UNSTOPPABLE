class Solution {
    public String longestPrefix(String s) {
    // longest prefix suffix --> 
    // lps:-- means us length tk ki prefix aur suffix nikalini h 
    // to pehle aapn length nikal 

    
    // tc:--    a b a b a b
    // index    0 1 2 3 4 5 
    // lps      0 0 1 2 3 4
    // 0 len k lps 0 hi hota h isliye index 1 se check krenge

    // tc:--    a b a b c
    // index    0 1 2 3 4 
    // lps      0 0 1 2 
    // 0 len k lps 0 hi hota h isliye index 1 se check krenge

    int len = 0;
    int i = 1;
    int m = s.length();
    int[] lps = new int[m];
    while(i < s.length()){
        // pattern matching 
        if(s.charAt(i) == s.charAt(len)){
            lps[i] = ++len;
            i++;
        }
        else if(len != 0){
            len = lps[len - 1];
        }
        else{
            lps[i] = 0;
            i++;
        }
    }
    return s.substring(0, len);
    }
}