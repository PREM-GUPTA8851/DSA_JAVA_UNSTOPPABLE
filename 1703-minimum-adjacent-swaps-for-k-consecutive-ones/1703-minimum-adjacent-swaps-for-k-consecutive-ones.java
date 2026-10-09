class Solution {
    public int minMoves(int[] nums, int k) {
        ArrayList<Integer> pos = new ArrayList<>();

        // Pehle saare 1 ke indexes store karenge
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) pos.add(i);
        }

        int n = pos.size();
        long[] prefix = new long[n + 1];

        // Index me se i minus karenge taaki consecutive 1s ki positions adjust ho jaayein
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + pos.get(i) - i;
        }

        long ans = Long.MAX_VALUE;

        // Har k consecutive 1s ka group check karenge
        for (int left = 0; left + k <= n; left++) {
            int right = left + k - 1;
            int mid = left + k / 2;
            long median = pos.get(mid) - mid;

            // Median ke left aur right wale 1s ko paas lane ke moves count karenge
            long l = median * (mid - left)
                   - (prefix[mid] - prefix[left]);

            long r = (prefix[right + 1] - prefix[mid + 1])
                   - median * (right - mid);

            ans = Math.min(ans, l + r);
        }

        return (int) ans;
    }
}