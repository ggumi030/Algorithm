import java.util.*;

class Solution {
    public String solution(String phone_number) {
        
        StringBuilder sb = new StringBuilder();
        int len = phone_number.length();
        
        if(phone_number.length() == 4){
            return phone_number;
        } else{
            for(int i=0; i< (len - 4); i++){
            sb.append("*");
        }
        
        sb.append(phone_number.substring(len - 4));
        
        return sb.toString();
        }
        
    }
}