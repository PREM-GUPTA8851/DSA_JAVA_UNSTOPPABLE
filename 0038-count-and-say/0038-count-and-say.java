class Solution {
    public String countAndSay(int n) {

        String ans = "1"; // Base case

        /*
        ===========================================
        DRY RUN (n = 4)

        Initially:
        ans = "1"

        We need to generate:
        1
        11
        21
        1211

        ===========================================
        */

        // Generate sequence from 2 to n
        for (int i = 2; i <= n; i++) {

            /*
            ---------------------------------------
            i = 2

            ans = "1"

            We have to read:
            "one 1"

            Expected Output:
            "11"
            ---------------------------------------
            */

            /*
            ---------------------------------------
            i = 3

            ans = "11"

            We have to read:
            "two 1"

            Expected Output:
            "21"
            ---------------------------------------
            */

            /*
            ---------------------------------------
            i = 4

            ans = "21"

            We have to read:
            "one 2 one 1"

            Expected Output:
            "1211"
            ---------------------------------------
            */

            StringBuilder temp = new StringBuilder();
            // temp = ""

            int count = 1;
            // Every new group starts with count = 1

            /*
            =======================================
            Actual Detailed Dry Run
            =======================================

            --------------------------
            i = 2
            --------------------------

            ans = "1"

            ans.length() = 1

            for(j=1; j<1; j++)
            Condition false

            Loop never executes.

            Last group:
            temp.append(1)
            temp = "1"

            temp.append('1')
            temp = "11"

            ans = "11"

            ----------------------------------

            --------------------------
            i = 3
            --------------------------

            ans = "11"

            temp = ""

            count = 1

            j = 1

            ans.charAt(1) = '1'
            ans.charAt(0) = '1'

            Same character

            count++

            count = 2

            Loop ends.

            Last group:

            temp.append(2)
            temp = "2"

            temp.append('1')
            temp = "21"

            ans = "21"

            ----------------------------------

            --------------------------
            i = 4
            --------------------------

            ans = "21"

            temp = ""

            count = 1

            j = 1

            ans.charAt(1) = '1'
            ans.charAt(0) = '2'

            Different characters

            temp.append(1)
            temp = "1"

            temp.append('2')
            temp = "12"

            count = 1

            Loop ends.

            Last group:

            temp.append(1)
            temp = "121"

            temp.append('1')
            temp = "1211"

            ans = "1211"

            ----------------------------------

            Final Answer = "1211"

            */

            for (int j = 1; j < ans.length(); j++) {

                /*
                Compare current character
                with previous character

                Example:
                ans = "11"

                j = 1

                current = '1'
                previous = '1'
                */

                if (ans.charAt(j) == ans.charAt(j - 1)) {

                    // Same character found

                    count++;

                    /*
                    Example:

                    count = 1

                    becomes

                    count = 2
                    */

                } else {

                    /*
                    Character changed

                    Store previous group

                    Example:

                    count = 2
                    previous = '1'

                    temp becomes

                    "21"
                    */

                    temp.append(count);

                    temp.append(ans.charAt(j - 1));

                    // New group starts

                    count = 1;
                }
            }

            /*
            Loop ends.

            One group is still left.

            Example:

            ans = "111"

            Loop never stores last group.

            So we append it manually.
            */

            temp.append(count);

            /*
            Example:

            temp = ""

            count = 3

            temp = "3"
            */

            temp.append(ans.charAt(ans.length() - 1));

            /*
            Example:

            temp = "3"

            append('1')

            temp = "31"
            */

            ans = temp.toString();

            /*
            i = 2

            ans = "11"

            -----------------

            i = 3

            ans = "21"

            -----------------

            i = 4

            ans = "1211"
            */
        }

        return ans;
    }
}