import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(String num : nums){
            s = s.replace(num,String.valueOf(i));
            i++;
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
}