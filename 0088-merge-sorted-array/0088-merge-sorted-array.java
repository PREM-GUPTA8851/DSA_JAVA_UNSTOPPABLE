class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //  nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int i = m - 1;        // 2
        int j = n - 1;        // 2
        int k = m + n - 1;    // 5
        // Back se merge karo
        while (i >= 0 && j >= 0) {
        // nums1[2] = 3 > nums2[2] = 6 --> else part
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
            // nums1[3] = nums1[2] = 3
            // nums1 = [1,2,3 ,3,5,6]
                i--;
                // i = 1
            } else {
                nums1[k] = nums2[j];
                // nums1[5] = nums2[2] = 6
                // nums1[4] = 5;
                // num1[2] = 2;
                j--;
                // j = 1
                // j = 0;
            }

            k--;
            // k = 4
            // k = 3;
            // k = 2
        }

        // Agar nums2 me elements bach gaye
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}