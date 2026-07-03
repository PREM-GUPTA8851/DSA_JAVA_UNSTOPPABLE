class Solution {
    int maxSubarraySum(int[] arr) {

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {

            currSum += num;

            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}