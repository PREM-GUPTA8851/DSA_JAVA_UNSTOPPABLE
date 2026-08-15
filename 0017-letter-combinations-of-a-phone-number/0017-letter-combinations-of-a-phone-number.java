class Solution {
    public List<String> letterCombinations(String digits) {
    List<String> ans = new ArrayList<>();

    if (digits.length() == 0)
        return ans;

    String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    solve(0, digits, map, "", ans);

        return ans;
    }

    void solve(int index, String digits, String[] map,
            String current, List<String> ans) {

    if (index == digits.length()) {
        ans.add(current);
        return;
        }

        int digit = digits.charAt(index) - '0';

        String letters = map[digit];

    for (int i = 0; i < letters.length(); i++) {
        solve(index + 1, digits, map,
            current + letters.charAt(i), ans);
        }
    }
}