class Solution {
    int middle(int a, int b, int c) {
        // code here
        // agar a middle h
        if((a > b && a < c) || (a > c && a < b)) return a;
        else if((b > a && b < c) || (b > c && b < a)) 
        return b;
        return c;
    }
}