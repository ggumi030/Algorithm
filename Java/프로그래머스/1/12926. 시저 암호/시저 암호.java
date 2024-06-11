class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] ch = s.toCharArray();
        int[] ascii = new int[ch.length];
        int i = 0;
        
        for(char cha : ch){
            ascii[i] = cha;
            i++;
        }
        
        i = 0;
        
        for(int asc : ascii){
            for(int j=0; j < n; j++){
             if( 65 <= asc && asc < 90 ){
                asc += 1;
                ch[i] = (char) asc;
                
            }else if(97 <= asc && asc < 122){
                asc += 1;
                ch[i] = (char) asc;
                
            }else if(asc == 90 || asc == 122){
                asc -= 25;
                ch[i] = (char) asc;
            }else {
                ch[i] = (char) asc;
            }   
            }
            i++;
        }
        
        answer = String.valueOf(ch);
        
        return answer;
    }
}