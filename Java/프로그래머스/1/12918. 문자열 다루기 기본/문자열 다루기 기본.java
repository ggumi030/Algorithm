class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() !=4 && s.length() != 6){
            return false;
        }
        
        String[] arr = s.split("");
        for(String num : arr){
            switch(num){
                case "0" : answer = true; 
                    break;
                case "1" : answer = true; 
                    break;
                case "2" : answer = true; 
                    break;
                case "3" : answer = true; 
                    break;
                case "4" : answer = true; 
                    break;
                case "5" : answer = true; 
                    break;
                case "6" : answer = true; 
                    break;
                case "7" : answer = true; 
                    break;
                case "8" : answer = true; 
                    break;
                case "9" : answer = true; 
                    break;
                default : return false;
            }    
        }
        
        
        return answer;
    }
}