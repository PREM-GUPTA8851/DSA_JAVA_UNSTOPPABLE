class Solution {
    void nextPermutation(int[] arr) {
    // lexicographical next permutations algorithm
    // first step we need to find the pivot 
    /*
    pivot --> right se jha p element chota
    mile next element se
    */
    int n = arr.length;
    int pivot = -1;
    for(int i = n-2; i >=0; i--){
        if(arr[i] < arr[i + 1]){
            pivot = i;
            break;
        }
    }
// jb pivot mil jae 
    if(pivot != -1){
    // ab pivot mil gya to pivot se just bda
    //element find krna h pivot index tk aur dono sath m swap kr dena h
    for(int i = n -1; i > pivot; i--){
        if(arr[i] > arr[pivot]){
            // now swap 
            int temp = arr[i];
            arr[i] = arr[pivot];
            arr[pivot] = temp;
            break;
        }
    }
    }
    // now arr = [2,4,5,7,1,0]
    int left = pivot + 1;
    int right = n - 1;
    // right side k pura descending order m h 
    // aur hume next smallest no. chahiye to reverse kr dena better h
    // baki remaining swap kr dena
    while(left < right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
    // [2,4,5,0,1,7]
    }
}