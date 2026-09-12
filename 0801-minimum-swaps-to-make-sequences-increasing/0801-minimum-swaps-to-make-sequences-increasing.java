class Solution {
    public int minSwap(int[] nums1, int[] nums2) {

        int keep = 0;
        // index 0 par swap nahi kiya
        // nums1 = [1,3,5,4]
        // nums2 = [1,2,3,7]

        int swap = 1;
        // index 0 par swap kiya
        // 1 swap


        for (int i = 1; i < nums1.length; i++) {

            int newKeep = Integer.MAX_VALUE;
            int newSwap = Integer.MAX_VALUE;
            // current index ke liye minimum swaps nikalenge


            // i = 1
            // nums1[1] = 3 > nums1[0] = 1
            // nums2[1] = 2 > nums2[0] = 1
            // normal condition true

            if (nums1[i] > nums1[i - 1] &&
                nums2[i] > nums2[i - 1]) {

                newKeep = Math.min(newKeep, keep);
                // previous bhi keep tha
                // current ko bhi keep kiya
                // newKeep = 0

                newSwap = Math.min(newSwap, swap + 1);
                // previous swap tha
                // current ko bhi swap kiya
                // newSwap = 1 + 1 = 2
            }


            // cross condition
            // nums1[1] = 3 > nums2[0] = 1
            // nums2[1] = 2 > nums1[0] = 1
            // true

            if (nums1[i] > nums2[i - 1] &&
                nums2[i] > nums1[i - 1]) {

                newKeep = Math.min(newKeep, swap);
                // previous swap tha
                // current ko swap nahi kiya
                // newKeep = min(0,1) = 0

                newSwap = Math.min(newSwap, keep + 1);
                // previous swap nahi tha
                // current ko swap kiya
                // newSwap = min(2,1) = 1
            }

            keep = newKeep;
            swap = newSwap;
            // keep = 0
            // swap = 1


            // i = 2
            // nums1[2] = 5 > nums1[1] = 3
            // nums2[2] = 3 > nums2[1] = 2
            // normal condition true

            if (nums1[i] > nums1[i - 1] &&
                nums2[i] > nums2[i - 1]) {

                newKeep = Math.min(newKeep, keep);
                // newKeep = 0

                newSwap = Math.min(newSwap, swap + 1);
                // newSwap = 2
            }


            // cross condition
            // nums1[2] = 5 > nums2[1] = 2
            // nums2[2] = 3 > nums1[1] = 3
            // 3 > 3 false
            // kuch nahi karenge


            // i = 3
            // nums1[3] = 4 > nums1[2] = 5
            // false

            // normal condition false


            // cross condition
            // nums1[3] = 4 > nums2[2] = 3
            // true
            // nums2[3] = 7 > nums1[2] = 5
            // true

            if (nums1[i] > nums2[i - 1] &&
                nums2[i] > nums1[i - 1]) {

                newKeep = Math.min(newKeep, swap);
                // previous index par swap kiya tha
                // current par swap nahi kiya
                // newKeep = 1

                newSwap = Math.min(newSwap, keep + 1);
                // previous index par swap nahi kiya
                // current par swap kiya
                // newSwap = 1
            }
        }

        return Math.min(keep, swap);
        // minimum = 1
        // answer = 1
    }
}