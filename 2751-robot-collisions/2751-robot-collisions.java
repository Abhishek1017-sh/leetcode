import java.util.*;
class Solution {
    class Robot {
        int pos, health, index;
        char dir;
        Robot(int pos, int health, char dir, int index) {
            this.pos = pos;
            this.health = health;
            this.dir = dir;
            this.index = index;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }
        Arrays.sort(robots, (a, b) -> a.pos - b.pos);
        Stack<Robot> stack = new Stack<>();
        for (Robot curr : robots) {
            if (curr.dir == 'R') {
                stack.push(curr);
            } 
            else {
                while (!stack.isEmpty() && stack.peek().dir == 'R' && curr.health > 0) {
                    Robot top = stack.peek();
                    if (top.health > curr.health) {
                        top.health--;
                        curr.health = 0;
                    } 
                    else if (top.health < curr.health) {
                        curr.health--;
                        stack.pop();
                    } 
                    else {
                        stack.pop();
                        curr.health = 0;
                    }
                }
                if (curr.health > 0) {
                    stack.push(curr);
                }
            }
        }
        List<Robot> survivors = new ArrayList<>(stack);
        Collections.sort(survivors, (a, b) -> a.index - b.index);
        List<Integer> result = new ArrayList<>();
        for (Robot r : survivors) {
            result.add(r.health);
        }
        return result;
    }
}