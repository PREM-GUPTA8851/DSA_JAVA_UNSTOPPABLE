class Solution {
    public boolean checkValidString(String s) {
        // Dry Run
        // Input : "(*))"

        // low = Minimum possible open brackets
        // high = Maximum possible open brackets

        int low = 0;
        int high = 0;

        for(int i = 0; i < s.length(); i++){

            // i = 0
            // s.charAt(0) = '('
            // low = 1
            // high = 1

            // i = 1
            // s.charAt(1) = '*'
            // '*' -> ')' => low--
            // '*' -> '(' => high++
            // low = 0
            // high = 2

            // i = 2
            // s.charAt(2) = ')'
            // low--
            // high--
            // low = -1 -> 0
            // high = 1

            // i = 3
            // s.charAt(3) = ')'
            // low--
            // high--
            // low = -1 -> 0
            // high = 0

            // End
            // low == 0
            // Return true

            char ch = s.charAt(i);

            if(ch == '('){
                low++;
                high++;
            }
            else if(ch == ')'){
                low--;
                high--;
            }
            else{ // '*'
                low--;      // '*' as ')'
                high++;     // '*' as '('
            }

            if(low < 0)
                low = 0;

            if(high < 0)
                return false;
        }

        return low == 0;
    }
}