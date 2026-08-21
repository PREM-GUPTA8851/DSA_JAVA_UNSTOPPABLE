class Solution {
    public static int maxSubStr(String s) {
        if(s.length() % 2 != 0) return -1;
        int count = 0;
        int z = 0, o = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') z++;
            else o++;
        } 
        if(z == o) {
            for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') z++;
            else o++;
            if(z == o) count++;
        }
        return count;
        }
        
        return -1;
    }
}