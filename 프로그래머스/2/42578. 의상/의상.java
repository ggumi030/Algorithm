import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 종류별로 입을 수 있는 개수 count
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        // 종류별로 안 입는 경우 + 1 해서 정답에 곱하기
        for(Integer num : map.values()) {
            answer *= (num + 1);
        }  
        
        // 모두 안 입는 1가지 경우 빼기
        answer -= 1;
        
        return answer;
    }
}