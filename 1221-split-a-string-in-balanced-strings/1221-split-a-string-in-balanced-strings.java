class Solution {
    public int balancedStringSplit(String s) {

        int balance = 0;
        int count = 0;

        // Dry Run : s = "RLRRLLRLRL"
        //
        // R  L  R  R  L  L  R  L  R  L
        // +1 -1 +1 +1 -1 -1 +1 -1 +1 -1
        //
        // balance: 1  0  1  2  1  0  1  0  1  0
        // count:   0  1  1  1  1  2  2  3  3  4
        //
        // Jab balance == 0 hota hai, ek balanced
        // substring mil jaati hai aur count increase hota hai.

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'R') {
                balance++;  // R mila toh +1
            } else {
                balance--;  // L mila toh -1
            }

            if (balance == 0) {
                count++;    // Ek balanced string complete
            }
        }

        return count; //  4
    }
}