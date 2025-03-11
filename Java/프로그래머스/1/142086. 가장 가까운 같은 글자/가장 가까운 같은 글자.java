import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        String[] str = s.split("");
        
        String start = str[0];
        answer[0] = -1;
        
        for(int i = 1; i < str.length; i++) {
            boolean flag = false;
            int gap = 0;
            
            for(int j = i - 1; j > -1; j--) {
                gap += 1;
                if(Objects.equals(str[i], str[j])) {
                    flag = true;
                    answer[i] = gap;
                    break;
                }
            }
            
            if(flag == false) {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}