
class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int count = 0;
        
        for(String name : seoul){
            
            if( "Kim".equals(name)){
                answer = "김서방은 " + count +"에 있다";
                break;
            }
            
            count ++;
        }
        
        return answer;
        
    }
}