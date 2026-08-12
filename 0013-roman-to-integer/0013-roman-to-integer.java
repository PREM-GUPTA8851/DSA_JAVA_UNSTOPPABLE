class Solution {
    public int romanToInt(String s) {
        int ans = 0;
// MCMXCIV
        for(int i = 0; i < s.length(); i++){
            char left = s.charAt(i);
            // left = L 
        // main logic is left wala chota ho right wale se to ans m subtract kr denge 
        if(i + 1 < s.length() && value(left) < value(s.charAt(i + 1)))
        ans -= value(left);
        // aur agar aesa nhi h (right wala chota h left wale se to ans m add kr denge)
        else 
            ans += value(left);
        }
        return ans;
    }
    int value(char ch){
            if(ch == 'I') return 1;
            if(ch == 'V') return 5;
            if(ch == 'X') return 10;
            if(ch == 'L') return 50;
            if(ch == 'C') return 100;
            if(ch == 'D') return 500;
            if(ch == 'M') return 1000;

        return 0;
    }
}