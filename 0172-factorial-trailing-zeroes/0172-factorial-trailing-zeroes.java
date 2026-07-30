class Solution {
    public int trailingZeroes(int n) {
        
        // n = 100
        // count = 0

        // count += 100 / 5
        // count = 20

        // n = 100 / 5
        // n = 20

        // count += 20 / 5
        // count = 24

        // n = 20 / 5
        // n = 4

        // count += 4 / 5
        // count = 24

        // n = 4 / 5
        // n = 0

        //  24

        int count = 0;

        while(n > 0){
            count += n / 5;
            n = n / 5;
        }

        return count;
    }
}