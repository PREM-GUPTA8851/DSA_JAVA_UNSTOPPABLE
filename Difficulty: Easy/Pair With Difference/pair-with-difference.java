
class Solution {
    public boolean findPair(int[] arr, int x) {
    Arrays.sort(arr);
    // --> [1,1,1,2,7,10];
    int start = 0;
    int end = 1;
    
    while(end < arr.length){
        int diff = arr[end] - arr[start];
        if(diff == x) return true;
        else if(diff > x) start++;
        else end++;
        // important:
        // start == end ho jaye to end ko bhi aage karna hai
        if (start == end) {
            end++;
        }
    }
    return false;
    }
}
