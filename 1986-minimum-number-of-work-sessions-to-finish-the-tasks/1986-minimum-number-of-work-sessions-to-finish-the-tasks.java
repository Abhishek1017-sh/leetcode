class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int cnt = 1;
        int time = sessionTime;
        for (int i = tasks.length - 1; i >= 0; i--) {
            if (sessionTime - tasks[i] >= 0) {
                sessionTime -= tasks[i];
            } 
            else {
                cnt++;
                sessionTime = time;
                sessionTime -= tasks[i];
            }
        }
        return cnt;
    }
}