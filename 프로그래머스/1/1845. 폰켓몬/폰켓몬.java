import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int choice = nums.length/2;
        
        Map<Integer, Integer> pocket = new HashMap<>();
        // nums 순회하면서 hash에 포켓몬 번호, +1 저장
        for(int number : nums) {
            pocket.put(number, pocket.getOrDefault(number, 0) + 1);
        }
        // hash key를 전체 순회하면서 answer +1해
        for(int number : pocket.keySet()) {
            if(choice == 0) break;
            answer +=1;
            choice -=1;
        }
        // answer값 반환
        return answer;
    }
}