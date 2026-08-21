class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        // tese case 
        //arr -->  - 8 -10 -10 -10 10 6 1 10
        
        // sort an array
        Arrays.sort(arr);
        // -10 -10 -10 -8 1 6 10 10
        
        int i = 0; 
        int j = arr.length - 1; //7
        
        while(i < j){
            
        int sum = arr[i] + arr[j] ;// -10 + 10 = 0 
            if(sum == 0) {
                // pair mil gya ab store krna h 
                ArrayList<Integer> pair = new ArrayList<>();
                
                pair.add(arr[i]); // [-10]
                pair.add(arr[j]); // [-10, 10]
                
                ans.add(pair); // [-10, 10]
                
                // now handling duplicate elements
                int left = arr[i];// -10
                int right = arr[j]; // 10
                
                while(i < j && arr[i] == left){
                    i++;
                }
                
                
                while(i < j && arr[j] == right){
                    j--;
                }
            }
            
            else if(sum < 0){
                i++;
            }
            else {
                j--;
            }
        }
        return ans;
    }
}
