class Solution {
	int maxProduct(int[] arr) {
	     
        /*
        We maintain minProduct as well because multiplying a 
        negative number with the minimum product can produce the 
        maximum product.
        */
        int maxProd = arr[0] ;// -2
        int minProd = arr[0]; // -2
        int ans = arr[0]; // -2
        
        for(int i = 1; i < arr.length; i++){
            // if arr[i] current element is -ve so we swap 
            // 1 --> 6
            // 2--> -3 --> swap maxProd = -12
            if(arr[i] < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            
            maxProd = Math.max(arr[i], maxProd * arr[i]); 
            // 6, -12 --> 6
            minProd = Math.min(arr[i], minProd * arr[i]); 
            // 6, -12 --> -12
            
            ans = Math.max(ans, maxProd);
            // 6
        }
        
        return ans;
		
	}
}
