class Solution {
    public void mergeArrays(int a[], int b[]) {
        // code here
        // logic is we are taking two pointer's 
        int i, j;
        // one is pointing towards one array last
        i = a.length - 1;
        // one is pointing towards second array first
        j = 0;
        
        while (i >= 0 && j < b.length){
            if(a[i] > b[j]){
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
