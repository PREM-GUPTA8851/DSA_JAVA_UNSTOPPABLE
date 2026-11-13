class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // cbaebabacd --> find krna h abc
        // pehle to jitna length k p h utne size k window bnaenge
        // cba --> abc == abc --> match --> add 0th index
        // bae --> aeb NE
        // aeb --> aeb NE
        // eba --> abe NE
        // bab --> abb NE
        // aba --> aab NE
        // bac --> abc == abc --> match --> add 6th index

        // pehle aapn string se substring nikalenge j - i + 1 size ki aur uske pehle y dono 0 p point krnge then aapn grab krenge y j - i + 1 part string se aur us part ko sort krenge then check krenge if equal hua to index store krenge aur n hua to continue then return arraylist -->TC O(n k log k) aur s O(n*k)
    //  List<Integer> ans = new ArrayList<>();

    //     int n = s.length();
    //     int k = p.length();

    //     if (k > n) return ans;

    //     char[] pArr = p.toCharArray();
    //     Arrays.sort(pArr);

    //     for (int i = 0; i <= n - k; i++) {

    //         // Length k ka substring nikalo
    //         String sub = s.substring(i, i + k);

    //         // Substring ko sort karo
    //         char[] temp = sub.toCharArray();
    //         Arrays.sort(temp);

    //         // Sorted substring ko sorted p se compare karo
    //         if (Arrays.equals(pArr, temp)) {
    //             ans.add(i);
    //         }
    //     }

    //     return ans;
        // another optimised version --> frequency + Hashmap
        // aapn pehle string aur pattern ki char frequecy store krenge aur match krenge ki vo equal h y nhi if it is equal then add 0 bcz it is found in first 0th index              
    // calculate height also
    int n = s.length();
    int k = p.length();
    
    ArrayList<Integer> ans = new ArrayList<>();
    // edge case indexOutOfBoundsException
    if(k > n) return ans;
    // pehle dono k liye 26 char k array create krenge
    int[] wfreq = new int[26];
    int[] pfreq = new int[26];

    // now we have[0,0,0......] upto 26 index
    // pehle pattern k char ki freq store krenge
    for(int i = 0; i < k; i++){
        // pattt--> a 
        
        pfreq[p.charAt(i) - 'a']++;
        wfreq[s.charAt(i) - 'a']++;
    }

    if(Arrays.equals(pfreq, wfreq)){
    ans.add(0); // 0
    }

    // now sliding window concept
    for(int i = k; i < n; i++){
    // ab apn next char ki freq decrement krenge aur 
    wfreq[s.charAt(i - k) - 'a']--;
    //previous char ki freq increment krenge usi window size 
    wfreq[s.charAt(i) - 'a']++;
    //check krte rhenge ki pattern k array k equal hui y nhi hui to start index add kr denge
    if(Arrays.equals(wfreq, pfreq)){
        int start = i - k + 1;
        ans.add(start);
    }

    }
    return ans;
    }
}
