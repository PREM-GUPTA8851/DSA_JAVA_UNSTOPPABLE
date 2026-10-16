
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // algorithm analysis --> aapn kth smallest ki algo likh rhe h so aapn k pass kth smallest hona chahiye so aapn kth largest ko smallest m covert krenge as a target element .... search space pattern define kiya aur fhr pivot ko assume kiya mid element then left boundary , current_element , aur greater element wali boundary lgai aur jb tk current element greater element wali boudary se chote h tb tk compare and swap kiya .... aur pivot se chote element h to left side m rkhenge so left boudary se swap kiya aur pivot se bde element h to right boundary m rkhenge so right boundary se swap krenge aur if vo current element hi pivot h to next element m move krenge .... then after that loop we check with our target index if target index , left boundary and right boundary are equal so we return that element as a kth smallest element .agar target element left boundary se chote element k side h to aap left boundary se peeche search space define kroge aur target element vo right boundary se aur aange h to search space pattern aapn right boundary se aange dhoondenge 

        /*
        Input: nums = [3,2,1,5,6,4], k = 2
        Output: 5
        */
        // aapn us largest index ko smallest index m convert krke search krenge ab
        int target = nums.length - k;
        // target = n - k = 6 - 2 = 4

        int low = 0, high = nums.length - 1;
        // low = 0, high = 5

        while (low <= high) {
            // 0 <= 5 --> 
            // nums = [1,2,5,6,4,3]
            // 1 <= 5 -->  nums = [1,2,5,4,3,6]--> high = 4
            // 1 <= 4 --> 

            int pivot = nums[low + (high - low) / 2];
            // pivot = nums[mid] = nums[5/2] = nums[2] = 1
            // pivot = nums[mid] = nums[3] = 6
            // pivot = nums[mid] = nums[5/2] = nums[2] = 5
            int lt = low;
            // lt = 0
            // lt = 1;
// lt = 1
            int i = low;
            // i = 0
            // i = 1;
// i = 1
            int gt = high;
            // gt = 5
            // gt = 5
            // gt = 4
            while (i <= gt) {
                // 0 <= 5
                // 1 <= 1
                // 1 <= 0 --> false
                // now nums = [1,2,5,6,4,3]

                // 1 <= 5 -> nums = [1,2,5,4,3,6]
                // 1 <= 4 -> 

                if (nums[i] < pivot) {
                    // First iteration mein ye condition true nahi hui.
                    
                    // 2 < 6
                    // 5 < 6 
                    // 4 < 6 --> nums = [1,2,5,4,6,3]
                    // 3 < 6 --> nums = [1,2,5,4,3,6]
                    int temp = nums[lt];
                    nums[lt] = nums[i];
                    nums[i] = temp;

                    lt++; // 3, 4, 5
                    //2, 3, 4
                    // nums = [1,2,5,4,3,6]-->[1,2,4,5,3,6]--> [1,2,4,3,5,6]
                    i++; // 4, 5, 6
                    // 2, 3, 4, 5

                } else if (nums[i] > pivot) {
                    // 3 > 1
                    // 4 > 1
                    // 6 > 1
                    // 5 > 1

                    int temp = nums[i];
                    nums[i] = nums[gt];
                    nums[gt] = temp;
                    gt--;

                    // nums = [4,2,1,5,6,3]
                    // nums = [6,2,1,5,4,3]
                    // nums = [5,2,1,6,4,3]
                    // nums = [1,2,5,6,4,3]
                    // nums = [1,2,5,6,4,3]

                } else {
                    i++;
                    // i = 1
                }
            }

            if (target < lt) {
                // 4 < 0 --> false
                high = lt - 1;
// 4 < 5 --> high = 5-1 = 4
            } else if (target > gt) {
                // 4 > 0 --> true
                low = gt + 1;
                // low = 1

            } else {
                /// lt = 4, gt = 4, target = 4
                return pivot;
                // return 5;
            }
        }

        return -1;
    }
}
