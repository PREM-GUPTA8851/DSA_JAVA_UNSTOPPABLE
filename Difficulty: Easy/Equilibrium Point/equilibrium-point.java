class Solution {
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        int lsum[] = new int[n];
        int rsum[] = new int[n];
        
        for(int i = 1; i < n; i++){
            lsum[i] = lsum[i -1] + arr[i - 1];
        }
        
        for(int i = n - 2; i >= 0; i--){
            rsum[i] = rsum[i + 1] + arr[i + 1];
        }
        
        for(int i = 0; i < n; i++){
            if(rsum[i] == lsum[i]) return i;
        }
        return -1;
    }
}
