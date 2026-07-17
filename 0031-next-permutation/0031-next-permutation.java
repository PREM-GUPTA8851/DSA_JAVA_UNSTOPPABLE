class Solution {
    public void nextPermutation(int[] nums) {
    //Pivot = Right se pehla element jo apne next element se chhota ho. Ye wahi element hota hai jise change karke next permutation ban sakta hai.
/*
nums = [1,2,3,6,5,4]
[1,2,4,6,5,3]
[1,2,4,3,5,6]
 */
/// another testcase :-- [1,2,3,6, 4,5]
        int n = nums.length;
// n = 6
        int pivot = -1;

    for (int i = n - 2; i >= 0; i--) {
        // i = 4 
        // 5 < 4 x
        // 6 < 5 x
        // 3 < 6 
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                // pivot = 2
                break;
            }
        }
    // agar pivot mil gya 
        if (pivot != -1) {
            for (int i = n - 1; i > pivot; i--) {
                // i = 5 ; i > 2; i-- 
// nums = [1,2,3,6,5,4]
                if (nums[i] > nums[pivot]) {
//4 > 3 --> h
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
        }
// after swap --> [1,2,4,6,5,3]

        int left = pivot + 1;
        // left = 3
        int right = n - 1;
        // right = 5
    // 3 < 5
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
    // after reverse --> [1,2,4,3,5,6]
    /*
    Current Array

[1,2,4,6,5,3]

Pivot ke baad ka part

6,5,3

Ye already descending order me hai.

Descending order maximum arrangement hoti hai.

Hume next permutation chahiye,
isliye pivot ke baad wale part ko
minimum arrangement me convert karna hoga.

Descending ko minimum banane ka easiest way hai
Reverse kar dena.
     */
}