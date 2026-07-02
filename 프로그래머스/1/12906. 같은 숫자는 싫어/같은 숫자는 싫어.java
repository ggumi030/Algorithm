import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int [] arr) {        
        ArrayList<Integer> list = new ArrayList<>();
        
        // 1. 배열에서 하나씩 빼서 list 에 하나씩 넣을건데, 이전 값과 다를 때만 넣기
        // list 선택한 이유 : 개수 모름, 순서 필요
        list.add(arr[0]);
        
        for(int i = 1; i < arr.length; i ++) {
            
            if(arr[i - 1] != arr[i]) {
                list.add(arr[i]);
            }
        }     
        
        // 2. list를 array로 변경
        int[] answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();

        return answer;
    }
}