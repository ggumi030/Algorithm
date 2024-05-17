import java.util.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        
        for(int i = 0; i <absolutes.length; i++){
            if(signs[i] == false){
                absolutes[i] = -1 * absolutes[i];
            }
        }
        
        return Arrays.stream(absolutes).sum();
    }
}