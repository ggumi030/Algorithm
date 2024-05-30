import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        for(int i=1; i <= min; i++){
           if(n%i == 0 && m%i == 0){
               answer[0] = i;
           } 
        }
        
        answer[1] = max * min / answer[0];
        
        return answer;
    }
}