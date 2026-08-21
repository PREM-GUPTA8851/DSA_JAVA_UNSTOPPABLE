class Solution {
    public void mergeArrays(int a[], int b[]) {
        // code here
        // by using 2 pointer method
        int i = a.length - 1;
        int j = 0;
        
        // swap krenge loop chlaenge 
        while(i >= 0 && j < b.length){
            if(a[i] > b[j]){
            int temp = a[i];
            a[i] = b[j];
            b[j] = temp;
            }
            i--;
            j++;
        }
        // till 2nd pointer < 2nd array length and 1st pointer greater than 0
        
        // iske baad fhr sort algorith lga denge both arrays pe
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
