class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> ans = new ArrayList<>();

        int j = 0;
        // target ko match karne ke liye pointer

        for (int i = 1; i <= n && j < target.length; i++) {

            ans.add("Push");
            // har number pe pehle Push hoga

            if (i == target[j]) {
                j++;
                // target me mila → Push rehne do
            } else {
                ans.add("Pop");
                // target me nahi mila → Push karke turant Pop
            }
        }

        return ans;
    }
}