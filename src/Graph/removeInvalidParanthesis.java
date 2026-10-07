package Graph;
import java.util.*;
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> answer = new ArrayList<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String current = queue.poll();
                if (valid(current)) {
                    answer.add(current);
                    found = true;
                }
                if (found) {
                    continue;
                }
                for (int i = 0; i < current.length(); i++) {
                    char c = current.charAt(i);
                    if (c != '(' && c != ')') {
                        continue;
                    }
                    String next =
                            current.substring(0, i) +
                                    current.substring(i + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            if (found) {
                break;
            }
        }
        return answer;
    }
    private boolean valid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            }
            else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
