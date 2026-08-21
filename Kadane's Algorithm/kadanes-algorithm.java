class Solution {
    int maxSubarraySum(int[] arr) {
        // max subarray chahiye to ans ko min se initialise kro
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int n: arr){
            sum += n;
            
            ans = Math.max(ans,sum);
            
            if(sum < 0){
                sum = 0;
            }
        }
        return ans;
    }
}
