class Solution {
    public String generateTag(String caption) {
        String[] words = caption.split(" ");
        StringBuilder tag = new StringBuilder();
        tag.append('#');
        boolean firstWord = true;
        for (String w : words) {
            if (w.length() == 0) continue;
            String word = w.toLowerCase();
            if (firstWord) {
                tag.append(word);
                firstWord = false;
            } 
            else {
                tag.append(Character.toUpperCase(word.charAt(0)));
                tag.append(word.substring(1));
            }
            if (tag.length() >= 100) break;
        }
        if (tag.length() > 100) {
            return tag.substring(0, 100);
        }
        return tag.toString();
    }
}