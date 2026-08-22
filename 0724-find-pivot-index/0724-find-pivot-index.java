class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;

        int[] lsum = new int[n];
        // left sum store karne ke liye

        int[] rsum = new int[n];
        // right sum store karne ke liye


        // Left Sum
        for (int i = 1; i < n; i++) {
            lsum[i] = lsum[i - 1] + nums[i - 1];
        }
        /*
        nums = [1,7,3,6,5,6]

        lsum[1] = 0 + 1 = 1
        lsum[2] = 1 + 7 = 8
        lsum[3] = 8 + 3 = 11

        lsum = [0,1,8,11,17,22]
        */


        // Right Sum
        for (int i = n - 2; i >= 0; i--) {
            rsum[i] = rsum[i + 1] + nums[i + 1];
        }
        /*
        rsum[4] = 0 + 6 = 6
        rsum[3] = 6 + 5 = 11

        rsum = [27,20,17,11,6,0]
        */


        // dono sum compare karo
        for (int i = 0; i < n; i++) {

            if (lsum[i] == rsum[i]) {
                return i;
                // i = 3
                // leftSum = 11
                // rightSum = 11
            }
        }

        return -1;
    }
}