import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1번 찍는 방식
        int[] first_supoja = {1, 2, 3, 4, 5};
        // 2번 찍는 방식
        int[] second_supoja = {2, 1, 2, 3, 2, 4, 2, 5};
        // 3번 찍는 방식
        int[] third_supoja = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 정답 수
        int first_answers = 0;
        int second_answers = 0;
        int third_answers = 0;
        // for answers[].length
        // 1,2,3번 찍는 방식 == answer[] 이면 정답 수를 count + 1
        // 찍는 번호는 현재 문제 번호 % 찍는 방식 배열 length
        for(int i = 0; i < answers.length; i++ ) {
            if(first_supoja[i % first_supoja.length] == answers[i]) {
                first_answers += 1;
            }
            
            if(second_supoja[i % second_supoja.length] == answers[i]) {
                second_answers += 1;
            }
            
            if(third_supoja[i % third_supoja.length] == answers[i]) {
                third_answers += 1;
            }
        }
        
        // max 찾기 
        // 변수 max에 1번 정답 수 넣고, 
            // 2번이 더 많으면 max를 2번으로,
            // 2번이 더 적으면 Max를 1번으로,
            // 2번이랑 같으면 
                // 3번이 더 많으면 max를 3번으로,
                // 3번이 더 적으면 1,2번 return 배열에 넣기
                // 3번이랑 같으면 1,2,3번 return 배열에 넣기
        int max = first_answers;
        int max_person = 1;
        boolean same_flag = false;
        ArrayList<Integer> same = new ArrayList<>();
        
        if(max < second_answers) {
            max = second_answers;
            max_person = 2;
            
            if(max < third_answers) {
                max = third_answers;
                max_person = 3;
            } else if (max == third_answers) {
                same.add(2);
                same.add(3);
                same_flag = true;
            }

        } else if (max == second_answers) {
            same.add(1);
            same.add(2);
            same_flag = true;
            
            if(max < third_answers) {
                max = third_answers;
                max_person = 3;
                same_flag = false;
            } else if (max == third_answers) {
                same.add(3);
                same_flag = true;
            }
        } else {
            if(max < third_answers) {
                max = third_answers;
                max_person = 3;
            } else if (max == third_answers) {
                same.add(1);
                same.add(3);
                same_flag = true;
            }
        }
        
        int[] answer;
                
        if(same_flag == false) {
            answer = new int[1];
            answer[0] = max_person;
            
        } else {
            answer = new int[same.size()];
            int i = 0;
            for(int person : same) {
                answer[i] = person;
                i++;
            }
        }
        
        return answer;
    }
}