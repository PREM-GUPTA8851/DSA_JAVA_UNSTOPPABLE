class Solution {
    public ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        // ans = {1};
        
        for(int x = 2; x <= n; x++){
            int carry = 0;
            for(int i = 0; i < ans.size(); i++){
                int product = ans.get(i) * x + carry;
                // 1 *2 + 0 --> 2
                // 2 * 3 + 0 = 6
                // 6 * 4 + 0 = 24
                // 4 * 5 + 0 = 20
                ans.set(i, product % 10);
                // {2}
                // {6} 
                // 4, 2  
                carry = product / 10;
                // c = 0
                // c = 0
                // 2
            }
            // agar carry bachegi tb 
                while(carry > 0){
                    ans.add(carry % 10);
                    // 4, 2
                    carry /= 10;
                }
        }
        Collections.reverse(ans);
        return ans;
    }
}