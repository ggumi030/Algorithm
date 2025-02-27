import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j <numbers.length; j++) {
                if(i != j && !(list.contains(numbers[i] + numbers[j]))) {
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}