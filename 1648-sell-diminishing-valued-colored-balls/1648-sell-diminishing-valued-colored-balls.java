class Solution {
    int mod = (int) 1e9 + 7;
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        int i = n - 1;
        int cur = inventory[n - 1];
        long profit = 0;

        while (orders > 0) {
            while (i >= 0 && inventory[i] == cur) i--;

            int count = n - i - 1;
            int next = (i < 0) ? 0 : inventory[i];

            long total = 1L * (cur - next) * count;

            if (orders >= total) {
                profit += area(cur, next + 1, count);
                orders -= total;
            } else {
                int h = orders / count;
                int r = orders % count;

                profit += area(cur, cur - h + 1, count);
                profit += 1L * r * (cur - h);
                orders = 0;
            }

            profit %= mod;
            cur = next;
        }

        return (int) profit;
    }
    long area(int max, int min, int count) {
        return 1L * (max + min) * (max - min + 1) / 2 * count;
    }
}