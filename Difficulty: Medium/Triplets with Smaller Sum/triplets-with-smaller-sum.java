class Solution {
    int countTriplets(int sum, int arr[]) {

        // sum = 12
        // arr = [5,1,3,4,7]

        Arrays.sort(arr);
        // arr = [1,3,4,5,7]

        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                if (arr[i] + arr[left] + arr[right] < sum) {

                    count += right - left;
                    left++;

                } else {
                    right--;
                }

                // i=0 → arr[i]=1
                // left=1, right=4
                // 1+3+7 = 11 < 12
                // count += 4-1 = 3
                // count = 3
                // left = 2

                // left=2, right=4
                // 1+4+7 = 12
                // 12 < 12 false
                // right = 3

                // left=2, right=3
                // 1+4+5 = 10 < 12
                // count += 3-2 = 1
                // count = 4
                // left = 3

                // left == right → loop stop


                // i=1 → arr[i]=3
                // left=2, right=4
                // 3+4+7 = 14
                // false → right=3

                // 3+4+5 = 12
                // false → right=2
                // loop stop


                // i=2 → arr[i]=4
                // left=3, right=4
                // 4+5+7 = 16
                // false → right=3
                // loop stop
            }
        }

        return count;
        // count = 4
    }
}