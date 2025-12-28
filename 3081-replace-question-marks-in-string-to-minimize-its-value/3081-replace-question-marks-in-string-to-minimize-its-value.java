class Solution {
    public String minimizeStringValue(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (ch != '?')  {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        List<Character> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                pos.add(i);
            }
        }
        for (int i = 0; i < pos.size(); i++) {
            int freq = Integer.MAX_VALUE;
            for (char c = 'a'; c <= 'z'; c++) {
                freq = Math.min(map.getOrDefault(c, 0), freq);
            }
            for (char c = 'a'; c <= 'z'; c++) {
                if (freq == map.getOrDefault(c, 0)) {
                    ans.add(c);
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    break;
                }
            }
        }
        Collections.sort(ans);
        int j = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i : pos) {
            sb.setCharAt(i, ans.get(j++));
        }
        return sb.toString();
    }
}