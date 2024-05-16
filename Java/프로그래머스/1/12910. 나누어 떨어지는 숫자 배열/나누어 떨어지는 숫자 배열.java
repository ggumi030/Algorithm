import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        StringBuilder sb = new StringBuilder();
        
        for(int num : arr){
            if(num % divisor == 0){
                sb.append(num);
                sb.append(",");
            }
        }
        
        
        if(sb.length() == 0){
            answer = new int[1];
            answer[0] = -1;
            
        }else{
            String result = sb.toString();
            String[] res = result.split("\\,");
            
            answer = new int[res.length];
            int i = 0;
            for(String num : res){
                answer[i] = Integer.parseInt(num);
                i++;
            }
            
            Arrays.sort(answer);
        }
        
        return answer;
    }
}