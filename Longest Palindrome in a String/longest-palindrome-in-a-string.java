
class Solution {
    static String longestPalindrome(String s) {
        // longest palimdrome substring 
        int n = s.length();
        if(n <= 1){
            return s;
        }
        
        int start = 0;
        int maxLength = 1;
        // used the concept expand around centre
        for(int i = 0; i < n; i++){
            
        // substring --> odd_length  --> aba
        int left = i;
        int right = i;
        
    while((left >= 0 && right < n) && (s.charAt(left) == s.charAt(right))){
            if(right - left + 1 > maxLength){
                maxLength = right - left + 1;
                start = left;
            }
            
            left--;
            right++;
    }
        // even length --> abba
     left = i;
     right = i + 1;
    while((left >= 0 && right < n) && (s.charAt(left) == s.charAt(right))){
            if(right - left + 1 > maxLength){
                maxLength = right - left + 1;
                start = left;
            }
            left--;
            right++;
    }
    
        }
        return s.substring(start, start + maxLength);
    }
}