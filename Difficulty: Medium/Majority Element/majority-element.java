class Solution {
    int majorityElement(int nums[]) {

        // nums = [2,2,1,1,1,2,2]

        HashMap<Integer, Integer> map = new HashMap<>();
        // map = empty

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // i=0 → 2 → map: 2=1
        // i=1 → 2 → map: 2=2
        // i=2 → 1 → map: 2=2, 1=1
        // i=3 → 1 → map: 2=2, 1=2
        // i=4 → 1 → map: 2=2, 1=3
        // i=5 → 2 → map: 2=3, 1=3
        // i=6 → 2 → map: 2=4, 1=3

        for (int num : map.keySet()) {

            if (map.get(num) > nums.length / 2) {
                // n=7 → n/2=3
                // num=1 → 3>3 false
                // num=2 → 4>3 true

                return num;
                // return 2
            }
        }

        return -1;
    }
}