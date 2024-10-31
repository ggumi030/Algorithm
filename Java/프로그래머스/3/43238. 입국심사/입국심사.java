import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long left = times[0];
        long right = (long) times[times.length - 1] * n;
        
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long guessN = 0;
            
            for(int time : times) {
                guessN += mid / time;
            }
            
            if(guessN < n) {
                left = mid + 1;
            } else {
                answer = Math.min(answer,mid);
                right = mid - 1;
            }
        }
        
        return answer;
    }
}