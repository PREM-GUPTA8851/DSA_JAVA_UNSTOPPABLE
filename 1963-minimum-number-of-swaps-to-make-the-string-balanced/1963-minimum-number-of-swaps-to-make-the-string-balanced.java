class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int maxImbalance = 0;

        // Dry run: s = "][]["
        // Initially:
        // balance = 0, maxImbalance = 0

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                // Opening bracket mila, balance increase karo
                balance++;
            } else {
                // Closing bracket mila, balance decrease karo
                balance--;
            }

            // Agar balance negative ho gaya,
            // toh maximum imbalance update karo
            maxImbalance = Math.max(maxImbalance, -balance);

            // Dry run:
            // i = 0, ch = ']'
            // balance = -1, maxImbalance = 1
            //
            // i = 1, ch = '['
            // balance = 0, maxImbalance = 1
            //
            // i = 2, ch = ']'
            // balance = -1, maxImbalance = 1
            //
            // i = 3, ch = '['
            // balance = 0, maxImbalance = 1
        }

        // Maximum imbalance = 1
        // Minimum swaps = ceil(1 / 2) = 1
        return (maxImbalance + 1) / 2;
    }
}