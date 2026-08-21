class Solution {
     String printSequence(String S) {

        String[] keypad = {
            "2", "22", "222",        // A B C
            "3", "33", "333",        // D E F
            "4", "44", "444",        // G H I
            "5", "55", "555",        // J K L
            "6", "66", "666",        // M N O
            "7", "77", "777", "7777",// P Q R S
            "8", "88", "888",        // T U V
            "9", "99", "999", "9999" // W X Y Z
        };

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {

            char ch = S.charAt(i);

            // Agar space hai
            if (ch == ' ') {
                ans.append("0");
            } 
            else {
                // A ka ASCII = 65
                // B ka ASCII = 66
                //
                // 'B' - 'A' = 1
                //
                // Isliye:
                // A → keypad[0]
                // B → keypad[1]
                // C → keypad[2]

                ans.append(keypad[ch - 'A']);
            }
        }

        return ans.toString();
    }
}