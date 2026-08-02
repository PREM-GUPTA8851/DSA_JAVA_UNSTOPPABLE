class Solution {
    void nextPermutation(int[] arr) {

        // Dry Run
        // Input : [1, 3, 2]

        int n = arr.length;
        int pivot = -1;

        // Pivot Find
        for(int i = n - 2; i >= 0; i--){

            // i = 1
            // 3 < 2  -> No

            // i = 0
            // 1 < 3  -> Yes
            // pivot = 0

            if(arr[i] < arr[i + 1]){
                pivot = i;
                break;
            }
        }

        // pivot = 0

        if(pivot == -1){
            reverse(arr,0,n-1);
            return;
        }

        // Next Greater Element
        for(int i = n - 1; i > pivot; i--){

            // i = 2
            // arr[2] = 2
            // arr[pivot] = 1
            // 2 > 1

            // Swap
            // [2,3,1]

            if(arr[i] > arr[pivot]){
                swap(arr,i,pivot);
                break;
            }
        }

        // Reverse pivot+1 to end

        // Before Reverse
        // [2,3,1]

        // Reverse (1...2)

        // After Reverse
        // [2,1,3]

        reverse(arr,pivot+1,n-1);
    }

    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr,int start,int end){
        while(start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
}