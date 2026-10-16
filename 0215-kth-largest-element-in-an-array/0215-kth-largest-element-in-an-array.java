class Solution {
    public int findKthLargest(int[] nums, int k) {

        // TC: nums = [1,2,3,4,5,1,1,1], k = 3
        // Expected output = 3

        int target = nums.length - k;
        // target = 8 - 3 = 5
        // Ascending sorted order mein index 5 par answer hoga.

        int low = 0, high = nums.length - 1;
        // low = 0, high = 7

        while (low <= high) {

            int pivot = nums[low + (high - low) / 2];
            // First round: low=0, high=7
            // pivot index = 0 + (7-0)/2 = 3
            // pivot = nums[3] = 4

            int lt = low;
            int i = low;
            int gt = high;
            // lt=0, i=0, gt=7

            // Regions:
            // [low ... lt-1] < pivot
            // [lt ... i-1]  == pivot
            // [i ... gt]    unknown
            // [gt+1 ... high] > pivot

            while (i <= gt) {

                if (nums[i] < pivot) {

                    int temp = nums[lt];
                    nums[lt] = nums[i];
                    nums[i] = temp;

                    lt++;
                    i++;

                    // Pivot=4
                    // i=0: nums[0]=1 < 4
                    // Swap index 0 with index 0
                    // Array: [1,2,3,4,5,1,1,1]
                    // lt=1, i=1, gt=7

                    // i=1: nums[1]=2 < 4
                    // Swap index 1 with index 1
                    // Array: [1,2,3,4,5,1,1,1]
                    // lt=2, i=2, gt=7

                    // i=2: nums[2]=3 < 4
                    // Swap index 2 with index 2
                    // Array: [1,2,3,4,5,1,1,1]
                    // lt=3, i=3, gt=7
                }

                else if (nums[i] > pivot) {

                    int temp = nums[i];
                    nums[i] = nums[gt];
                    nums[gt] = temp;

                    gt--;

                    // Is testcase mein first round mein
                    // nums[i] > 4 wala case nahi aata.
                    // General case mein:
                    // greater element ko right region mein bhejte hain.
                    // i same rehta hai, kyunki swapped value check karni hai.
                }

                else {
                    i++;

                    // i=3: nums[3]=4 == pivot
                    // i=4: nums[4]=5 > 4
                    // Isliye i=4 par else nahi chalega.
                    //
                    // Correct execution aage table mein dekho.
                }
            }

            // Partition complete hone par:
            // Array = [1,2,3,1,1,1,4,5]
            // lt=4, gt=4
            // Equal-to-pivot range = [4 ... 4]
            //
            // NOTE: Actual swaps aur pointer values ko
            // neeche full execution table mein follow karo.

            if (target < lt) {
                high = lt - 1;
            }
            else if (target > gt) {
                low = gt + 1;
            }
            else {
                return pivot;
            }
        }

        return -1;
    }
}