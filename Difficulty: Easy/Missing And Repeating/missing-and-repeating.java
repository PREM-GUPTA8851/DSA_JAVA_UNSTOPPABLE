class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
    // duplicate number (repeating number) 
    // [1,3,3]
    // [2,2]
    ArrayList<Integer> ans = new ArrayList<>();
    
    for(int i = 0; i < arr.length; i++){
        // i = 0;
        // i = 1;
        // i = 2;
        
        // i = 0;
        int index = Math.abs(arr[i]) - 1;// arr[0] // 1 - 1 = 0
        // index = arr[0] = 1 -1 = 0
        // index = arr[1] = 3 -1 = 2
        // index = arr[2] = 3 - 1 = 2
        
        // index = arr[0] = 2 - 1 = 1
        if(arr[index] < 0) {
            // already -ve h to means duplicate element whi h 
            ans.add(Math.abs(arr[i])); // 3
        }
        // ab -ve mark kro 
        else 
            arr[index] *= -1;
        // arr[0] = -1; --> [-1, 3, 3]
        // arr[2] = -1; --> [-1, 3, -3]
        
    }
    
    // and if any index value is +ve then return that value as missing number
    for(int i = 0; i < arr.length; i++){
        if(arr[i] > 0){
            ans.add(i + 1);
        }
    }
    return ans;
    }
}
