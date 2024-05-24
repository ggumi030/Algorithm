import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(arr);
        
        for(char c : arr){
            sb.append(c);
        }
        answer = sb.reverse().toString();
        return answer;
    }
}