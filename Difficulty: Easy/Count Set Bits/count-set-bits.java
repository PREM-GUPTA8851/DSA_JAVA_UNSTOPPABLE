class Solution {
    public int setBits(int n) {
        int count = 0;

        while(n > 0) {
            n = n & (n - 1); // rightmost 1 ko remove
            count++;
        }

        return count;
    }
}