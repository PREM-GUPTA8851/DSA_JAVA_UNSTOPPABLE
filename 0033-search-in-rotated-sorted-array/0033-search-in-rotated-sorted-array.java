class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        // nums = [4,5,6,7,0,1,2]
        // target = 0

        while (low <= high) {

            int mid = low + (high - low) / 2;

            /*
            1st Iteration

            low = 0
            high = 6
            mid = 3

            nums[mid] = 7

            nums[low] <= nums[mid]
            4 <= 7

            Left Half = [4,5,6,7]

            target >= nums[low] && target < nums[mid]
            0 >= 4  -> false

            low = mid + 1
            low = 4
            */

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {

                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {

                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            /*
            2nd Iteration

            low = 4
            high = 6
            mid = 5

            nums[mid] = 1

            nums[low] <= nums[mid]
            0 <= 1

            Left Half = [0,1]

            target >= nums[low] && target < nums[mid]
            0 >= 0
            0 < 1

            high = mid - 1
            high = 4
            */
        }

        /*
        3rd Iteration

        low = 4
        high = 4
        mid = 4

        nums[mid] = 0

        target mil gaya

        return 4
        */

        return -1;
    }
}