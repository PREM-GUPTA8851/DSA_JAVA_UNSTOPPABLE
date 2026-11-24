class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
        // Output: 8        

        // Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
        // Output: 91 = 
        // 5 * 10 = 50
        // 2 * 5 = 10
        // 3 * 7 = 21 
        // total = 81 

        // 5, 10
        // 3, 9
        // 4, 7

        // but hume isko maximise krna h so max tb hi aaega jb aapn k pass units highest se ho (means in decresing order m ho)
        // so pehle boxTypes ko ek array m insert krenge

        // then descending order m sort krenge
        Arrays.sort(boxTypes, (a, b) ->  Integer.compare(b[1], a[1]));
        int profit = 0;

        int capacity = truckSize ;
        for(int i = 0; i < boxTypes.length; i++){

        // hume if capactiy 0 mil jaegi break kr denge loop k andr
        if(truckSize == 0) break;
        // jb last case aaega edge case y starting se hi 
        // aapn minimum remaining capacity aur current number of boxes se boxes k number nikalenge 
        capacity = Math.min(boxTypes[i][0], truckSize);
        // aur hr case m profit calculate krenge by product of number of boxed and number of units per box
        profit += capacity * boxTypes[i][1];

        // fhr trucksize me se hr baar number of boxes ko subtract krte jaenge 
        truckSize -= capacity;
        }
        // then after loop profit return krwa denge
        return profit;
    }
}