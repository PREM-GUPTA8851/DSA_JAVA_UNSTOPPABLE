class Solution {
    void rearrange(ArrayList<Integer> nums) {

        // Firstly 2 ArrayList create krenge
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // +ve and -ve elements alag store krenge
        for (int num : nums) {
            if (num >= 0)    // 0 ko bhi positive maana hai
                pos.add(num);
            else
                neg.add(num);
        }

        // Original array me alternate store krenge
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < pos.size() && j < neg.size()) {
            nums.set(index++, pos.get(i++));
            nums.set(index++, neg.get(j++));
        }

        // Agar positive elements bach gaye
        while (i < pos.size()) {
            nums.set(index++, pos.get(i++));
        }

        // Agar negative elements bach gaye
        while (j < neg.size()) {
            nums.set(index++, neg.get(j++));
        }
    }
}