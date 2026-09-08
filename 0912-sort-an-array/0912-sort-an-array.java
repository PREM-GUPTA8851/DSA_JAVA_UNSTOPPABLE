class Solution {
    public int[] sortArray(int[] nums) {
// 5,2,3,1
        // Pura array Merge Sort se sort karega
        mergeSort(nums, 0, nums.length - 1);
// ms(nums, 0, 3)
        return nums;
    }

    // Array ko recursively 2 parts me divide karta hai
    public void mergeSort(int[] arr, int low, int high) {
// ms(nums, 0, 3)
// ms(arr, 0, 1)
// ms(arr, 0, 0) 

// ms(arr, 1, 1)
        // Ek hi element hai to already sorted hai
        if (low >= high) return;
// nope 

        // Middle index nikalta hai
        int mid = low + (high - low) / 2;
// mid = 0 + 3/2 = 0 + 1 = 1
// mid = 0 + (1)/2 = 0

        // Left part sort karta hai
// ms(arr, 0, 1)
        mergeSort(arr, low, mid);

        // Right part sort karta hai
        mergeSort(arr, mid + 1, high);

// ms(arr, 0, 1 )--> ms(arr, 1, 1)
        // Dono sorted parts ko merge karta hai
        merge(arr, low, mid, high);
        // m(arr, 0, 0 , 1)
    }

    // Do sorted parts ko merge karke sorted array banata hai
    public void merge(int[] arr, int low, int mid, int high) {
// m(arr, 0, 0, 1)
        // Merged elements store karne ke liye temp array
        int[] temp = new int[high - low + 1];
// temp[2] = {};
        int i = low;// 0
        int j = mid + 1; // 1
        int k = 0;

        // Dono parts me se smaller element temp me daalta hai
        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                // temp[0] = [2]
                j++; 
            }

            k++; // 1
        }

        // Left part ke remaining elements daalta hai
        while (i <= mid) {
            temp[k] = arr[i];
            // temp[1] = [2,5]
            i++;
            k++;
        }

        // Right part ke remaining elements daalta hai
        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Sorted temp ko original array me copy karta hai
        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}