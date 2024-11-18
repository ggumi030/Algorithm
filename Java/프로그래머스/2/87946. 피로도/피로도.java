import java.lang.Math; 
    
class Solution {
    private static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
       
        permute(dungeons, 0, k);
        
        return answer;
    }
    
    private void permute(int[][] dungeons, int depth, int blood) {
        if(depth == dungeons.length) { 
            int cnt = 0;
            for(int i = 0; i < dungeons.length; i++) {     
                if(dungeons[i][0] <= blood) {
                    blood -= dungeons[i][1];
                    cnt++;
                } else {
                    break;
                }
            }
            answer = Math.max(answer,cnt);
            return;
        }
        
        for(int i = depth; i < dungeons.length; i++) {
            swap(dungeons, depth, i);
            permute(dungeons, depth +1, blood);
            swap(dungeons, depth, i);
        }
    }
    
    private void swap(int[][] dungeons, int i, int j) {
        int[] temp = dungeons[i];
        dungeons[i] = dungeons[j];
        dungeons[j] = temp;
    }
}