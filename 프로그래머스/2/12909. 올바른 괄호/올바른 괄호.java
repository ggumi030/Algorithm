import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        // 조건
        // 1. (이면 넣고 )이면 뺀다
        // 2. )일 때 peek했는데 (이 아니거나 Null이면 
        // answer로 false를 return 한다
        
        // 풀이
        // 0. Deque 선언
        Deque<Character> stack = new ArrayDeque<>();
        // 1. String을 하나씩 쪼개서 char 배열에 넣는다.
        char[] chars = s.toCharArray();
        // 2. char 배열을 순회하면서 조건 충족성을 본다.
            // 2-1. (이면 넣는다.
            // 2-2. )이면 
                // 2-2-1. isEmpty() 확인 > 맞으면 false 반환
                // 2-2-2. peek() 했을 때 (이 아니면 false 반환
                // 2-2-3. pop한다.
        for(char c : chars) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                if('(' != stack.peek()) return false;
                stack.pop();
            }
        }
        // 3. stack이 비어있지 않으면 return false
        // 비어있으면 return true를 한다.
        if(!stack.isEmpty()) return false;
        return true;
    }
}