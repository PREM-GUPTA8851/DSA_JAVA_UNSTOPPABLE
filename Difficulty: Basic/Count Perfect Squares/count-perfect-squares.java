class Solution {
    static int countSquares(int n) {
        int count = 0;
        for(int i = 1; i * i < n; i++){
        // perfect square whi hoga jisme same number 
        // same number se multiply hoga
        // aur ans >= n ho turant break;
        count++;
        }
        return count;
    }
}