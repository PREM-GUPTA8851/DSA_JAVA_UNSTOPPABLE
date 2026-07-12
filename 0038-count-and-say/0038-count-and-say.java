class Solution {
    public String countAndSay(int n) {
        String ans = "1"; // Base case
        // Generate sequence from 2 to n
        // 2,3,4
        for (int i = 2; i <= n; i++) {
        // i = 2
        // i = 3
        // i = 4
            StringBuilder temp = new StringBuilder();
            // temp = "";
            int count = 1;

            // Traverse previous string
            // ans.length = 1
            // ans.length = 2

        for (int j = 1; j < ans.length(); j++) {

        if(ans.charAt(j) == ans.charAt(j - 1)) {
            count++; // count = 2
                } else {

                    // Append frequency + character
                    temp.append(count); // 1
                    temp.append(ans.charAt(j - 1)); 

                    count = 1;
                }
            }

            // Last group
            temp.append(count);
            // temp = 1
            // temp.append(2);
            temp.append(ans.charAt(ans.length() - 1));
            // 11
            // temp.append(1)
            ans = temp.toString();
            // ans = 11
            // ans = 21
        }

        return ans;
    }
}