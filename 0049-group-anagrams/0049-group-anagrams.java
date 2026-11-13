class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       // group anagrams  
        // Input: ["eat","tea","tan","ate","nat","bat"]
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        //anagrams --> string ko sort kro aur after sort jo string bni same whi doosri string ko krne m hua usko anagram bolte h but that should be same size.

    // eat --> after sort --> aet
    // tea --> AS--> aet
    // ate --> AS--> aet 
    // aet aapn k pass aa gye same aur vo baki 3 string ko sort k baad same result deta h 
    // anagrams yha p aet k --> tea, ate, eat
    // bat --> abt
    // abt k --> bat
    // nat --> ant
    // tan --> ant
    // anagram ant k -->nat, tan

    // hashmap use hoga key m string aur value m multiple string aa rhi so list use krke krna hoga
    HashMap<String, List<String>> map = new HashMap<>();
    // flowchart--> pehle aapn strings lenge // eat
    for(String s: strs){
    String str = s; // eat
    // fhr usko charArray m convert
    char[] temp = s.toCharArray(); // ['e','a','t']
    // then uske characters ko sort
    Arrays.sort(temp);
    // aet
    // now converted into string bcz hashmap m key string h
    String temp_ = new String(temp);
    // then map m key sort wale string ko key add krenge
    // pehle map m check krenge ki vo sorted key already present ho n h 
    if(!map.containsKey(temp_)){
        map.put(temp_,new ArrayList<>());// aet-->[]
    }
    // ant --> tan
    // ant --> tan, nat
    map.get(temp_).add(str);
    }
    // aur fhr at last map ki value return kr denge
    return new ArrayList<>(map.values());
    }
}