class Solution {
    public boolean canPartition(int[] nums) {

        int total = 0;

        for (int num : nums) {
            total += num; // Calculate total sum
        }

        if (total % 2 != 0) {
            return false; // Odd sum cannot be equally partitioned
        }

        int target = total / 2; // Required subset sum

        boolean[] dp = new boolean[target + 1]; // dp[w] tells if sum w is possible
        dp[0] = true; // Sum 0 is always possible

        for (int num : nums) {
            for (int w = target; w >= num; w--) {
                dp[w] = dp[w] || dp[w - num]; // Skip or take current number
            }
        }

        return dp[target]; // Check if target sum is possible
    }
}