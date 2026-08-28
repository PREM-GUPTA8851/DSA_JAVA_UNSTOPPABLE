class Solution {

    public String reorganizeString(String s) {

        // s = "vvvlo"

        int[] f = new int[26];

        for (char c : s.toCharArray()) f[c - 'a']++;
        // v=3, l=1, o=1


        int max = 0, ch = 0;

        for (int i = 0; i < 26; i++)
            if (f[i] > max) {
                max = f[i];
                ch = i;
            }

        // max=3
        // ch=21 → 'v'


        if (max > (s.length() + 1) / 2) return "";
        // 3 > 3 → false
        // possible hai


        char[] a = new char[s.length()];
        int j = 0;

        while (f[ch] > 0) {

            a[j] = (char)(ch + 'a');
            f[ch]--;
            j += 2;

            // v → a[0]='v'
            // v → a[2]='v'
            // v → a[4]='v'
            // j=6 → even positions complete
        }


        for (int i = 0; i < 26; i++) {

            while (f[i] > 0) {

                if (j >= a.length)
                    j = 1;

                a[j] = (char)(i + 'a');
                f[i]--;
                j += 2;

                // l → j=1 → a[1]='l'
                // j=3

                // o → a[3]='o'
                // j=5 → j>=5, next time j=1
            }
        }

        return new String(a);
        // "vlvov"
    }
}