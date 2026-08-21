class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int i = 1;

        while (i < intervals.length) {

            if (intervals[i][0] <= end) {

                end = Math.max(end, intervals[i][1]);

            } else {

                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);

                ans.add(temp);

                start = intervals[i][0];
                end = intervals[i][1];
            }

            i++;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);

        ans.add(temp);

        return ans;
    }
}