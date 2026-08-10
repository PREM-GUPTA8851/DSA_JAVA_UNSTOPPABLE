class Solution {
    public boolean checkValidString(String s) {
        // we take 2 variables low and high
        // low pointing the minimum possible open bracket's
        // high pointing the maximum possible open bracket's 
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
// agar char open bracket hua tb 
            if (ch == '(') {
                low++;
                high++;
            }
            else if (ch == ')') {
                low--;
                high--;
            }
            else {
                // jb char m * milega tb
                // y to vo close bracket le lo
                low--;
                // y to vo open bracket le lo 
                high++;
            }
            if(low < 0) low = 0;
            if(high < 0) return false;
        }
        return low == 0;
    }
}