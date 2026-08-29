class Solution {
    public int hammingWeight(int n) {
        // 6 -> 
        int count = 0;
    // 6 > 0
    // 8 > 0    
    // 11 > 0
        while(n > 0) {
            n = n & (n - 1); // rightmost 1 ko remove
        // n = 110 & 101 --> 100 --> 4
        // n = 100 & 011 --> 0

        // n = 1000 & 0111 --> 0
            count++;
        // c =1
        // c =2

        // c= 1
        }

        return count;  
    }
}