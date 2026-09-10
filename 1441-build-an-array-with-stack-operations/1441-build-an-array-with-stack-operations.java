class Solution {
    public List<String> buildArray(int[] target, int n) {
    List<String> ans = new ArrayList<>();
    
    int j = 0;  // y target array ko point out krega
    // target = [1, 3] , n = 3--> 1, 2, 3
    // stream m aapn number lenge aur push krte rhenge 
    for(int i = 1; i <= n && j < target.length; i++){
        ans.add("Push");// ["Push"]
        if(i == target[j]){
            // element mil gya 
            // 1 == 1 
            j++;// next target element find krenge
        }
        else {
            // if n mila tb 
            // 2 != 3
            ans.add("Pop");
        }
    }
    return ans;
    }
}