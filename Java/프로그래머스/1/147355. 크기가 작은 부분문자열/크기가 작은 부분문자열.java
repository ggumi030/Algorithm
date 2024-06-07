class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String[] t_arr = t.split("");
        
        for(int i = 0 ; i < t_arr.length - p.length() +1; i++){
            
            StringBuilder num = new StringBuilder();
            
            for(int j = i; j < i + p.length() ; j++){
                num.append(t_arr[j]);
            }
            
            if(Long.parseLong(num.toString()) <= Long.parseLong(p)){
                answer++;
            }
        }
        
        return answer;
    }
}