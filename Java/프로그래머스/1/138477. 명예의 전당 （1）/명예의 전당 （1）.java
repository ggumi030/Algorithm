import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if(k < score.length) {
            for(int i = 0; i < k; i++) {
            queue.add(score[i]);
            answer[i] = queue.peek();
            }
        
        for(int i = k; i < score.length; i++) {
            queue.add(score[i]);
            queue.poll();
            answer[i] = queue.peek();
            }
        } else {
            for(int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            answer[i] = queue.peek();
            }
        }
        
        
        
        return answer;
    }
}