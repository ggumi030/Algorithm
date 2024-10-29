import java.util.Objects;

class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        
        s = s.toLowerCase();
        String[] chars = s.split("");
        
        for(String ch : chars) {
            if(Objects.equals(ch,"p")) {
                p++;
            } else if(Objects.equals(ch,"y")) {
                y++;
            }
        }
        
        if(p == y) {
            return true;
        } else {
            return false;
        }
    
    }
}