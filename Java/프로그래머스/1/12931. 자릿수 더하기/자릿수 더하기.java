import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        for(int i = (int)(Math.log10(n)) ; i >= 0 ; i--){
            int num = n / (int)Math.pow(10,i);
            answer += num;
            n -= num * Math.pow(10,i);
        }
        

        return answer;
    }
}