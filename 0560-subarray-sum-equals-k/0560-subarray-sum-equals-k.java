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
        // nums = [0,0,0], k = 0

            sum += num;
            // -------------------------
            // Iteration 1
            // num = 0
            // sum = 0 + 0 = 0
            //
            // Iteration 2
            // num = 0
            // sum = 0 + 0 = 0
            //
            // Iteration 3
            // num = 0
            // sum = 0 + 0 = 0

            if (map.containsKey(sum - k)) {
            // sum-k check karte hain.
            //
            // Iteration 1
            // sum-k = 0-0 = 0
            // map me 0 hai.
            //
            // map.get(0) = 1
            // Matlab Prefix Sum = 0 pehle 1 baar mila.
            //
            // count += 1
            // count = 1
            //
            //
            // Iteration 2
            // sum-k = 0-0 = 0
            // map me 0 hai.
            //
            // map.get(0) = 2
            // Matlab Prefix Sum = 0 pehle 2 baar mil chuka hai.
            //
            // count += 2
            // count = 3
            //
            //
            // Iteration 3
            // sum-k = 0-0 = 0
            // map me 0 hai.
            //
            // map.get(0) = 3
            // Matlab Prefix Sum = 0 pehle 3 baar mil chuka hai.
            //
            // count += 3
            // count = 6

                count += map.get(sum - k);
                // Frequency jitni hogi utne subarray milenge.
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // Current Prefix Sum ko map me store kar do.
            //
            // Iteration 1
            // map = {0=2}
            //
            // Iteration 2
            // map = {0=3}
            //
            // Iteration 3
            // map = {0=4}
        }

        return count;
        // Final Answer = 6
    }
}