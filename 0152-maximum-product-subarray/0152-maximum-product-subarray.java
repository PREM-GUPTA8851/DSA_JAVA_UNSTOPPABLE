class Solution {
    public int maxProduct(int[] nums) {
        // algorithm when we found the number is -ve so we multiply with the minimum product of that number.. so we get the final max product.
        int min_prod = nums[0];
        int max_prod = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            // agar number -ve mila to swap kr dena max aur min ko 
            if(nums[i] < 0){
                int temp = max_prod;
                max_prod = min_prod;
                min_prod = temp;
            }

            max_prod = Math.max( nums[i], nums[i] * max_prod);
            min_prod = Math.min(nums[i], nums[i] * min_prod);

            ans = Math.max(ans, max_prod);
        }
        return ans;
    }
}