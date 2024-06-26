import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int from = commands[i][0] - 1;
            int to = commands[i][1];
            int num = commands[i][2] - 1;
            
            int[] sub = Arrays.copyOfRange(array,from,to);
            Arrays.sort(sub);
            answer[i] = sub[num];
        }
        return answer;
    }
}