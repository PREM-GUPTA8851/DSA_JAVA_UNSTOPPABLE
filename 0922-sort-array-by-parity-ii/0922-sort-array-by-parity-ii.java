class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        // logic is even number ko even index par
        // aur odd number ko odd index par rakhna hai

        int even = 0;
        int odd = 1;

        while(even < nums.length && odd < nums.length) {

            // even index par agar even number hai
            // to pointer ko aage badha denge
            if(nums[even] % 2 == 0) {
                even += 2;
            }

            // odd index par agar odd number hai
            // to pointer ko aage badha denge
            else if(nums[odd] % 2 == 1) {
                odd += 2;
            }

            else {
                // even index par odd number aa gaya
                // aur odd index par even number hai
                // dono ko swap kar denge

                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;

                even += 2;
                odd += 2;
            }
        }

        return nums;
    }
}