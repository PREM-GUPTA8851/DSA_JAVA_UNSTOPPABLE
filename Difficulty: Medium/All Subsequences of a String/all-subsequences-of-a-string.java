class Solution {

    public List<String> powerSet(String s) {

        List<String> ans = new ArrayList<>();

        solve(0, s, "", ans);

        Collections.sort(ans);

        return ans;
    }

    public void solve(int index, String s, String temp, List<String> ans) {

        if (index == s.length()) {
            ans.add(temp);
            return;
        }

        // Include
        solve(index + 1, s, temp + s.charAt(index), ans);

        // Exclude
        solve(index + 1, s, temp, ans);
    }
}