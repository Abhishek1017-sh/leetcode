class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10) return 0;
            if (result < Integer.MIN_VALUE / 10) return 0;
            int rem = x % 10;
            result = (result * 10) + rem;
            x = x / 10;
        }
        return result;
    }
}