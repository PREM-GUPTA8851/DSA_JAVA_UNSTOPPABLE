class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // map = {0=1}

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            /*
            Dry Run

            nums = [1, 2, 3]
            k = 3

            -------------------------
            Iteration 1
            num = 1

            sum = 0 + 1 = 1

            sum - k = 1 - 3 = -2

            map = {0=1}

            map.containsKey(-2) -> false

            count = 0

            map.put(1,1)

            map = {0=1, 1=1}

            -------------------------
            Iteration 2
            num = 2

            sum = 1 + 2 = 3

            sum - k = 3 - 3 = 0

            map = {0=1, 1=1}

            map.containsKey(0) -> true

            count += map.get(0)

            count = 0 + 1 = 1

            map.put(3,1)

            map = {0=1, 1=1, 3=1}

            -------------------------
            Iteration 3
            num = 3

            sum = 3 + 3 = 6

            sum - k = 6 - 3 = 3

            map = {0=1, 1=1, 3=1}

            map.containsKey(3) -> true

            count += map.get(3)

            count = 1 + 1 = 2

            map.put(6,1)

            map = {0=1, 1=1, 3=1, 6=1}

            Loop End

            return 2
            */

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}