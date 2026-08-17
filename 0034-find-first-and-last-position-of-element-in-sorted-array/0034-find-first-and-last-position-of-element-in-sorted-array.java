class Solution {
    public int[] searchRange(int[] arr, int target) {
    // first element k liye by store and compute & always left side find kro jo index milega vo first index hoga 
    int start = 0; 
    int end = arr.length - 1;
    int first = -1;
    while(start <= end){
        int midf = start + (end - start)/2;
        if(arr[midf] == target) {
            first = midf;
            // left jao aur elements check kro ki usse pehle to aur koi n aaya
            end = midf - 1;
        }
        else if(arr[midf] < target){
            start = midf +1;
        }
        else {
            end = midf -1;
        }
    }
    // last element k liye by store and compute and always right side find kro jo index milega vo last index hoga


    int s = 0; 
    int e = arr.length - 1;
    int last = -1;
    while(s <= e){
        int midl = s + (e - s)/2;
        if(arr[midl] == target) {
            last = midl;
            // right jao aur elements check kro ki usse baad to aur koi n aaya
            s = midl + 1;
        }
        else if(arr[midl] < target){
            s = midl +1;
        }
        else {
            e = midl -1;
        }
    }
    // int arrf = new int[2];
    // arrf[0] = first;
    // arrf[1] = last;
    // return arrf;
    return new int[] {first, last};
    }
}