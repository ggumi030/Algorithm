import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 1. 정렬 
        Arrays.sort(phone_book);
        
        // 2. 현재 인덱스와 다음 인덱스 비교를 N까지 돌림
        // 만약 startWith해 있다면 answer를 false로 변경
        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        // 3. 결과 출력
        return answer;
        
    }
}