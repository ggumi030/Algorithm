import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> result = new Stack<Integer>();
       
        while(n != 0){
            result.push(n%3);
            n = n/3;
        }
        int size = result.size();
        
        for(int i =0; i < size; i++){
            answer += result.pop() * Math.pow(3,i); 
            System.out.println(answer);
        }
    
        return answer;
    }
}