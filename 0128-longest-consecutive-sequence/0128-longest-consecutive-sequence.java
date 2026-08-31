class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0) return 0;
    // logic is this --> 
    // pehle saare element's set k andr kro
    HashSet<Integer>  set = new HashSet<>();
    // fhr array k first element se -1 krte krte search kro
    for(int num: arr){
        set.add(num);
    }
    
    // map --> 2,6,1,9,4,5,3
    int max = -1;
    for(int num: set){

    int count = 1;
    if(!set.contains(num - 1)){
    // yahi starting element hai

    int current = num;
    while(set.contains(current + 1)){
        current++;
        count++;
    }
    }
    
        max = Math.max(count, max);
    }
    // count ko increment krte jao 
    // aur if uske -1 wala element present n hua 
    // to fhr count ki value 0 kro us case me  
    return max;
    }
}