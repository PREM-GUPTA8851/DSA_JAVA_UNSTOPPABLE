import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        /*
        INPUT:

        boxTypes = [
            [5,10],  // 5 boxes m 10 units
            [2,5],   // 2 boxes m 5 units
            [4,7],   // 4 boxes m 7 units
            [3,9]    // 3 boxes m 9 units h
        ]

        truckSize = 10

        Matlab truck mein maximum 10 BOXES aa sakte hain.
        Units ki limit 10 nahi hai.
        */

        //Units per box ke descending order mein sort krte h 

        Arrays.sort(boxTypes, (a, b) ->
            Integer.compare(b[1], a[1])
        );

        /*

                      
          0      -->{     5              10 }
          1        {   3               9 }
          2         {  4               7}
          3         {  2               5 }

        Ab sabse zyada units wala box pehle aayega.
        */

        int totalUnits = 0;

        /*

        totalUnits = 0
        truckSize  = 10
        */

        for (int i = 0; i < boxTypes.length; i++) {

            // jb i = 0

            /*
            [5,10]

            boxTypes[i][0] = 5  
            boxTypes[i][1] = 10

            Truck mein 10 spaces available hain.

            Math.min(5, 10) = 5

            Matlab 5 boxes le sakte hain.

            totalUnits = 0 + (5 * 10) = 50

            truckSize = 10 - 5 = 5

            Ab tak:
            Boxes loaded = 5
            Units collected = 50
            Remaining spaces = 5
            */

            if (truckSize == 0) {
                break;
            }

            int boxes = Math.min(boxTypes[i][0], truckSize);

            totalUnits += boxes * boxTypes[i][1];

            truckSize -= boxes;

            //  i = 1

            /*
            Current row = [3,9]

            Available boxes = 3
            Remaining spaces = 5

            Math.min(3, 5) = 3

            3 boxes lenge.

            totalUnits = 50 + (3 * 9) = 77

            truckSize = 5 - 3 = 2

            Ab tak:
            Boxes loaded = 5 + 3 = 8
            Units collected = 77
            Remaining spaces = 2
            */

            // ITERATION 3: i = 2

            /*
            Current row = [4,7]

            Available boxes = 4
            Remaining spaces = 2

            Math.min(4, 2) = 2

            4 boxes available hain,
            lekin truck mein sirf 2 spaces hain.

            Isliye sirf 2 boxes lenge.

            totalUnits = 77 + (2 * 7) = 91

            truckSize = 2 - 2 = 0

            Ab tak:
            Boxes loaded = 8 + 2 = 10
            Units collected = 91
            Remaining spaces = 0
            */

            // i = 3

            /*
            Loop agle iteration mein aane se pehle
            truckSize == 0 check karega.

            0 == 0 -> true

            break execute hoga.

            [2,5] wale boxes nahi lenge,
            kyunki truck already full hai.
            isliye aapn n pehle wha p break use kiya bcz if break use n krte to vo sum hota chla jata 
            */
        }

        //  91 units
        return totalUnits;
    }
}