class Solution {
    public int subarraySum(int[] nums, int k) {

    HashMap<Integer, Integer> map = new HashMap<>();
        // Prefix Sum aur uski frequency store karega.

        map.put(0, 1);
        // Shuru me sum = 0 ek baar aaya hai.
        // map = {0=1}

        int sum = 0;
        // Current Prefix Sum

        int count = 0;
        // Answer store karega

        for (int num : nums) {
        // nums = [1,2,3], k = 3

            sum += num;
            // -------------------------
            // Iteration 1
            // num = 1
            // sum = 0 + 1 = 1
            //
            // Iteration 2
            // num = 2
            // sum = 1 + 2 = 3
            //
            // Iteration 3
            // num = 3
            // sum = 3 + 3 = 6

            if (map.containsKey(sum - k)) {
            // sum-k check karte hain.
            //
            // Iteration 1
            // sum-k = 1-3 = -2
            // map me -2 nhi hai.
            //
            // Iteration 2
            // sum-k = 3-3 = 0
            // map me 0 hai.
            // Matlab yaha tak koi subarray ka sum = 3 mila.
            //
            // count += map.get(0)
            // count = 1
            //
            // Iteration 3
            // sum-k = 6-3 = 3
            // map me 3 hai.
            // Matlab ek aur subarray ka sum = 3 mila.
            // count = 2

                count += map.get(sum - k);
                // Frequency jitni hogi utne subarray milenge.
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // Current Prefix Sum ko map me store kar do.
            //
            // Iteration 1
            // map = {0=1,1=1}
            //
            // Iteration 2
            // map = {0=1,1=1,3=1}
            //
            // Iteration 3
            // map = {0=1,1=1,3=1,6=1}
        }

        return count;
        // Final Answer = 2
    }
}