import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int total = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        
        // First pass: remove higher scoring pairs
        char first = (x > y) ? 'a' : 'b';
        char second = (x > y) ? 'b' : 'a';
        int highScore = Math.max(x, y);
        int lowScore = Math.min(x, y);
        
        for (char c : s.toCharArray()) {
            if (!stack1.isEmpty() && stack1.peek() == first && c == second) {
                stack1.pop();
                total += highScore;
            } else {
                stack1.push(c);
            }
        }
        
        // Second pass: remove lower scoring pairs from the remaining string
        for (char c : stack1) {
            if (!stack2.isEmpty() && stack2.peek() == second && c == first) {
                stack2.pop();
                total += lowScore;
            } else {
                stack2.push(c);
            }
        }
        
        return total;
    }
}