class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        // Har box type ko units per box ke descending order mein sort karo
        Arrays.sort(boxTypes, (a, b) ->
            Integer.compare(b[1], a[1])
        );

        int totalUnits = 0;

        for (int i = 0; i < boxTypes.length; i++) {

            if (truckSize == 0) {
                break;
            }

            int boxes = Math.min(boxTypes[i][0], truckSize);

            totalUnits += boxes * boxTypes[i][1];

            truckSize -= boxes;
        }

        return totalUnits;
    }
}