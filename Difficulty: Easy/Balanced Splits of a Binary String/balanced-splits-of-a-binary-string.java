class Solution {
    public static int maxSubStr(String s) {

        // Dry Run :--
        // Input : s = "0100110101"

        int zero = 0;
        int one = 0;
        int count = 0;

        // i = 0
        // s.charAt(0) = '0'
        // zero = 1
        // one = 0
        // zero != one

        // i = 1
        // s.charAt(1) = '1'
        // zero = 1
        // one = 1
        // zero == one ✅
        // count = 1
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 2
        // s.charAt(2) = '0'
        // zero = 1

        // i = 3
        // s.charAt(3) = '0'
        // zero = 2

        // i = 4
        // s.charAt(4) = '1'
        // one = 1

        // i = 5
        // s.charAt(5) = '1'
        // one = 2
        // zero == one ✅
        // count = 2
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 6
        // s.charAt(6) = '0'
        // zero = 1

        // i = 7
        // s.charAt(7) = '1'
        // one = 1
        // zero == one ✅
        // count = 3
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 8
        // s.charAt(8) = '0'
        // zero = 1

        // i = 9
        // s.charAt(9) = '1'
        // one = 1
        // zero == one ✅
        // count = 4
        // zero = 0
        // one = 0

        // Loop End

        // zero == one
        // return count = 4

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0')
                zero++;
            else
                one++;

            if (zero == one) {
                count++;
                zero = 0;
                one = 0;
            }
        }

        if (zero != one)
            return -1;

        return count;
    }
}