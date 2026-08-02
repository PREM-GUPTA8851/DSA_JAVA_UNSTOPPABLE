class Solution {
    public boolean checkValidString(String s) {
        // Dry Run
        // Input : "(*))"
        // input: "()"
        // Input : "(*)"

        // low = Minimum possible open brackets
        // high = Maximum possible open brackets

        int low = 0;
        int high = 0;

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);
// ch = s.charAt(0) --> "("
// ch = s.charAt(1)--> ")"

// ch = s.charAt(0) --> "("
// ch = s.charAt(1) --> "*"
// ch = s.charAt(2)--> ")"
            if(ch == '('){
                low++;
                // 1
                // 1
                high++;
                // 1
                // 1
            }
            else if(ch == ')'){
                low--;
                // 0
                // -1
                high--;
                // 0
                // 1
            }
            else{ // '*'
                low--;      // '*' as ')'
                // 0
                high++;     // '*' as '('
                // 2
            }

            if(low < 0)
                low = 0;

            if(high < 0)
                return false;
        }

        return low == 0;
    }
}