class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        // dry run :--
        // nums 1 = {2,3,2}
        // nums 2 = {1,2}
        int answer1 = 0;
        int answer2 = 0;

        // Count elements of nums1 present in nums2
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    answer1++;
                   //break; // mil gaya, aur check karne ki zarurat nahi
                }
            }
        }

        // Count elements of nums2 present in nums1
        for (int i = 0; i < nums2.length; i++) {

            for (int j = 0; j < nums1.length; j++) {

                if (nums2[i] == nums1[j]) {
                    answer2++;
                    //break; // mil gaya
                }
            }
        }

        return new int[]{answer1, answer2};
    }
}