class Solution {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        int n = words.length;
        for (int i = 1; i < n; i++) {
            String key = words[i];
            int j = i - 1;
            while (j >= 0 && words[j].length() > key.length()) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = key;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) result.append(" ");
            result.append(words[i]);
        }
        result.setCharAt(0, Character.toUpperCase(result.charAt(0)));
        return result.toString();
    }
}