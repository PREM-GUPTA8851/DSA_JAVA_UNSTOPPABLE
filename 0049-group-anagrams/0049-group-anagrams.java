
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


        // Input: ["eat","tea","tan","ate","nat","bat"]

        // Key = sorted string
        // Value = us key se match karne wali strings
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // String ko character array mein convert then
            char[] arr = s.toCharArray();

            // Characters ko sort karo.;
            Arrays.sort(arr);

            // Sorted characters se key banao
            String key = new String(arr);

            //  Key nahi hai toh naya group banao
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            //  Original string ko group mein add karo
            map.get(key).add(s);

            // Check by DRY RUN:
            // eat -> aet -> aet: [eat]
            // tea -> aet -> aet: [eat, tea]
            // tan -> ant -> ant: [tan]
            // ate -> aet -> aet: [eat, tea, ate]
            // nat -> ant -> ant: [tan, nat]
            // bat -> abt -> abt: [bat]
        }

        // Step 6: Map ke saare groups return karo
        return new ArrayList<>(map.values());
    }
}
