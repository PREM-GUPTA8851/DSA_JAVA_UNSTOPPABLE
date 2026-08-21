class Solution {
    public void rotate(int[] arr) {

        int n = arr.length;

        // Step 1: Store last element
        int last = arr[n - 1];

        // Step 2: Shift all elements one position to the right
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        // Step 3: Place last element at first position
        arr[0] = last;
    }
}