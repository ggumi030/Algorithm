import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        while(true){
            if(count == n){
                break;
            }
            sb.append("수");
            count++;
            
            if(count == n){
                break;    
            }
            sb.append("박");
            count++;
            
        }
        
        answer = sb.toString();
        
        return answer;
    }
}