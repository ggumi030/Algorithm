import java.util.Objects;
class Solution {
    public int solution(String s) {
        int answer = 0;
       
        while(s.length() > 0) {
            
            if(s.length() == 1){
                return ++answer;
            }
            
            char x = s.charAt(0);
            long xNum = 1;
            long yNum = 0;
     
            for(int j = 1; j < s.length(); j++) {    
                if(Objects.equals(x, s.charAt(j))) {
                    xNum++;
                }else {
                    yNum++;
                }
                
                if(j == s.length() - 1) {
                    return ++answer;
                } else if(xNum == yNum) {
                    s = s.substring(j+1);
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}