class Solution {
    public List<Integer> maxPrimes(int n, int s) {
       List<Integer> ans = new ArrayList<>();

        if(n < 2 || s < 2) return ans;

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i <= n; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= n; j += i){
                    isPrime[j] = false;
                }
            }
        }

        int sum = 0;

        for(int i = 2; i <= n; i++){
            if(isPrime[i]) {
                if(sum + i > s) break;
                ans.add(i);
                sum += i;
            }
        }
        return ans;
    }
}