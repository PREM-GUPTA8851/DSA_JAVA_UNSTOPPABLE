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
            int count = 1;
        // ans --> 1 --> length = 1
        // ans --> 11 --> length = 2
        // ans --> 21 --> length = 2

        // 2nd one --> 1 < 2 --> ..
        // 3rd one --> 1 < 2-->...
    for (int j = 1; j < ans.length(); j++) {
        
        if(ans.charAt(j) == ans.charAt(j - 1)) {
            count++; 
            
        // count = 2
        } else {
                    temp.append(count); 
                    // temp.append(1) --> temp --> 1
                    temp.append(ans.charAt(j - 1)); 
                    // temp.append(ans.charAt(0)) --> 
                    // temp.append(2) --> temp --> 12
                    count = 1;
                }
            }

            // Last group
            temp.append(count);
            // temp.append(1) --> temp --> 1
            // temp.append(2) --> 2
            // temp.append(1) --> 121
            temp.append(ans.charAt(ans.length() - 1));
            // temp.append(ans.charAt(0)) --> temp.append(1)
            // temp.append(ans.charAt(1)) --> temp.append(1)
            // temp.append(1) --> temp --> 1211

            ans = temp.toString();
            // ans = "11"
            // ans = "21"

        }

        return ans;
    }
}