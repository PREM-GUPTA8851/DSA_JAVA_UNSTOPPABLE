class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Minimum buying price maintain karo
            minPrice = Math.min(minPrice, price);

            // Agar aaj sell kare to kitna profit hoga
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}