class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        // final combinations isme store honge

        if (digits.length() == 0) return ans;
        // empty input hua to direct empty list


        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        // 2 -> abc
        // 3 -> def
        // etc.


        solve(0, digits, map, "", ans);
        // start:
        // index = 0
        // current = ""


        return ans;
    }


    void solve(int index, String digits, String[] map,
               String current, List<String> ans) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }
        // jab index last tak pahuch gaya matlab combination complete
        //
        // example:
        // current = "ad"
        // index = 2
        // digits.length() = 2
        //
        // "ad" complete hai to ans me add kar diya


        int digit = digits.charAt(index) - '0';
        // digits = "23"
        //
        // pehli call me:
        // index = 0
        // digits.charAt(0) = '2'
        //
        // '2' - '0' = 2
        //
        // digit = 2


        String letters = map[digit];
        // digit = 2
        //
        // map[2] = "abc"
        //
        // to ab choices hain:
        // a, b, c


        for (int i = 0; i < letters.length(); i++) {

            solve(index + 1, digits, map,
                  current + letters.charAt(i), ans);

            /*
            DRY RUN: digits = "23"

            ------------------------------------------------
            First call:

            solve(0, "23", map, "", ans)

            index = 0
            current = ""

            digit = 2
            letters = "abc"


            i = 0

            letters.charAt(0) = 'a'

            current + 'a'
            "" + 'a' = "a"

            next call:

            solve(1, "23", map, "a", ans)


                index = 1
                current = "a"

                digit = 3
                letters = "def"


                i = 0

                current + 'd'
                "a" + 'd' = "ad"

                next call:

                solve(2, "23", map, "ad", ans)


                    index == digits.length()

                    2 == 2  -> true

                    ans.add("ad")

                    ans = ["ad"]

                    return


                wapas index = 1 wale call me


                ab i = 1

                "a" + 'e' = "ae"

                ans = ["ad", "ae"]


                ab i = 2

                "a" + 'f' = "af"

                ans = ["ad", "ae", "af"]


            ab "a" ke saare combinations ho gaye
            return hoke wapas first call


            ------------------------------------------------
            i = 1

            letters.charAt(1) = 'b'

            current = "" + 'b'
                    = "b"

            ab digit 3 ke letters:

            "b" + d = "bd"
            "b" + e = "be"
            "b" + f = "bf"

            ans =
            ["ad", "ae", "af", "bd", "be", "bf"]


            ------------------------------------------------
            i = 2

            letters.charAt(2) = 'c'

            current = "c"

            "c" + d = "cd"
            "c" + e = "ce"
            "c" + f = "cf"


            FINAL:

            ["ad", "ae", "af",
             "bd", "be", "bf",
             "cd", "ce", "cf"]
            */
        }
    }
}