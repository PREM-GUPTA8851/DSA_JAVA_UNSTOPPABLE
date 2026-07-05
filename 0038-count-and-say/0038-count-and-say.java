class Solution {
    public String countAndSay(int n) {

        String ans = "1"; // Base case

        // Generate sequence from 2 to n
        // 2,3,4
        for (int i = 2; i <= n; i++) {

            StringBuilder temp = new StringBuilder();

            int count = 1;

            // Traverse previous string
            for (int j = 1; j < ans.length(); j++) {

                if (ans.charAt(j) == ans.charAt(j - 1)) {
                    count++;
                } else {

                    // Append frequency + character
                    temp.append(count);
                    temp.append(ans.charAt(j - 1));

                    count = 1;
                }
            }

            // Last group
            temp.append(count);
            temp.append(ans.charAt(ans.length() - 1));

            ans = temp.toString();
        }

        return ans;
    }
}