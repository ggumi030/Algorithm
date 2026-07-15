import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 조건 충족되어도 앞에있는게 먼저 나가야함 = 큐 사용
        Queue<Integer> queue = new ArrayDeque<>();
        
        // 정답 list : 길이를 몰라서 list로 선언
        ArrayList<Integer> answer = new ArrayList<>();
        
        //progresses 배열에서 숫자 꺼내서 queue에 offer
        for(int num : progresses) {
            queue.offer(num);
        }
        
        // 제일 앞에께 peek 한 후, 
            // if : null이면 loop break;
        int current_job = 0;
        
        while(!queue.isEmpty()) {
            
            int completed_job = 0;
          
            // if : 100점이 넘으면
                // while : poll할 때 current_job + 1, completed_job + 1
                // 종료 조건 : 100점 안 넘는 게 없을 때 까지 peek and poll
                // 이번 턴의 completed_job 값을 answer list에 추가

            while(!queue.isEmpty() && queue.peek() >= 100) {
                queue.poll();
                current_job += 1;
                completed_job +=1;
            }
            
            // 0 이상인 값 작업들만 배포
            if(completed_job > 0) {
                answer.add(completed_job);

            }
                        
            // 이번 턴에 하나씩 빼서 current_job index부터 speeds.length 까지 speed 값을 더한 후, queue에 offer
            for(int i = current_job; i < speeds.length; i++) {
                int num = queue.poll();
                queue.offer(num + speeds[i]);
            }
        }
        
        //list 배열로 바꾼 후 출력
        int[] answer_arr = new int[answer.size()];
        for(int i = 0; i < answer_arr.length; i++) {
            answer_arr[i] = answer.get(i);
        }
        return answer_arr;
    }
}