class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String[] tString = t.split("");
      
        for(int i = 0; i < t.length() - p.length() + 1; i++) {
            String partition = "";
            for(int j = 0; j < p.length(); j++) {
                partition += tString[i+j];
            }
            if(Long.parseLong(partition) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}