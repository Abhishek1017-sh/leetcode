class Solution {
    public int minimumBuckets(String n) {
        char[] hamsters =n.toCharArray();
        for (int i = 0; i < hamsters.length; i++) {
            if (hamsters[i] == 'H') {
                if (i - 1 >= 0 && hamsters[i - 1] == 'B') {
                    continue;
                }
                if (i + 1 < hamsters.length && hamsters[i + 1] == '.') {
                    hamsters[i + 1] = 'B';
                } 
                else if (i - 1 >= 0 && hamsters[i - 1] == '.') {
                    hamsters[i - 1] = 'B';
                } 
                else {
                    return -1;
                }
            }
        }
        int count = 0;
        for (char c : hamsters) {
            if (c == 'B') count++;
        }
        return count;
    }
}