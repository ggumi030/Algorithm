import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        int min = 0;
        int j = 0;
        
        if(arr.length == 1){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[arr.length-1];
            min = arr[0];
            for(int i = 1; i < arr.length; i++){
                if(min > arr[i]){
                    min = arr[i];    
                }
            }
            
            int i = 0;
            
            while(i != arr.length){
                if(min == arr[i]){
                    i++;
                    continue;
                }
                answer[j] = arr[i];
                j++;
                i++;
            }
            
        }
        
        return answer;
    }
}