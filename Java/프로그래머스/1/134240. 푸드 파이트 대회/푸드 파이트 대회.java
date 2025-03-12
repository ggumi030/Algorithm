import java.lang.StringBuilder;
import java.util.Stack;

class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack();
        
        for(int i = 1; i < food.length; i++) {
            if(food[i] == 1) {
                continue;
            }
            
            for(int j = 0; j < food[i]/2; j++) {
                answer.append(i);
                stack.push(i);
            }
        }

        answer.append(0);
        
        while(!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        
        return answer.toString();
    }
}