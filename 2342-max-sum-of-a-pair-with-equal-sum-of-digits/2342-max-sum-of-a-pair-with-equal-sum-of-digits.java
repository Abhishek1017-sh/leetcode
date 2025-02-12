class Solution {
    static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        for (int num : nums){
            int sumDigits = digitSum(num);
            if (map.containsKey(sumDigits)) {
                maxSum = Math.max(maxSum, num + map.get(sumDigits));
                map.put(sumDigits, Math.max(map.get(sumDigits), num));
            } 
            else{
                map.put(sumDigits, num);
            }
        }
        return maxSum;
    }
}