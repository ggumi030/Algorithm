import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int num : scoville) {
            queue.offer(num);
        }
        
        while(queue.peek() < K) {
            if(queue.size() == 1) {
                return -1;
            }

            queue.offer(queue.poll() + queue.poll() * 2);
            answer += 1;
        }
        
        return answer;
    }
}