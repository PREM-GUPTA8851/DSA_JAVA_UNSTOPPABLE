class Solution {
    public int[] findErrorNums(int[] nums) {

        // nums = [1,2,2,4]

        int repeated = -1;
        int missing = -1;

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;
            // i = 2
            // nums[2] = 2
            // index = 1

            if (nums[index] < 0) {
                repeated = Math.abs(nums[i]);
                // nums[1] already negative hai
                // matlab 2 pehle aa chuka hai
                // repeated = 2

            } else {
                nums[index] *= -1;
                // first time mila to negative mark
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                missing = i + 1;
                // index 2 positive bacha
                // missing = 3
            }
        }

        return new int[]{repeated, missing};
        // [2,3]
    }
}