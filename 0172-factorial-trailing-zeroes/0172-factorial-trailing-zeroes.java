class Solution {
    public int trailingZeroes(int n) {
        // 100/5 --> 20 + 20 /5 --> 20 + 4/5--> 0. --> 24
        int count = 0;
        while(n > 0){
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}