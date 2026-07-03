class Solution {
    public void sort012(int[] arr) {
        // by using dutch national flag algorithms
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid <= high){
            if(arr[mid] == 0){
                // swap with arr[low]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            }
            else if(arr[mid]  == 1){
                // 1 uski correct position m h
                mid++;
            }
            else{
                // arr[mid] ==2 
                // swap with high
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}