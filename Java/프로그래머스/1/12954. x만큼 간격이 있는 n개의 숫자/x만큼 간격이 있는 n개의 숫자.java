import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.IntStream;

class Solution {
    public ArrayList<Long> solution(int x, int n) {
        
        ArrayList<Long> answer = new ArrayList<Long>();
        long sum = x;
        
        for(int i = 0 ; i < n ; i++){
            answer.add(sum);
            sum += x;
        }
        
        return answer;
    }
}