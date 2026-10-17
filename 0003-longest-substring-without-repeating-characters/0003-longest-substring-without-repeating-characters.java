class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0 ;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++){
            // for removing or checking duplicates
            // if duplicates exists, shrink window from left
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}