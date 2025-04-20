class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int sum = 0;
        for (int x : map.keySet()) {
            int count = map.get(x);
            int groupSize = x + 1;
            int groups = (count + x) / groupSize;
            sum += groups * groupSize;
        }
        return sum;
    }
}