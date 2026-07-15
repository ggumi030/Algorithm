import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        // 결과 배열
        int[] answer = new int[commands.length];
        int answer_count = 0;
        
        // i-1, j-1, k-1 = 인덱스
        
        // part_array commands.length 만큼 새로 생성
        for(int i = 0; i < commands.length; i++) {
            
            int num_first = commands[i][0];
            int num_middle = commands[i][2];
            int num_last = commands[i][1];
            
            // part_array length는 array[n][1] - array[n][0] + 1
            int[] part_array = new int[num_last - num_first + 1];
            // for 
            // array[i-1] 부터 array[j-1]까지 part_array에 넣기
            // part_array에서 k-1번째 수를 answer 배열에 넣기
            int count = 0;
            for(int j = num_first - 1 ; j < num_last; j++) {
                part_array[count] = array[j];
                count += 1;
            }
            
            Arrays.sort(part_array);
            
            answer[answer_count] = part_array[num_middle - 1];
            answer_count += 1;
        }
        
        return answer;
    }
}