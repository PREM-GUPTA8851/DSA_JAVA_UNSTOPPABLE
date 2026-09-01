class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // nums = [3,2,3]
        // n = 3
        // n/3 = 1

        int c1 = 0, c2 = 0, n1 = 0, n2 = 0;
        // c1,c2 = count
        // n1,n2 = 2 possible candidates


        for (int num : nums) {

            if (num == n1) c1++;

            else if (num == n2) c2++;

            else if (c1 == 0) {
                n1 = num;
                c1 = 1;
            }

            else if (c2 == 0) {
                n2 = num;
                c2 = 1;
            }

            else {
                c1--;
                c2--;
            }

            // num=3 → c1=0 → n1=3, c1=1
            // num=2 → n1 se different
            // c2=0 → n2=2, c2=1
            // num=3 → num==n1
            // c1=2
        }


        c1 = c2 = 0;
        // ab candidates ki actual frequency count karenge

        for (int num : nums) {
            if (num == n1) c1++;
            else if (num == n2) c2++;

            // num=3 → c1=1
            // num=2 → c2=1
            // num=3 → c1=2
        }


        List<Integer> ans = new ArrayList<>();

        if (c1 > nums.length / 3) ans.add(n1);
        // 2 > 1 → true
        // ans = [3]

        if (c2 > nums.length / 3) ans.add(n2);
        // 1 > 1 → false

        return ans;
        // [3]
    }
}