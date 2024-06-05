class Solution {
    public String solution(String s) {
        String original = s;
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] ministr;
        String toggle;
        
        for(String str : s.split(" ")){
            
            ministr = new String[str.length()];
            ministr = str.split("");
            
            for(int i =0; i < ministr.length; i++){
                if(i%2 == 0){
                   toggle = ministr[i] + "";
                    sb.append(toggle.toUpperCase());
                }else{
                    toggle = ministr[i] + "";
                    sb.append(toggle.toLowerCase());
                }
            }
            sb.append(" ");
        }
        
        while(original.length() != sb.length()){
            
            if(original.length() > sb.length()){
               sb.append(" ");
            }else{
                sb.deleteCharAt(sb.length()-1); 
            }
        }
        
        
        answer = sb.toString();
        return answer;
    }
}