// https://leetcode.com/problems/group-anagrams/description/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();


        for(int i=0; i<len; i++){

            String s = strs[i];
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = Arrays.toString(c);
            if(map.containsKey(sorted)){ map.get(sorted).add(s);}
            else{ 
                List<String> t = new ArrayList<>();
                t.add(s);
                map.put(sorted, t);
            }

        }

        List<List<String>>ans =new ArrayList<>(map.values());

        return ans;

        
        
    }
}
