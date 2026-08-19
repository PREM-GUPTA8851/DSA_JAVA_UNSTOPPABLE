class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), ans = 0;
        int[] zero = new int[n + 2];
        int m = 1;

        zero[0] = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0')
                zero[m++] = i;
        }

        zero[m] = n;

        // consecutive 1s ke saare substrings valid
        for (int i = 0; i < m; i++) {
            int len = zero[i + 1] - zero[i] - 1;
            ans += len * (len + 1) / 2;
        }

        for (int k = 1; k < m && k * k + k <= n; k++) {
            for (int i = 1; i + k - 1 < m; i++) {

                int first = zero[i];
                int last = zero[i + k - 1];

                int left = first - zero[i - 1];
                int right = zero[i + k] - last;

                int need = k * k + k;
                int len = last - first + 1;
                int extra = Math.max(0, need - len);

                for (int l = 0; l < left; l++) {
                    int r = Math.max(0, extra - l);

                    if (r < right)
                        ans += right - r;
                }
            }
        }

        return ans;
    }
}